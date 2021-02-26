package com.weyoung.wxapp.welfare.dao;

import com.weyoung.wxapp.common.config.MyMapper;
import com.weyoung.wxapp.welfare.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends MyMapper<Category> {
    /**
     * 获取商品种类
     * @return
     */
    List<Category> getCategory();
}