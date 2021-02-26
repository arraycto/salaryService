package com.weyoung.wxapp.welfare.service.impl;

import com.weyoung.wxapp.common.service.impl.BaseService;
import com.weyoung.wxapp.welfare.dao.OrdersDao;
import com.weyoung.wxapp.welfare.dao.UserDao;
import com.weyoung.wxapp.welfare.domain.Orders;
import com.weyoung.wxapp.welfare.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl extends BaseService<Orders> implements OrdersService {
    @Autowired
    OrdersDao ordersDao;
    @Autowired
    UserDao userDao;
    @Override
    public int orders(Orders orders){
        return ordersDao.insertSelective(orders);
    }

}
