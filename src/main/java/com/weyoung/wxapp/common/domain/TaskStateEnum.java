///:TaskStateEnum.java
package com.weyoung.wxapp.common.domain;

/**
 * 任务完成状态枚举类
 *
 * @author icechen1219
 * @date 2019/08/14
 */
public enum TaskStateEnum {
    /**
     * 全部
     */
    ALL(0, "全部"),
    /**
     * 已完成
     */
    FINISH(1, "已完成"),
    /**
     * 进行中
     */
    DOING(2, "进行中"),
    /**
     * 已逾期
     */
    OVERDUE(3, "已逾期");


    /**
     * 执行形式：0-拍照 1-视频 2-前后照片对比 3-填写
     */
    private int code;
    private String name;

    private TaskStateEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static TaskStateEnum parse(int code) {
        TaskStateEnum[] values = TaskStateEnum.values();
        for (TaskStateEnum value : values) {
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
///:TaskStateEnum.java
