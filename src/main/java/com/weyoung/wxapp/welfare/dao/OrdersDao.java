package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.Orders;
import com.weyoung.wxapp.welfare.vo.OrdersImgVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author li
 * @date 2019-12-23
 */
@Repository
public interface OrdersDao extends MyMapper<Orders> {
    /**
     * 师傅取消订单原因
     * @param repairId
     * @param description
     * @return
     */
    int updateDesc(Integer repairId, String description);

    /**
     * 查询用户订单
     * @param userId
     * @param state
     * @return
     */
    List<OrdersImgVo> selectByUserId(Integer userId, Short state);

    /**
     * 师傅查询派单
     * @param userId
     * @param state
     * @return
     */
    List<OrdersImgVo> selectByAdminId(Integer userId, Short state);

    /**
     * 通过电话查询订单
     * @param tel
     * @return
     */
    List<OrdersImgVo> selectByTel(String tel);
}