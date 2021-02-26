package com.weyoung.wxapp.welfare.domain;

import javax.persistence.*;

@Table(name = "service_list")
public class ServiceList {
    @Id
    @Column(name = "service_id")
    @GeneratedValue(generator = "JDBC")
    private Integer serviceId;

    /**
     * 名称
     */
    @Column(name = "service_name")
    private String serviceName;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片
     */
    private String img;

    /**
     * @return service_id
     */
    public Integer getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId
     */
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * 获取名称
     *
     * @return service_name - 名称
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 设置名称
     *
     * @param serviceName 名称
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
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