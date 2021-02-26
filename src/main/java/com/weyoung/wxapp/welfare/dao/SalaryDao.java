package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.Salary;
import com.weyoung.wxapp.welfare.domain.User2;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalaryDao extends MyMapper<Salary> {
    /**
     * 获取工资列表
     * @return
     */
    List<Salary> getSalary();
    /**
     * 日常打卡
     * @return
     */
    int decard(Integer time,Integer workId,String word);
}