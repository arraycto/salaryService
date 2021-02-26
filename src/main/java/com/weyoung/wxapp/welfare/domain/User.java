package com.weyoung.wxapp.welfare.domain;

import javax.persistence.*;
import java.util.Date;

public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private Integer userId;

    /**
     * openid
     */
    private String openid;

    /**
     * 0:用户，1：师傅
     */
    private Byte type;

    /**
     * 微信名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 积分
     */
    private Integer integral;
    /**
     * 师傅联系电话
     */
    @Column(name = "tel")
    private String tel;

    /**
     * 推荐人id
     */
    private Integer recommenderId;
    /**
     * 是否下过单（0：否，1：是）
     */
    private Integer firstOrder;
    /**
     * 被冻结积分
     */
    private Integer freezingIntegral;
    /**
     * 是否签到（0:否，1：是）
     */
    private Integer signIn;
    /**
     * 签到天数
     */
    private Integer signInNum;
    /**
     * 注册日期
     */
    private Date createTime;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 工作状态
     */
    private Integer workState;

    /**
     * 上下班时间
     */
    private Date workTime;

    /**
     * 上下班地址
     */
    private String workAddress;

    /**
     * 请假原因
     */
    private String workDescription;

    /**
     * 当前位置
     */
    private String position;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getWorkState() {
        return workState;
    }

    public void setWorkState(Integer workState) {
        this.workState = workState;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRecommenderId() {
        return recommenderId;
    }

    public void setRecommenderId(Integer recommenderId) {
        this.recommenderId = recommenderId;
    }

    public Integer getFirstOrder() {
        return firstOrder;
    }

    public void setFirstOrder(Integer firstOrder) {
        this.firstOrder = firstOrder;
    }

    public Integer getFreezingIntegral() {
        return freezingIntegral;
    }

    public void setFreezingIntegral(Integer freezingIntegral) {
        this.freezingIntegral = freezingIntegral;
    }

    public Integer getSignIn() {
        return signIn;
    }

    public void setSignIn(Integer signIn) {
        this.signIn = signIn;
    }

    public Integer getSignInNum() {
        return signInNum;
    }

    public void setSignInNum(Integer signInNum) {
        this.signInNum = signInNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取openid
     *
     * @return openid - openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置openid
     *
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 获取0:用户，1：师傅
     *
     * @return type - 0:用户，1：师傅
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置0:用户，1：师傅
     *
     * @param type 0:用户，1：师傅
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取微信名
     *
     * @return user_name - 微信名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置微信名
     *
     * @param userName 微信名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}