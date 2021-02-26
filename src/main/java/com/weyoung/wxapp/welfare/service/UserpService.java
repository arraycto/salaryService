package com.weyoung.wxapp.welfare.service;

import com.weyoung.wxapp.common.service.IService;

import com.weyoung.wxapp.welfare.domain.User2;

import java.util.List;

public interface UserpService extends IService<User2> {



    /**
     *查询用户列表
     * @return
     */
    List<User2> userList();

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    User2 login(String userName, Integer password);
    /**
     * 注册
     * @param userName
     * @param password
     * @return
     */
    int regist(String userName, Integer password);
    /**
     * 注册
     * @param dept
     * @return
     */
    int gitUser(Integer dept,Integer workId);
    /**
     * 查询用户
     * @return
     */
    List<User2> search( Integer workId, Integer phone,
                       Integer name, Integer salary, String username);
    /**
     * 删除用户
     * @return
     */
    int deleteUser(Integer workId);
    /**
     * 新增用户
     * @return
     */
    int insertuser(String username, Integer password, String name, Integer dept, Integer workId);


    /**
     * 获取日志列表
     * @return
     */
    List<User2> getcard();

}
