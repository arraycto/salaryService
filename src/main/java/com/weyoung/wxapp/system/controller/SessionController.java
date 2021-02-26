package com.weyoung.wxapp.system.controller;

import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.system.domain.UserOnline;
import com.weyoung.wxapp.system.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SessionController {

    @Autowired
    SessionService sessionService;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping("session/list")
    public Map<String, Object> list() {
        List<UserOnline> list = sessionService.list();
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", list);
        rspData.put("total", list.size());
        return rspData;
    }

    @ResponseBody
    @RequestMapping("session/forceLogout")
    public JsonResult forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
            return ResponseUtil.ok();
        } catch (Exception e) {
            log.error("踢出用户失败", e);
            return ResponseUtil.fail();
        }

    }
}
