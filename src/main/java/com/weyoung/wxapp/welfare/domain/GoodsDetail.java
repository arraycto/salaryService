package com.weyoung.wxapp.welfare.domain;

import javax.persistence.*;

@Table(name = "goods_detail")
public class GoodsDetail {
    /**
     * 商品详细信息编号
     */
    @Id
    @Column(name = "detail_id")
    @GeneratedValue(generator = "JDBC")
    private Integer detailId;

    /**
     * 商品编号
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 商品详细图片
     */
    @Column(name = "detail_img")
    private String detailImg;

    /**
     * 描述
     */
    private String description;

    /**
     * 获取商品详细信息编号
     *
     * @return detail_id - 商品详细信息编号
     */
    public Integer getDetailId() {
        return detailId;
    }

    /**
     * 设置商品详细信息编号
     *
     * @param detailId 商品详细信息编号
     */
    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

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
     * 获取商品详细图片
     *
     * @return detail_img - 商品详细图片
     */
    public String getDetailImg() {
        return detailImg;
    }

    /**
     * 设置商品详细图片
     *
     * @param detailImg 商品详细图片
     */
    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg == null ? null : detailImg.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}