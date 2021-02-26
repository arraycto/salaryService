package com.weyoung.wxapp.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weyoung.wxapp.common.domain.QueryRequest;
import com.weyoung.wxapp.common.exception.UnauthorizedException;
import com.weyoung.wxapp.common.service.RedisService;
import com.weyoung.wxapp.common.shiro.JwtToken;
import com.weyoung.wxapp.common.util.GetOpenid;
import com.weyoung.wxapp.common.util.HttpContextUtils;
import com.weyoung.wxapp.common.util.IPUtils;
import com.weyoung.wxapp.common.util.JWTUtil;
import com.weyoung.wxapp.common.domain.LoginSuccessVo;
import com.weyoung.wxapp.system.domain.UserOnline;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected RedisService redisService;

    protected Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 返回当前用户标识：这里对应staffId
     *
     * @return
     */
    protected String getCurrentUser() {
        // 从token中解密userId
        String token = (String) getSubject().getPrincipal();
        logger.info("token:{}", token);
        String userId = JWTUtil.decode(token);
        return userId;
    }

    protected void login(AuthenticationToken token) {
        getSubject().login(token);
    }

    protected void logout() {
        getSubject().logout();
    }

    protected Map<String, Object> selectByPageNumSize(QueryRequest request, Supplier<?> s) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        PageHelper.clearPage();
        return getDataTable(pageInfo);
    }

    private Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    /**
     * 获取微信小程序openid
     *
     * @param jsCode
     * @return
     */
    protected String parseOpenid(String jsCode) {
        String openid = redisService.get(jsCode);
        if (openid == null) {
            GetOpenid getOpenid = new GetOpenid();
            // 获取openid
            String rs = getOpenid.GetOpenid(jsCode);
            logger.info("wx: {}", rs);
            // 转化为json对象
            JSONObject jsonObject = JSONObject.parseObject(rs);
            if (jsonObject.getIntValue("errcode") == 0) {
                openid = jsonObject.getString("openid");
                redisService.set(jsCode, openid);
                redisService.pexpire(jsCode, JWTUtil.EXPIRED_TIME);
            } else {
                // js_code有误
                throw new UnauthorizedException(jsonObject.getString("errmsg"));
            }
        }
        return openid;
    }

    /**
     * 登录成功设置token
     *
     * @param successVo
     * @return
     */
    protected boolean setToken(LoginSuccessVo successVo, HttpServletResponse response) {
        // 登录成功返回合法token
        String userId = successVo.getStaffId().toString();
        String token = redisService.get(userId);
        if (token == null) {
            // 生成新token放入redis缓存
            token = JWTUtil.encode(userId);
            redisService.set(userId, token);
            redisService.pexpire(userId, JWTUtil.EXPIRED_TIME);
        }
        successVo.setToken(token);
        // 调用shiro框架完成登录认证
        login(new JwtToken(token));
        setAuthHeaders(response, token);

        // 存储在线用户
        updateOnlineUser(successVo);
        return false;
    }

    private void updateOnlineUser(LoginSuccessVo successVo) {
        UserOnline userOnline = new UserOnline();
        userOnline.setStartTimestamp(new Date());
        userOnline.setLastAccessTime(new Date());
        userOnline.setUsername("小程序-"+successVo.getRealName());
        userOnline.setUserId("wx"+successVo.getStaffId());
        String ipAddr = IPUtils.getIpAddr(HttpContextUtils.getHttpServletRequest());
        userOnline.setHost(ipAddr);
        userOnline.setLocation(IPUtils.getCityInfo(ipAddr));
        userOnline.setStatus("1");
        userOnline.setId((String)getSubject().getPrincipal());

        redisService.set(userOnline.getId(), JSON.toJSONString(userOnline));
    }

    protected void setAuthHeaders(HttpServletResponse response, String token) {
        // 将token写入header
        response.setHeader("Authorization", token);
        // 解决跨域问题
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
    }
}
