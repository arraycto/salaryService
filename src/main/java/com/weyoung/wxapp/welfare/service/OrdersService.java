package com.weyoung.wxapp.welfare.service;

import com.weyoung.wxapp.common.service.IService;
import com.weyoung.wxapp.welfare.domain.Orders;

/**
 * @author li
 * @date 2019-12-02
 */
public interface OrdersService extends IService<Orders> {
    int orders(Orders orders);
}
