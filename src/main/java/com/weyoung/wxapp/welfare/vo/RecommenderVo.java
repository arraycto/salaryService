package com.weyoung.wxapp.welfare.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author li
 * @date 2020-2-18
 */
public class RecommenderVo implements Serializable {
    /**
     * 微信名
     */
    private String userName;
    /**
     * 注册日期
     */
    private Date createTime;
    /**
     * 签到天数
     */
    private Integer signInNum;

    public Integer getSignInNum() {
        return signInNum;
    }

    public void setSignInNum(Integer signInNum) {
        this.signInNum = signInNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
