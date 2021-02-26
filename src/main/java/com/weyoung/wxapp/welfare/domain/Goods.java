package com.weyoung.wxapp.welfare.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Goods {
    /**
     * 商品编号
     */
    @Id
    @Column(name = "goods_id")
    @GeneratedValue(generator = "JDBC")
    private Integer goodsId;

    /**
     * 商品名字
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品图片
     */
    private String img;

    /**
     * 商品种类
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 上架时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取商品编号
     *
     * @return goods_id - 商品编号
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品编号
     *
     * @param goodsId 商品编号
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取商品名字
     *
     * @return goods_name - 商品名字
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名字
     *
     * @param goodsName 商品名字
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 获取商品图片
     *
     * @return img - 商品图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置商品图片
     *
     * @param img 商品图片
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 获取商品种类
     *
     * @return category_id - 商品种类
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品种类
     *
     * @param categoryId 商品种类
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取商品价格
     *
     * @return price - 商品价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置商品价格
     *
     * @param price 商品价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取上架时间
     *
     * @return create_time - 上架时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置上架时间
     *
     * @param createTime 上架时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}