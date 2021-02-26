package com.weyoung.wxapp.welfare.domain;

import javax.persistence.*;

@Table(name = "salary_list")
public class SalaryList {
    @Id
    @Column(name = "list_id")
    @GeneratedValue(generator = "JDBC")
    private Integer listId;

    /**
     * 工号
     */
    @Column(name = "work_id")
    private String workId;

    /**
     * 金额
     */
    private String money;

    /**
     * 扣款事由
     */
    private String word;

    /**
     * 申请状态
     */
    private String status;

    /**
     * @return list_id
     */
    public Integer getListId() {
        return listId;
    }

    /**
     * @param listId
     */
    public void setListId(Integer listId) {
        this.listId = listId;
    }

    /**
     * 获取工号
     *
     * @return work_id - 工号
     */
    public String getWorkId() {
        return workId;
    }

    /**
     * 设置工号
     *
     * @param workId 工号
     */
    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    /**
     * 获取金额
     *
     * @return money - 金额
     */
    public String getMoney() {
        return money;
    }

    /**
     * 设置金额
     *
     * @param money 金额
     */
    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    /**
     * 获取扣款事由
     *
     * @return word - 扣款事由
     */
    public String getWord() {
        return word;
    }

    /**
     * 设置扣款事由
     *
     * @param word 扣款事由
     */
    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    /**
     * 获取申请状态
     *
     * @return status - 申请状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置申请状态
     *
     * @param status 申请状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}