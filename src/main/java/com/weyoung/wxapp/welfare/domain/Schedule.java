package com.weyoung.wxapp.welfare.domain;

import java.util.Date;
import javax.persistence.*;

public class Schedule {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     *  状态 0准备上门  1 已到达  2 待处理  3 已完成
     */
    private Byte state;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 当前位置
     */
    private String position;


    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 电话
     */
    private String phone;

    /**
     * 来源
     */
    private String source;

    /**
     * 描述
     */
    private String description;

    @Column(name = "user_name")
    private String userName;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 状态 0准备上门  1 已到达  2 待处理  3 已完成
     *
     * @return state -  状态 0准备上门  1 已到达  2 待处理  3 已完成
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置 状态 0准备上门  1 已到达  2 待处理  3 已完成
     *
     * @param state  状态 0准备上门  1 已到达  2 待处理  3 已完成
     */
    public void setState(Byte state) {
        this.state = state;
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
     * 获取目的地
     *
     * @return destination - 目的地
     */
    public String getDestination() {
        return destination;
    }

    /**
     * 设置目的地
     *
     * @param destination 目的地
     */
    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    /**
     * 获取当前位置
     *
     * @return position - 当前位置
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置当前位置
     *
     * @param position 当前位置
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取来源
     *
     * @return source - 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源
     *
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
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

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}