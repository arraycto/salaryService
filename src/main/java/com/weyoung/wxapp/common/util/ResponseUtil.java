package com.weyoung.wxapp.common.util;

import com.weyoung.wxapp.common.domain.JsonResult;

import java.util.HashMap;

/**
 * 响应请求的工具类。
 * 简化返回编码和消息的封装。
 *
 * @see org.springframework.http.HttpStatus
 */
public class ResponseUtil {
    public static final int OK = 1;
    public static final String OK_MSG = "成功";

    public static final int FAIL = 0;
    public static final String FAIL_MSG = "失败";

    public static final int NOT_LOGIN = -1;
    public static final String NOT_LOGIN_MSG = "未登录";

    public static final int UNKOWN_EXCEPTION = -2;
    public static final String EXCEPTION_MSG = "未知错误";

    // 以上是小程序端要求的编码

    public static final int NOT_DATA = 1101;
    public static final String NOT_DATA_MSG = "查询无结果！";

    public static final int ERROR_ADD = 1102;
    public static final String ERROR_ADD_MSG = "添加失败";

    public static final int ERROR_UPDATE = 1103;
    public static final String ERROR_UPDATE_MSG = "修改失败";

    public static final int ERROR_DELETE = 1104;
    public static final String ERROR_DELETE_MSG = "删除失败";

    public static final int ERROR_OPERATE = 1105;
    public static final String ERROR_OPERATE_MSG = "操作失败";

    public static final int ERROR_EXPORT_NO_DATA = 1106;
    public static final String ERROR_EXPORT_NO_DATA_MSG = "导出数据为空！";

    public static final int ERROR_EXPORT_FAILD = 1107;
    public static final String ERROR_EXPORT_FAILD_MSG = "导出文件失败，请联系网站管理员！";

    private static final HashMap<Integer, String> CODE_MAP;

    static {
        CODE_MAP = init();

    }

    /**
     * 根据响应码生成JsonResult对象
     *
     * @param code
     * @return
     */
    public static JsonResult buildResult(Integer code) {
        return new JsonResult(code);
    }

    /**
     * 获得对应的响应消息
     *
     * @param code
     * @return
     */
    public static String getMsg(int code) {
        return CODE_MAP.get(code);
    }

    public static JsonResult ok() {
        return new JsonResult(OK);
    }

    public static JsonResult fail() {
        return new JsonResult(FAIL);
    }

    public static JsonResult noLogin() {
        return new JsonResult(NOT_LOGIN);
    }

    public static JsonResult unkownException() {
        return new JsonResult(UNKOWN_EXCEPTION);
    }

    private static HashMap<Integer, String> init() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(NOT_DATA, NOT_DATA_MSG);
        map.put(UNKOWN_EXCEPTION, EXCEPTION_MSG);
        map.put(ERROR_UPDATE, ERROR_UPDATE_MSG);
        map.put(ERROR_DELETE, ERROR_DELETE_MSG);
        map.put(ERROR_ADD, ERROR_ADD_MSG);
        map.put(ERROR_OPERATE, ERROR_OPERATE_MSG);
        map.put(ERROR_EXPORT_NO_DATA, ERROR_EXPORT_NO_DATA_MSG);
        map.put(ERROR_EXPORT_FAILD, ERROR_EXPORT_FAILD_MSG);

        // 小程序端要求的编码
        map.put(OK, OK_MSG);
        map.put(NOT_LOGIN, NOT_LOGIN_MSG);
        map.put(FAIL, FAIL_MSG);
        map.put(UNKOWN_EXCEPTION, EXCEPTION_MSG);
        return map;
    }


}
