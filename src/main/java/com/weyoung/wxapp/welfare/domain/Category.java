package com.weyoung.wxapp.welfare.domain;

import javax.persistence.*;

public class Category {
    /**
     * 商品种类编号
     */
    @Id
    @Column(name = "category_id")
    @GeneratedValue(generator = "JDBC")
    private Integer categoryId;

    /**
     * 商品种类名称

     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 获取商品种类编号
     *
     * @return category_id - 商品种类编号
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品种类编号
     *
     * @param categoryId 商品种类编号
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取商品种类名称

     *
     * @return category_name - 商品种类名称

     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置商品种类名称

     *
     * @param categoryName 商品种类名称

     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }
}