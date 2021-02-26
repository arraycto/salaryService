package com.weyoung.wxapp.common.shiro;

import com.weyoung.wxapp.common.service.RedisService;
import com.weyoung.wxapp.common.util.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author Pushy
 * @since 2018/11/20 22:06
 */
public class ShiroFilter extends BasicHttpAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private RedisService redisService;

    public ShiroFilter(RedisService redisService) {
        this.redisService = redisService;
    }

    /**
     * 这里是在该方法内检查Token头是否为空
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        return req.getHeader("token") != null;
    }

    /**
     * 调用Realm执行登录，并返回登录认证的结果
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws AuthenticationException {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("token");

        JwtToken token = new JwtToken(authorization);
        // 当调用Subject对象的login方法时，将会交给我们自己实现的MyRealm来处理登录的认证逻辑
        // 如果错误他会抛出异常并被捕获
        try {
            Subject subject = getSubject(request, response);
            subject.login(token);
        } catch (Exception e) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setHeader("errMsg", e.getMessage());
            return false;
        }
        // 验证通过，更新过期时间
        String staffId = JWTUtil.decode(authorization);
        if (redisService.get(staffId) != null) {
            redisService.pexpire(staffId, JWTUtil.EXPIRED_TIME);
            // 将token写入header
            ((HttpServletResponse) response).setHeader("Authorization", authorization);
            // 解决跨域问题
            ((HttpServletResponse) response).setHeader("Access-Control-Expose-Headers", "Authorization");
        }
        return true;
    }

    /**
     * 首先调用的一个方法，在该方法内进行主要的认证逻辑处理，如判断Token头是否为空，解密Token等
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginAttempt(request, response)) {
            // 执行登录
            boolean result = executeLogin(request, response);
            // 登录失败，返回401错误
            if (!result) {
                return abort401(request, response);
            }
            return true;
        }
        // Token为空
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("errMsg", "Token is empty.");
        return abort401(request, response);
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    /**
     * 返回HTTP 401错误
     */
    private boolean abort401(ServletRequest request, ServletResponse response) {
        try {
            HttpServletResponse resp = (HttpServletResponse) response;
            String errMsg = resp.getHeader("errMsg");

            resp.sendRedirect("/401?errMsg=" + URLEncoder.encode(errMsg, "UTF-8"));
            resp.setStatus(HttpStatus.OK.value());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

}
