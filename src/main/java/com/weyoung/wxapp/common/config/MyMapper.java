package com.weyoung.wxapp.common.config;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
	
}