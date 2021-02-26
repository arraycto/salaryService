///:ExecuteFormEnum.java
package com.weyoung.wxapp.common.domain;

/**
 * 执行形式枚举类
 *
 * @author icechen1219
 * @date 2019/08/14
 */
public enum ExecuteFormEnum {
    /**
     * 拍照
     */
    PHOTOGRAPH(0, "拍照"),
    /**
     * 视频
     */
    VIDEO(1, "视频"),
    /**
     * 对比
     */
    COMPARISON(2, "前后照片对比"),
    /**
     * 填写
     */
    FILLIN(3, "填写");


    /**
     * 执行形式：0-拍照 1-视频 2-前后照片对比 3-填写
     */
    private int code;
    private String name;

    private ExecuteFormEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ExecuteFormEnum parse(int code) {
        ExecuteFormEnum[] values = ExecuteFormEnum.values();
        for (ExecuteFormEnum value : values) {
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
///:ExecuteFormEnum.java
