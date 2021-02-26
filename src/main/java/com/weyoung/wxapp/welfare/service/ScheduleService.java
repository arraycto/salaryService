package com.weyoung.wxapp.welfare.service;

import com.weyoung.wxapp.common.service.IService;
import com.weyoung.wxapp.welfare.domain.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ScheduleService extends IService<Schedule> {

    /**
     * 上传日程安排
     * @param schedule
     * @return
     */
    int scheduleListAdd(Schedule schedule);

    /**
     * 查询日程安排列表
     * @param schedule
     * @return
     */
    List<Schedule> scheduleList(Schedule schedule);

    /**
     * 修改日程安排
     * @param schedule
     * @return
     */
    int scheduleUpdate(Schedule schedule);
}
