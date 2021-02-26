package com.weyoung.wxapp.welfare.domain;

import javax.persistence.*;

public class Stock {
    /**
     * 商品编号
     */
    @Id
    @Column(name = "stock_id")
    @GeneratedValue(generator = "JDBC")
    private Integer stockId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 单位
     */
    private String unity;

    /**
     * 库存数量
     */
    private Integer number;

    /**
     * 单价
     */
    private Integer price;

    /**
     * 总价
     */
    @Column(name = "total_price")
    private Integer totalPrice;

    /**
     * 获取商品编号
     *
     * @return stock_id - 商品编号
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * 设置商品编号
     *
     * @param stockId 商品编号
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取单位
     *
     * @return unity - 单位
     */
    public String getUnity() {
        return unity;
    }

    /**
     * 设置单位
     *
     * @param unity 单位
     */
    public void setUnity(String unity) {
        this.unity = unity == null ? null : unity.trim();
    }

    /**
     * 获取库存数量
     *
     * @return number - 库存数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置库存数量
     *
     * @param number 库存数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取单价
     *
     * @return price - 单价
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price 单价
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取总价
     *
     * @return total_price - 总价
     */
    public Integer getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总价
     *
     * @param totalPrice 总价
     */
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}