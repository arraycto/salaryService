package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.OrdersDetail;
import org.springframework.stereotype.Repository;

/**
 * @author li
 * @date 2019-12-23
 */
@Repository
public interface OrdersDetailDao extends MyMapper<OrdersDetail> {

    /**
     * 师傅查询订单详情
     * @param repairId
     * @return
     */
    OrdersDetail selectByOrdersId(Integer repairId);

}