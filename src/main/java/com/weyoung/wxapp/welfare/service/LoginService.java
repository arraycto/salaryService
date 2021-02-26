package com.weyoung.wxapp.welfare.service;

import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.service.IService;
import com.weyoung.wxapp.welfare.domain.OrdersDetail;
import com.weyoung.wxapp.welfare.domain.RepairDetail;
import com.weyoung.wxapp.welfare.domain.ServiceList;
import com.weyoung.wxapp.welfare.domain.User;
import com.weyoung.wxapp.welfare.vo.RecommenderListVo;
import com.weyoung.wxapp.welfare.vo.SourceVo;
import com.weyoung.wxapp.welfare.vo.UploadVo;
import com.weyoung.wxapp.welfare.vo.UserOrderVo;

import java.util.List;

/**
 * @author li
 * @date 2019-11-24
 */
public interface LoginService extends IService<User> {
    /**
     * 登录
     * @param openid
     * @return
     */
    User login(String openid,String userName, Integer recommenderId);

    /**
     * 师傅取消订单,取消即变成未分配状态
     * @param repairId
     * @param description
     * @return
     */
    int cancel(Integer repairId, String description, Integer state);

    /**
     * 获取用户订单
     * @param userId
     * @return
     */
    UserOrderVo query(Integer userId, Short state);

    /**
     * 师傅查询管理员派送的单子
     * @param userId
     * @param state
     * @return
     */
    UserOrderVo dispatch(Integer userId, Short state);

    /**
     * 师傅查询订单详情
     * @param repairId
     * @param state
     * @return
     */
    JsonResult detail(Integer repairId, Short state);

    /**
     * 师傅上传购买订单
     * @param uploadVo
     * @return
     */
    int uploadOrder(UploadVo uploadVo);

    /**
     * 师傅上传预约维修订单
     * @param uploadVo
     * @return
     */
    int uploadRepair(UploadVo uploadVo);

    /**
     * 用户或师傅查询订单
     * @param tel
     * @return
     */
    UserOrderVo userQuery(String tel);

    /**
     *  师傅上传自己接的单
     * @param sourceVo
     * @return
     */
     int uploadAdmin(SourceVo sourceVo);

    /**
     * 获取服务列表
     * @return
     */
    ServiceList serviceList(Integer serviceId);

    /**
     * 被推荐人列表
     * @param userId
     * @return
     */
    RecommenderListVo recommenderList(Integer userId);

    /**
     * 签到
     * @param userId
     * @return
     */
    int signIn(Integer userId);

    /**
     * 修改个人信息
     * @param userId
     * @param username
     * @param tel
     * @param email
     * @return
     */
    int updatePersonal(Integer userId,String username,String tel, String email);

    /**
     * 上下班及请假
     * @param user
     * @return
     */
    int work(User user);
}
