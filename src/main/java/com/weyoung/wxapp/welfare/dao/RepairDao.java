package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.Repair;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author li
 * @date 2019-12-23
 */
@Repository
public interface RepairDao extends MyMapper<Repair> {
    /**
     * 查询用户订单
     * @param userId
     * @param state
     * @return
     */
    List<Repair> selectByUserId(Integer userId, Short state);

    /**
     * 师傅查询订单
     * @param userId
     * @param state
     * @return
     */
    List<Repair> selectByAdminId(Integer userId, Short state);

    /**
     * 通过电话查询订单
     * @param tel
     * @return
     */
    List<Repair> selectByTel(String tel);
}