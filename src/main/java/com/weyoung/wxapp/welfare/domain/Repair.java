package com.weyoung.wxapp.welfare.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Repair {
    /**
     * 预约id
     */
    @Id
    @Column(name = "repair_id")
    @GeneratedValue(generator = "JDBC")
    private Integer repairId;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 下单时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 维修类型（个人，公司）
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 维修类别（打印机维修。。。）
     */
    @Column(name = "repair_type")
    private String repairType;

    /**
     * 备注
     */
    private String description;

    /**
     * 状态（0未分配，1已分配，2已完成,3，已取消）
     */
    private Short state;


    /**
     * 区县
     */
    private String district;

    /**
     * 预约时间
     */
    @Column(name = "repair_time")
    private String repairTime;

    private Short s;

    /**
     * 师傅id
     */
    @Column(name = "admin_id")
    private Integer adminId;

    /**
     * 备注图片
     */
    private String img;

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
     * 获取用户编号
     *
     * @return user_id - 用户编号
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取详细地址
     *
     * @return address - 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     *
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取下单时间
     *
     * @return create_time - 下单时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置下单时间
     *
     * @param createTime 下单时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取联系方式
     *
     * @return tel - 联系方式
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系方式
     *
     * @param tel 联系方式
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取维修类型（个人，公司）
     *
     * @return user_type - 维修类型（个人，公司）
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置维修类型（个人，公司）
     *
     * @param userType 维修类型（个人，公司）
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取维修类别（打印机维修。。。）
     *
     * @return repair_type - 维修类别（打印机维修。。。）
     */
    public String getRepairType() {
        return repairType;
    }

    /**
     * 设置维修类别（打印机维修。。。）
     *
     * @param repairType 维修类别（打印机维修。。。）
     */
    public void setRepairType(String repairType) {
        this.repairType = repairType == null ? null : repairType.trim();
    }

    /**
     * 获取备注
     *
     * @return description - 备注
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置备注
     *
     * @param description 备注
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取状态（0未分配，1已分配，2已完成,3，已取消）
     *
     * @return state - 状态（0未分配，1已分配，2已完成,3，已取消）
     */
    public Short getState() {
        return state;
    }

    /**
     * 设置状态（0未分配，1已分配，2已完成,3，已取消）
     *
     * @param state 状态（0未分配，1已分配，2已完成,3，已取消）
     */
    public void setState(Short state) {
        this.state = state;
    }

    /**
     * 获取区县
     *
     * @return district - 区县
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置区县
     *
     * @param district 区县
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * 获取预约时间
     *
     * @return repair_time - 预约时间
     */
    public String getRepairTime() {
        return repairTime;
    }

    /**
     * 设置预约时间
     *
     * @param repairTime 预约时间
     */
    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
    }

    /**
     * @return s
     */
    public Short getS() {
        return s;
    }

    /**
     * @param s
     */
    public void setS(Short s) {
        this.s = s;
    }

    /**
     * 获取师傅id
     *
     * @return admin_id - 师傅id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 设置师傅id
     *
     * @param adminId 师傅id
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取备注图片
     *
     * @return img - 备注图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置备注图片
     *
     * @param img 备注图片
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
    @Column(name = "price")
    private BigDecimal price;
    /**
     * 消耗积分
     */
    private Integer integral;

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    /**
     * 来源
     */
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}