package com.weyoung.wxapp.common.aspect;


import com.weyoung.wxapp.common.config.FebsProperties;
import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.HttpContextUtils;
import com.weyoung.wxapp.common.util.IPUtils;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.system.domain.SysLog;
import com.weyoung.wxapp.system.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP 记录用户操作日志
 *
 * @author MrBird
 * @link https://mrbird.cc/Spring-Boot-AOP%20log.html
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private FebsProperties febsProperties;

//    @Autowired
//    private LogService logService;


    @Pointcut("@annotation(com.weyoung.wxapp.common.annotation.Log)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        // 执行方法
        result = point.proceed();

        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        if (febsProperties.isOpenAopLog() && result instanceof JsonResult) {
            // 登录成功了才记录日志
            if (((JsonResult) result).getStatus() == ResponseUtil.OK) {
                SysLog log = new SysLog();
                log.setTime(time);
                // 获取request
                HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
                // 设置IP地址
                String ip = IPUtils.getIpAddr(request);
                log.setIp(ip);
//                logService.saveLog(point, log);
            }
        }
        return result;
    }
}
