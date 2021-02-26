package com.weyoung.wxapp.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weyoung.wxapp.common.service.IService;
import com.weyoung.wxapp.system.domain.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 系统日志处理类
 *
 * @author icechen1219
 */
@Repository
public interface LogService extends IService<SysLog> {

    List<SysLog> findAllLogs(SysLog log);

    void deleteLogs(String logIds);

    void saveLog(ProceedingJoinPoint point, SysLog log) throws JsonProcessingException;

    /**
     * 查询上次登录的时间（倒数第二条）
     *
     * @param homeName
     * @return
     */
    Date findLastLoginTime(String homeName);


}
