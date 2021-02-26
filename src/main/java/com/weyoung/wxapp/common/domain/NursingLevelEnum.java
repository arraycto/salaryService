///:InServiceEnum.java
package com.weyoung.wxapp.common.domain;

import java.util.Arrays;

/**
 * 护理等级
 *
 * @author icechen1219
 * @date 2019/08/16
 */
public enum NursingLevelEnum {
    /**
     * 自理
     */
    SELF_CATERING(0, "自理", new int[]{0}),
    /**
     * 介助
     */
    MEDIATE(1, "介助", new int[]{1}),

    /**
     * 介护
     */
    CARE(3, "介护", new int[]{2, 3});


    /**
     * 等级ID
     */
    private int code;
    /**
     * 等级名称
     */
    private String name;
    /**
     * 对应能力等级
     */
    private int[] capacityLevel;

    private NursingLevelEnum(int code, String name, int[] capacityLevel) {
        this.code = code;
        this.name = name;
        this.capacityLevel = capacityLevel;
    }

    public static NursingLevelEnum parse(int code) {
        NursingLevelEnum[] values = NursingLevelEnum.values();
        for (NursingLevelEnum value : values) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

    public static NursingLevelEnum parse(String name) {
        NursingLevelEnum[] values = NursingLevelEnum.values();
        for (NursingLevelEnum value : values) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }

    public static NursingLevelEnum parseCapacityLevel(int capacityLevel) {
        NursingLevelEnum[] values = NursingLevelEnum.values();
        for (NursingLevelEnum value : values) {
            if (Arrays.binarySearch(value.capacityLevel, capacityLevel) != -1) {
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
