package com.weyoung.wxapp.welfare.service.impl;

import com.weyoung.wxapp.common.service.impl.BaseService;
import com.weyoung.wxapp.welfare.dao.ScheduleDao;
import com.weyoung.wxapp.welfare.domain.Schedule;
import com.weyoung.wxapp.welfare.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl extends BaseService<Schedule> implements ScheduleService {
    @Autowired
    ScheduleDao scheduleDao;
    @Override
    public int scheduleListAdd(Schedule schedule){
        return scheduleDao.insertSelective(schedule);
    }
    @Override
    public List<Schedule> scheduleList(Schedule schedule){
        return scheduleDao.select(schedule);
    }

    @Override
    public int scheduleUpdate(Schedule schedule){
        return scheduleDao.updateByPrimaryKeySelective(schedule);
    }
}
