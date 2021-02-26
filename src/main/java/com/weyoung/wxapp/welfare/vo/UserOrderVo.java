package com.weyoung.wxapp.welfare.vo;

import com.weyoung.wxapp.welfare.domain.Orders;
import com.weyoung.wxapp.welfare.domain.Repair;

import java.io.Serializable;
import java.util.List;

/**
 * 用户查询订单（购买下单、预约维修）
 * @author li
 * @date 2019-12-23
 */
public class UserOrderVo implements Serializable {
    private List<OrdersImgVo> orders;
    private List<Repair> repairs;

    public List<OrdersImgVo> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersImgVo> orders) {
        this.orders = orders;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }
}
