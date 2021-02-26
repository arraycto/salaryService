package com.weyoung.wxapp.common.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IService<T> {

    /**
     * 查询唯一实体
     *
     * @param entity
     * @return
     */
    T selectOne(T entity);


    /**
     * 查询所有记录
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 通过主键查询
     *
     * @param key
     * @return
     */
    T selectByKey(Object key);

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    int save(T entity);


    /**
     * 根据主键删除
     *
     * @param key
     * @return
     */
    int delete(Object key);

    /**
     * 更新所有字段
     *
     * @param entity
     * @return
     */
    int updateAll(T entity);

    /**
     * 更新非空字段
     *
     * @param entity
     * @return
     */
    int updateNotNull(T entity);

    /**
     * 根据指定字段批量删除记录
     *
     * @param list     条件集合
     * @param property 指定属性
     * @param clazz    实体类
     * @return
     */
    int batchDelete(List<String> list, String property, Class<T> clazz);

    /**
     * example查询
     *
     * @param example
     * @return
     */
    List<T> selectByExample(Object example);

    /**
     * 批量插入list集合
     *
     * @param list
     * @return
     */
    int insertList(List<T> list);

    /**
     * 按实体非空插入
     *
     * @param entity
     * @return
     */
    int insertSelective(T entity);

    /**
     * 按实体非空更新
     *
     * @param entity
     * @return
     */
    int updateByPrimaryKeySelective(T entity);


}