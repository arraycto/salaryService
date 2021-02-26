package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.SalaryList;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalaryListDao extends MyMapper<SalaryList> {

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