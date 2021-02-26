package com.weyoung.wxapp.welfare.service.impl;

import com.weyoung.wxapp.common.service.impl.BaseService;
import com.weyoung.wxapp.welfare.dao.User2Dao;
import com.weyoung.wxapp.welfare.domain.User2;
import com.weyoung.wxapp.welfare.service.UserpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserpServiceImpl extends BaseService<User2> implements UserpService {
    @Autowired
    User2Dao user2ao;



    @Override
    public List<User2> userList() {
        return user2ao.userList();
    }



    @Override
    public User2 login( String userName, Integer password) {
        //登录
        User2 user2 = user2ao.login(userName,password);

    return user2;
    }

    @Override
    public int regist(String userName, Integer password) {
        return user2ao.regist(userName,password);
    }

    @Override
    public int gitUser(Integer dept,Integer workId) {
        return user2ao.gitUser(dept,workId);
    }


    @Override
    public int deleteUser(Integer workId) {
        return user2ao.deleteUser(workId);
    }

    @Override
    public int insertuser(String username, Integer password, String name, Integer dept, Integer workId) {
            return user2ao.insertuser( username,  password,  name,  dept,  workId);
    }

    @Override
    public List<User2> getcard() {
        return user2ao.getcard();
    }

    @Override
    public List<User2> search(Integer workId, Integer phone, Integer name, Integer salary,String username) {

        return user2ao.search( workId,  phone,  name,  salary,  username);
    }


}
