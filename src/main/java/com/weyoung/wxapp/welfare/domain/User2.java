package com.weyoung.wxapp.welfare.domain;

import javax.persistence.*;

public class User2 {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private Integer userId;

    /**
     * 工号
     */
    @Column(name = "workId")
    private String workid;

    /**
     * 电话
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    /**
     * 事由
     */
    private String word;

    /**
     * 性别
     */
    private String sex;

    /**
     * 工资
     */
    private String salary;

    /**
     * 角色
     */
    private String dept;


    /**
     * 用户名
     */
    private String username;


    /**
     * 密码
     */
    private Integer password;

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
    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * 获取工号
     *
     * @return workId - 工号
     */
    public String getWorkid() {
        return workid;
    }

    /**
     * 设置工号
     *
     * @param workid 工号
     */
    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
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
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
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
     * 获取角色
     *
     * @return dept - 角色
     */
    public String getDept() {
        return dept;
    }

    /**
     * 设置角色
     *
     * @param dept 角色
     */
    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }
}