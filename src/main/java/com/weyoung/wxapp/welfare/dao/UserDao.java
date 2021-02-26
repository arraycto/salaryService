package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.User;
import com.weyoung.wxapp.welfare.vo.RecommenderVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MyMapper<User> {

    /**
     * 根据openid获取信息
     * @param openid
     * @return
     */
    User findByOpenid(String openid);

    /**
     *师傅取消订单
     */
    int updateState(Integer repairId);

    /**
     * 取消订单原因
     * @param description
     * @return
     */
    int updateDesc(Integer repairId, String description);

    /**
     * 增加积分
     * @param userId
     * @return
     */
    int updateIntegral(Integer userId, Integer integral);

    /**
     * 更新推荐人冻结积分
     * @param recommenderId
     * @return
     */
    int updateFreezingIntegral(Integer recommenderId);

    /**
     * 被推荐人列表
     * @param userId
     * @param firstOrder
     * @return
     */
    List<RecommenderVo> selectByUserId(Integer userId, Integer firstOrder);

    /**
     * 签到
     * @param userId
     * @return
     */
    int signIn(Integer userId);

    /**
     * 减少积分
     * @return
     */
    int updateReduceIntegral(Integer userId, Integer integral);

    /**
     * 下单成功后冻结积分变成可用积分
     * @param userId
     * @param integral
     * @return
     */
    int updateByFirstOrder(Integer userId, Integer integral);

    /**
     * 上下班
     * @param user
     * @return
     */
    int updateWork(User user);
}