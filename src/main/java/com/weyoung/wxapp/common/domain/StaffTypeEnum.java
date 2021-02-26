///:InServiceEnum.java
package com.weyoung.wxapp.common.domain;

/**
 * @author icechen1219
 * @date 2019/08/16
 */
public enum StaffTypeEnum {
    /*
管理人员
护理人员
膳食服务人员
其他工作人员
     */

    /**
     * 离职
     */
    DEFAULT(0, "其他工作人员"),
    /**
     * 管理人员
     */
    MANAGER(1, "管理人员"),
    /**
     * 护理人员
     */
    PARAMEDIC(2, "护理人员"),
    /**
     * 膳食服务人员
     */
    FOOD_SERVICE(3, "膳食服务人员");


    /**
     * 执行形式：0-拍照 1-视频 2-前后照片对比 3-填写
     */
    private int code;
    private String name;

    private StaffTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static StaffTypeEnum parse(int code) {
        StaffTypeEnum[] values = StaffTypeEnum.values();
        for (StaffTypeEnum value : values) {
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
