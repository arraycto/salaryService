package com.weyoung.wxapp.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.weyoung.wxapp.common.util.ResponseUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * API数据模型。用于向前端返回统一的数据结构。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("API响应数据模型")
public class JsonResult implements Serializable {

    /**
     * 响应编码
     */
    @ApiModelProperty(value = "响应码", required = true, example = "200/401/404/501...")
    private int status;
    /**
     * 响应消息
     */
    @ApiModelProperty(value = "响应文本消息", example = "OK/未授权的操作")
    private String msg;
    /**
     * 响应数据
     */
    @ApiModelProperty(value = "返回的数据结构", example = "{\"username\":\"张三\"}")
    private Object data;
    /**
     * 数据条数：用于分页
     */
    @ApiModelProperty(value = "列表查询时的数据总数", notes = "通常用于分页查询计算总页数", example = "99")
    private Integer count;

    /**
     * 返回的记录条数
     */
    @ApiModelProperty(value = "返回的记录条数", notes = "返回的记录条数", example = "10")
    private int total;
    /**
     * 响应数据
     */
    @ApiModelProperty(value = "返回的数据结构", example = "{\"username\":\"张三\"}")
    private Object rows;

    public JsonResult(int status) {
        this.status = status;
        this.msg = ResponseUtil.getMsg(status);
    }

    /*public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(int code, Integer count, String msg) {
        this.code = code;
        this.count = count;
        this.msg = msg;
    }*/

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + this.status +
                "message='" + this.msg +
                "total=" + this.total +
                ", rows='" + this.rows + '\'' +
                '}';
    }
}
