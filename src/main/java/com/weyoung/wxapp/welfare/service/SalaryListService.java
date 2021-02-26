package com.weyoung.wxapp.welfare.service;

import com.weyoung.wxapp.common.service.IService;
import com.weyoung.wxapp.welfare.domain.SalaryList;
import com.weyoung.wxapp.welfare.domain.ServiceList;
import com.weyoung.wxapp.welfare.domain.User2;

import java.util.List;

public interface SalaryListService  extends IService<SalaryList> {

    /**
     * 获取用户列表
     * @return
     */
    List<SalaryList> getList();
    /**
     * 扣款申诉
     * @return
     */
    int reget(String word,Integer workId);

    /**
     * 扣款新增
     * @return
     */
    int insertcost(String word,Integer workId,Integer money);
}
