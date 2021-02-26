package com.weyoung.wxapp.welfare.service;

import com.weyoung.wxapp.common.service.IService;
import com.weyoung.wxapp.welfare.domain.Salary;

import java.util.List;

public interface SalaryService extends IService<Salary> {
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
