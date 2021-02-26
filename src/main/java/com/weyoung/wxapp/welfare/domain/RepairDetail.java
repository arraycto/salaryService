package com.weyoung.wxapp.welfare.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "repair_detail")
public class RepairDetail {
    @Id
    @Column(name = "detail_id")
    @GeneratedValue(generator = "JDBC")
    private Integer detailId;

    /**
     * 预约id
     */
    @Column(name = "repair_id")
    private Integer repairId;

    /**
     * 任务完成人id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 任务完成人姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 完成图片
     */
    @Column(name = "finish_img")
    private String finishImg;

    /**
     * 描述
     */
    private String description;

    /**
     * 完成时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取预约id
     *
     * @return repair_id - 预约id
     */
    public Integer getRepairId() {
        return repairId;
    }

    /**
     * 设置预约id
     *
     * @param repairId 预约id
     */
    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
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
     * 获取任务完成人姓名
     *
     * @return user_name - 任务完成人姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置任务完成人姓名
     *
     * @param userName 任务完成人姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取完成图片
     *
     * @return finish_img - 完成图片
     */
    public String getFinishImg() {
        return finishImg;
    }

    /**
     * 设置完成图片
     *
     * @param finishImg 完成图片
     */
    public void setFinishImg(String finishImg) {
        this.finishImg = finishImg == null ? null : finishImg.trim();
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
     * 获取完成时间
     *
     * @return create_time - 完成时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置完成时间
     *
     * @param createTime 完成时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}