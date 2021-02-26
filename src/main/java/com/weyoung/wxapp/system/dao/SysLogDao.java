package com.weyoung.wxapp.system.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.system.domain.SysLog;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SysLogDao extends MyMapper<SysLog> {
    /**
     * 插入系统日志，不处理时间字段
     *
     * @param sysLog
     * @return
     */
    int insertLogWithoutTime(SysLog sysLog);

    /**
     * 查询上次登录的时间（倒数第二条）
     *
     * @param homeName
     * @return
     */
    Date findLastLoginTime(String homeName);


}