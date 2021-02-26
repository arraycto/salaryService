package com.weyoung.wxapp.common.service.impl;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.common.service.IService;
import com.weyoung.wxapp.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public abstract class BaseService<T> implements IService<T> {

    @Autowired
    protected MyMapper<T> myMapper;

    @Autowired
    protected RedisService redisService;

    public Mapper<T> getMapper() {
        return myMapper;
    }

    @Override
    public List<T> selectAll() {
        return myMapper.selectAll();
    }

    @Override
    public T selectByKey(Object key) {
        return myMapper.selectByPrimaryKey(key);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(T entity) {
        return myMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Object key) {
        return myMapper.deleteByPrimaryKey(key);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAll(T entity) {
        return myMapper.updateByPrimaryKey(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateNotNull(T entity) {
        return myMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchDelete(List<String> list, String property, Class<T> clazz) {
        Example example = new Example(clazz);
        example.createCriteria().andIn(property, list);
        return myMapper.deleteByExample(example);
    }


    @Override
    public List<T> selectByExample(Object example) {
        return myMapper.selectByExample(example);
    }

    @Override
    public T selectOne(T entity) {
        return myMapper.selectOne(entity);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<T> list) {
        return myMapper.insertList(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(T entity) {
        return myMapper.insertSelective(entity);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(T entity) {
        return myMapper.updateByPrimaryKeySelective(entity);
    }
}
