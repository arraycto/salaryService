package com.weyoung.wxapp.welfare.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.weyoung.wxapp.common.domain.CateGoryEnum;
import com.weyoung.wxapp.welfare.domain.GoodsDetail;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author li
 * @date 2019-11-14
 */

public class GoodsVo {


    /**
     * 商品编号
     */
    private Integer goodsId;

    /**
     * 商品名字
     */
    private String goodsName;

    /**
     * 商品图片
     */
    private String img;

    /**
     * 商品种类
     */
    private Integer categoryId;
    /**
     * 商品种类名称
     */
    @Transient
    private String categoryName;

    public String getCategoryName() {
        if (this.categoryId == null) {
            return "";
        }
        CateGoryEnum cateGoryEnum = CateGoryEnum.parse(this.categoryId);
        return cateGoryEnum != null ? cateGoryEnum.label() : "";
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 上架时间
     */
    private Date createTime;

    /**
     * 详细信息
     */
    private String detailImg;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }
}
