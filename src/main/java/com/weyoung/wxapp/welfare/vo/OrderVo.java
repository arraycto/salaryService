package com.weyoung.wxapp.welfare.vo;

import com.weyoung.wxapp.welfare.domain.Orders;
import com.weyoung.wxapp.welfare.domain.OrdersDetail;

import java.io.Serializable;

/**
 * @author li
 * @date 2019-12-24
 */
public class OrderVo implements Serializable {
    private Orders orders;
    private OrdersDetail ordersDetail;


    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public OrdersDetail getOrdersDetail() {
        return ordersDetail;
    }

    public void setOrdersDetail(OrdersDetail ordersDetail) {
        this.ordersDetail = ordersDetail;
    }
}
