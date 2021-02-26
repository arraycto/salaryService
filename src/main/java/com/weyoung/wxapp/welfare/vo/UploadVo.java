package com.weyoung.wxapp.welfare.vo;

import java.math.BigDecimal;

/**
 * 师傅自己接单
 * @author li
 * @date 2019-12-31
 * */

public class UploadVo {
    /**
     * 消耗积分
     */
    private Integer integral;
    private Integer repairId;
    private Integer detailId;
    /**
     *价格
     */
    private BigDecimal price;
    private String description;
    private String img;
    /**
     * 师傅id
     */
    private Integer userId;

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
