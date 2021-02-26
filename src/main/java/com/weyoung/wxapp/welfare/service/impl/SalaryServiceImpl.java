package com.weyoung.wxapp.welfare.service.impl;

import com.weyoung.wxapp.common.service.impl.BaseService;
import com.weyoung.wxapp.welfare.dao.SalaryDao;
import com.weyoung.wxapp.welfare.dao.User2Dao;
import com.weyoung.wxapp.welfare.domain.Salary;
import com.weyoung.wxapp.welfare.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl extends BaseService<Salary> implements SalaryService {
    @Autowired
    SalaryDao salaryDao;
    @Override
    public List<Salary> getSalary() {
        return salaryDao.getSalary();
    }



    @Override
    public int decard(Integer time,Integer workId,String word) {
        return salaryDao.decard(time,workId,word);
    }
}
