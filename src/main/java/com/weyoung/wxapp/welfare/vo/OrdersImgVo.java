package com.weyoung.wxapp.welfare.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author li
 */
public class OrdersImgVo {
    /**
     * 订单id
     */
    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "JDBC")
    private Integer orderId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 商品编号
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系人
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 备注
     */
    private String description;

    /**
     * 下单时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 状态（0待处理，1已处理，2：已完成，3已取消）
     */
    private Short state;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区县
     */
    private String district;

    /**
     * 区分订单和预约维修
     */
    private Integer s;

    /**
     * 师傅id
     */
    @Column(name = "admin_id")
    private Integer adminId;

    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
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
     * 获取联系人
     *
     * @return user_name - 联系人
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置联系人
     *
     * @param userName 联系人
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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
     * 获取单价
     *
     * @return price - 单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price 单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
     * 获取状态（0待处理，1已处理，2：已完成，3已取消）
     *
     * @return state - 状态（0待处理，1已处理，2：已完成，3已取消）
     */
    public Short getState() {
        return state;
    }

    /**
     * 设置状态（0待处理，1已处理，2：已完成，3已取消）
     *
     * @param state 状态（0待处理，1已处理，2：已完成，3已取消）
     */
    public void setState(Short state) {
        this.state = state;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
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
     * 获取区分订单和预约维修
     *
     * @return s - 区分订单和预约维修
     */
    public Integer getS() {
        return s;
    }

    /**
     * 设置区分订单和预约维修
     *
     * @param s 区分订单和预约维修
     */
    public void setS(Integer s) {
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
}
