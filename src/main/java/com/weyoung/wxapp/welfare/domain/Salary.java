package com.weyoung.wxapp.welfare.domain;

import java.util.Date;
import javax.persistence.*;

public class Salary {
    @Id
    @Column(name = "salary_id")
    @GeneratedValue(generator = "JDBC")
    private Integer salaryId;

    /**
     * 工号
     */
    @Column(name = "work_id")
    private String workId;

    /**
     * 工资
     */
    private String salary;


    /**
     * 事由
     */
    private String word;

    /**
     * 时间
     */
    private Date time;

    /**
     * 扣款金额
     */
    private String costmoney;

    /**
     * 总工时
     */
    private String total;

    /**
     * @return salary_id
     */
    public Integer getSalaryId() {
        return salaryId;
    }

    /**
     * @param salaryId
     */
    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
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
     * 获取工资
     *
     * @return salary - 工资
     */
    public String getSalary() {
        return salary;
    }

    /**
     * 设置工资
     *
     * @param salary 工资
     */
    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    /**
     * 获取时间
     *
     * @return time - 时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置时间
     *
     * @param time 时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取扣款金额
     *
     * @return costmoney - 扣款金额
     */
    public String getCostmoney() {
        return costmoney;
    }

    /**
     * 设置扣款金额
     *
     * @param costmoney 扣款金额
     */
    public void setCostmoney(String costmoney) {
        this.costmoney = costmoney == null ? null : costmoney.trim();
    }

    /**
     * 获取总工时
     *
     * @return total - 总工时
     */
    public String getTotal() {
        return total;
    }

    /**
     * 设置总工时
     *
     * @param total 总工时
     */
    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}