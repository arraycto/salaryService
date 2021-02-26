package com.weyoung.wxapp.welfare.service.impl;

import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.service.impl.BaseService;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.welfare.dao.*;
import com.weyoung.wxapp.welfare.domain.*;
import com.weyoung.wxapp.welfare.service.LoginService;
import com.weyoung.wxapp.welfare.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl extends BaseService<User> implements LoginService {
    @Autowired
    UserDao userDao;
    @Autowired
    OrdersDao ordersDao;
    @Autowired
    RepairDao repairDao;
    @Autowired
    OrdersDetailDao ordersDetailDao;
    @Autowired
    RepairDetailDao repairDetailDao;
    @Autowired
    ServiceListDao serviceListDao;

    @Override
    public User login(String openid, String userName, Integer recommenderId) {
        //登录
        User user = userDao.findByOpenid(openid);
        //数据库没有此用户
        if (user == null && (openid != null || openid != "")) {
            User u = new User();
            u.setOpenid(openid);
            u.setUserName(userName);
            u.setFreezingIntegral(30);
            if (recommenderId != null){
                u.setRecommenderId(recommenderId);
            }
            //绑定
            userDao.insertSelective(u);
            //推荐人冻结积分增加10
            if (recommenderId != null){
                userDao.updateFreezingIntegral(recommenderId);
            }
            user = userDao.findByOpenid(openid);
        }
        return user;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int cancel(Integer repairId, String description, Integer state){
        //预约订单
        if(state == 1){
            userDao.updateDesc(repairId, description);
            return userDao.updateState(repairId);
        }else if (state == 0){
            //购买下单订单
            Orders orders = new Orders();
            orders.setOrderId(repairId);
            orders.setState((short) 0);
            ordersDao.updateByPrimaryKeySelective(orders);
            return ordersDao.updateDesc(repairId, description);
        }
        return 0;
    }
    @Override
    public UserOrderVo query(Integer userId, Short state){
        UserOrderVo userOrderVo = new UserOrderVo();
        userOrderVo.setRepairs(repairDao.selectByUserId(userId, state));
        userOrderVo.setOrders(ordersDao.selectByUserId(userId, state));
        return userOrderVo;
    }
    @Override
    public UserOrderVo dispatch(Integer userId, Short state){
        UserOrderVo userOrderVo = new UserOrderVo();
        userOrderVo.setRepairs(repairDao.selectByAdminId(userId, state));
        userOrderVo.setOrders(ordersDao.selectByAdminId(userId, state));
        return userOrderVo;
    }
    @Override
    public JsonResult detail(Integer repairId, Short state){
        JsonResult result = ResponseUtil.ok();
        //预约订单
        if(state == 1){
            RepairVo repairVo = new RepairVo();
            repairVo.setRepair(repairDao.selectByPrimaryKey(repairId));
            repairVo.setRepairDetail(repairDetailDao.selectByRepairId(repairId));
            result.setData(repairVo);
        }else if (state == 0){
            //购买下单订单
            OrderVo orderVo = new OrderVo();
            orderVo.setOrders(ordersDao.selectByPrimaryKey(repairId));
            orderVo.setOrdersDetail(ordersDetailDao.selectByOrdersId(repairId));
            result.setData(orderVo);
        }
        return result;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int uploadOrder(UploadVo uploadVo){
        OrdersDetail ordersDetail = new OrdersDetail();
        ordersDetail.setDescription(uploadVo.getDescription());
        ordersDetail.setDetailId(uploadVo.getDetailId());
        ordersDetail.setOrderId(uploadVo.getRepairId());
        ordersDetail.setUserId(uploadVo.getUserId());
        ordersDetail.setImg(uploadVo.getImg());
        Orders orders = new Orders();
        orders.setOrderId(uploadVo.getRepairId());
        orders.setAdminId(uploadVo.getUserId());
        orders.setPrice(uploadVo.getPrice());
        orders.setState((short) 2);
        Integer userId = ordersDao.selectByPrimaryKey(uploadVo.getRepairId()).getUserId();
        if(userId != null){
            if (uploadVo.getIntegral() != null){
                userDao.updateReduceIntegral(userId , uploadVo.getIntegral());
                orders.setIntegral(uploadVo.getIntegral());
            }
            if(uploadVo.getPrice() != null){
                BigDecimal pr = uploadVo.getPrice();
                double price = pr.doubleValue();
                int integral = 0;
                if ((price >= 200 ) && (price < 500)){
                    integral = 5;
                }else if ((price >= 500 ) && (price < 1000)){
                    integral = 20;
                }else if ((price >= 1000 ) && (price < 1500)){
                    integral = 50;
                }else if (price >= 1500){
                    integral = 100;
                }
                if (integral > 0){
                    userDao.updateIntegral(userId, integral);
                }
            }
            User user = userDao.selectByPrimaryKey(userId);
            if (user.getFirstOrder() != null && user.getFirstOrder() == 0){
                userDao.updateByFirstOrder(userId, 30);
                if (user.getRecommenderId() != null && user.getRecommenderId() != 0){
                    userDao.updateByFirstOrder(user.getRecommenderId(), 10);
                }
            }
        }
        ordersDetailDao.updateByPrimaryKeySelective(ordersDetail);
        return ordersDao.updateByPrimaryKeySelective(orders);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int uploadRepair(UploadVo uploadVo){
        Repair repair = new Repair();
        repair.setState((short) 2);
        repair.setRepairId(uploadVo.getRepairId());
        repair.setAdminId(uploadVo.getUserId());
        repair.setPrice(uploadVo.getPrice());
        RepairDetail repairDetail = new RepairDetail();
        repairDetail.setDescription(uploadVo.getDescription());
        repairDetail.setUserId(uploadVo.getUserId());
        repairDetail.setDetailId(uploadVo.getDetailId());
        repairDetail.setRepairId(uploadVo.getRepairId());
        repairDetail.setFinishImg(uploadVo.getImg());
        Integer userId = repairDao.selectByPrimaryKey(uploadVo.getRepairId()).getUserId();
        if(userId != null){
            if (uploadVo.getIntegral() != null){
                userDao.updateReduceIntegral(userId, uploadVo.getIntegral());
                repair.setIntegral(uploadVo.getIntegral());
            }
            if(uploadVo.getPrice() != null){
                BigDecimal pr = uploadVo.getPrice();
                double price = pr.doubleValue();
                int integral = 0;
                if ((price >= 200 ) && (price < 500)){
                    integral = 5;
                }else if ((price >= 500 ) && (price < 1000)){
                    integral = 20;
                }else if ((price >= 1000 ) && (price < 1500)){
                    integral = 50;
                }else if (price >= 1500){
                    integral = 100;
                }
                if (integral > 0){
                    //增加用户积分
                    userDao.updateIntegral(userId, integral);
                }
            }
            User user = userDao.selectByPrimaryKey(userId);
            if (user.getFirstOrder() != null && user.getFirstOrder() == 0){
                userDao.updateByFirstOrder(userId, 30);
                if (user.getRecommenderId() != null && user.getRecommenderId() != 0){
                    userDao.updateByFirstOrder(user.getRecommenderId(), 10);
                }
            }
        }
        repairDetailDao.updateByPrimaryKeySelective(repairDetail);
        return repairDao.updateByPrimaryKeySelective(repair);
    }

    @Override
    public UserOrderVo userQuery(String tel){
        UserOrderVo userOrderVo = new UserOrderVo();
        userOrderVo.setRepairs(repairDao.selectByTel(tel));
        userOrderVo.setOrders(ordersDao.selectByTel(tel));
        return userOrderVo;
    }
    @Override
    public int uploadAdmin(SourceVo sourceVo){
        Repair repair = new Repair();
        repair.setPrice(sourceVo.getPrice());
        repair.setAdminId(sourceVo.getUserId());
        repair.setState((short) 2);
        repair.setAddress(sourceVo.getAddress());
        repair.setUserName(sourceVo.getUserName());
        repair.setTel(sourceVo.getTel());
        repair.setSource(sourceVo.getSource());
        RepairDetail repairDetail = new RepairDetail();
        repairDao.insertSelective(repair);
        repairDetail.setRepairId(repair.getRepairId());
        repairDetail.setFinishImg(sourceVo.getImg());
        repairDetail.setDescription(sourceVo.getDescription());
        repairDetail.setUserId(sourceVo.getUserId());
        repairDetail.setUserName(sourceVo.getAdminName());
        return repairDetailDao.insertSelective(repairDetail);
    }
    @Override
    public ServiceList serviceList(Integer serviceId){
        return serviceListDao.selectByPrimaryKey(serviceId);
    }
    @Override
    public RecommenderListVo recommenderList(Integer userId){
        RecommenderListVo recommenderListVo = new RecommenderListVo();

        recommenderListVo.setFinsh(userDao.selectByUserId(userId, 1));

        recommenderListVo.setUnfinsh(userDao.selectByUserId(userId, 0));
        return recommenderListVo;
    }
    @Override
    public int signIn(Integer userId){
        userDao.signIn(userId);
        return userDao.selectByPrimaryKey(userId).getSignInNum();
    }
    @Override
    public int updatePersonal(Integer userId,String username,String tel, String email){
        User user = new User();
        user.setUserId(userId);
        user.setUserName(username);
        user.setTel(tel);
        user.setEmail(email);
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int work(User user){
        return userDao.updateWork(user);
    }

}
