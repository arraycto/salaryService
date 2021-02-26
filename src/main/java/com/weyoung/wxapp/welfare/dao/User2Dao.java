package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.User2;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface User2Dao extends MyMapper<User2> {
    /**
     * 获取用户列表
     * @return
     */
    List<User2> userList();
    /**
     * 查询用户
     * @return
     */
    List<User2> search(Integer workId, Integer phone,
                      Integer name, Integer salary, String username);
    /**
     * 获取日志列表
     * @return
     */
    List<User2> getcard();
    /**
     * 登陆
     * @return
     */
    User2 login(String username,Integer password);
    /**
     * 注册
     * @return
     */
    int regist(String username,Integer password);
    /**
     * 删除用户
     * @return
     */
    int deleteUser(Integer workId);
    /**
     * 分配用户角色
     * @return
     */
    int gitUser(Integer dept,Integer workId);

    /**
     * 扣款新增
     * @return
     */
    int insertcost(Integer workId,Integer money);
    /**
     * 新增用户
     * @return
     */
    int insertuser(String username, Integer password, String name, Integer dept, Integer workId);
}