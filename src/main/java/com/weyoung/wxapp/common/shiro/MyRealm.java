package com.weyoung.wxapp.common.shiro;

import com.alibaba.fastjson.JSON;
import com.weyoung.wxapp.common.service.RedisService;
import com.weyoung.wxapp.common.util.JWTUtil;
import com.weyoung.wxapp.common.util.StringUtil;
import com.weyoung.wxapp.system.domain.UserOnline;
import org.apache.ibatis.javassist.expr.NewExpr;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;

/**
 * @author Pushy
 * @since 2018/11/20 21:09
 */
@Component
public class MyRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisService redisService;

    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof JwtToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = "123456";
//        String token = (String) auth.getPrincipal();
//        if (StringUtil.isStrEmpty(token)) {
//            throw new AuthenticationException("Empty token.");
//        }
//        // 解密Token
//        String id = null;
//        try {
//            id = JWTUtil.decode(token);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        if (id == null) {
//            // 解密失败，抛出异常
//            throw new AuthenticationException("Invalid token.");
//        }
//        // 开放管理系统token绿色通道
//        if (redisService.get(id) == null && !"welfare-admin".equals(id)) {
//            // token失效，删掉在线用户信息
//            redisService.del(token);
//            // token失效
//            throw new AuthenticationException("Expired token.");
//        }
//        String onlineUser = redisService.get(token);
//        // 更新最新访问时间
//        if (onlineUser != null) {
//            UserOnline user = JSON.parseObject(onlineUser, UserOnline.class);
//            user.setLastAccessTime(new Date());
//            redisService.set(token, JSON.toJSONString(user));
//        }
        // 解密成功，返回SimpleAuthenticationInfo对象
        return new SimpleAuthenticationInfo(token, token, "myRealm");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String id = JWTUtil.decode(principals.toString());

        if (id != null) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            // 获取当前用户的所有角色，并且通过addRole添加到simpleAuthorizationInfo当中
            // 这样当Shiro内部检查用户是否有某项权限时就会从SimpleAuthorizationInfo中拿取校验
            return simpleAuthorizationInfo;
        }
        return null;
    }
}
