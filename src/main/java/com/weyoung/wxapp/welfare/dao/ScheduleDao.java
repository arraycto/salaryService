package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.Schedule;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDao extends MyMapper<Schedule> {
}