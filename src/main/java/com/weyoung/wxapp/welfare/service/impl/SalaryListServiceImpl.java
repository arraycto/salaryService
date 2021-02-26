package com.weyoung.wxapp.welfare.service.impl;

import com.weyoung.wxapp.common.service.impl.BaseService;
import com.weyoung.wxapp.welfare.dao.SalaryListDao;
import com.weyoung.wxapp.welfare.domain.SalaryList;
import com.weyoung.wxapp.welfare.domain.ServiceList;
import com.weyoung.wxapp.welfare.service.SalaryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryListServiceImpl extends BaseService<SalaryList> implements SalaryListService {


    @Autowired
    SalaryListDao salaryListDao;


    public List<SalaryList> getList()
    {
        return salaryListDao.getList();
    }

    @Override
    public int reget(String word,Integer workId) {
        return salaryListDao.reget(word, workId);
    }

    @Override
    public int insertcost(String word,Integer workId,Integer money) {
        return salaryListDao.insertcost(word, workId, money);
    }
}
