package com.weyoung.wxapp.welfare.controller;

import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.welfare.domain.Repair;
import com.weyoung.wxapp.welfare.domain.Schedule;
import com.weyoung.wxapp.welfare.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "日程安排")
@RequestMapping("schedule")
@RestController
public class ScheduleController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ScheduleService scheduleService;

    @ApiOperation("上传日程安排")
    @PostMapping("/scheduleListAdd")
    @ResponseBody
    public JsonResult scheduleListAdd(Schedule schedule) throws Exception {
        scheduleService.scheduleListAdd(schedule);
        return ResponseUtil.ok();
    }

    @ApiOperation("查询日程安排")
    @PostMapping("/scheduleList")
    @ResponseBody
    public JsonResult scheduleList(Schedule schedule) throws Exception {
        JsonResult result = ResponseUtil.ok();
        result.setData(scheduleService.scheduleList(schedule));
        return result;
    }

    @ApiOperation("修改日程安排")
    @PostMapping("/scheduleUpdate")
    @ResponseBody
    public JsonResult scheduleUpdate(Schedule schedule) throws Exception {
        scheduleService.scheduleUpdate(schedule);
        return ResponseUtil.ok();
    }
}
