package com.weyoung.wxapp.welfare.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "orders_detail")
public class OrdersDetail {
    @Id
    @Column(name = "detail_id")
    @GeneratedValue(generator = "JDBC")
    private Integer detailId;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 任务完成人id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户完成人姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 完成描述
     */
    private String description;

    /**
     * 任务完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 图片
     */
    private String img;

    /**
     * @return detail_id
     */
    public Integer getDetailId() {
        return detailId;
    }

    /**
     * @param detailId
     */
    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取任务完成人id
     *
     * @return user_id - 任务完成人id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置任务完成人id
     *
     * @param userId 任务完成人id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户完成人姓名
     *
     * @return user_name - 用户完成人姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户完成人姓名
     *
     * @param userName 用户完成人姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取完成描述
     *
     * @return description - 完成描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置完成描述
     *
     * @param description 完成描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取任务完成时间
     *
     * @return finish_time - 任务完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置任务完成时间
     *
     * @param finishTime 任务完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取图片
     *
     * @return img - 图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片
     *
     * @param img 图片
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}