package com.weyoung.wxapp.common.domain;

/**
 * 商品类别枚举类
 * @author li
 * @date 2019-11-16
 */
public enum CateGoryEnum {
    /**
     * 办公用纸
     */
    PHOTOGRAPH(1, "办公用纸"),
    /**
     * 书写工具
     */
    VIDEO(2, "书写工具");



    /**
     * 执行形式：1-办公用纸 2-书写工具
     */
    private int code;
    private String name;

    private CateGoryEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static CateGoryEnum parse(int code) {
        CateGoryEnum[] values = CateGoryEnum.values();
        for (CateGoryEnum value : values) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

    public int value() {
        return code;
    }

    public String label() {
        return name;
    }
}
