///:InServiceEnum.java
package com.weyoung.wxapp.common.domain;

/**
 * @author icechen1219
 * @date 2019/08/16
 */
public enum InServiceEnum {
    /**
     * 离职
     */
    OUT(0, "离职"),
    /**
     * 在职
     */
    IN(1, "在职");


    /**
     * 在职状态：0-离职 1-在职
     */
    private int code;
    private String name;

    private InServiceEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static InServiceEnum parse(int code) {
        InServiceEnum[] values = InServiceEnum.values();
        for (InServiceEnum value : values) {
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
///:InServiceEnum.java
