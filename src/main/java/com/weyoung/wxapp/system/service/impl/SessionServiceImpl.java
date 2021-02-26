package com.weyoung.wxapp.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.weyoung.wxapp.common.service.RedisService;
import com.weyoung.wxapp.common.util.JWTUtil;
import com.weyoung.wxapp.system.domain.UserOnline;
import com.weyoung.wxapp.system.service.SessionService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Shiro Session 对象管理
 *
 * @author MrBird
 * @link https://mrbird.cc/Spring-Boot-Shiro%20session.html
 */
@Service("sessionService")
public class SessionServiceImpl implements SessionService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisService redisService;

    @Override
    public List<UserOnline> list() {
        List<UserOnline> list = new ArrayList<>();
        // 因为登录时存的是staffId，所以匹配数字key
        Set<String> staffIds = redisService.getKeys("[0-9]*");
        for (String staffId : staffIds) {
            String token = redisService.get(staffId);
            String text = redisService.get(token);
            logger.info("token:{}, user:{}", token, text);
            if (text == null) {
                continue;
            }
            UserOnline userOnline = JSON.parseObject(text, UserOnline.class);
            list.add(userOnline);
        }
        return list;
    }

    @Override
    public boolean forceLogout(String sessionId) {
        redisService.del(sessionId);
        String staffId = JWTUtil.decode(sessionId);
        redisService.del(staffId);
        SecurityUtils.getSubject().logout();
        return true;
    }

}
