package com.example.demo.behavior_type.strategy;


import lombok.Getter;

/**
 * Description: 任务类型枚举类
 *
 * @Date 2020/5/22 10:20
 * @Author Zeti
 */

public enum TaskTypeEnum {

    TASK_01(1, "测试任务1"),
    TASK_02(2, "测试任务2"),
    TASK_03(3, "测试任务3"),
    ;

    /**
     * 任务名称
     */
    @Getter
    public final String taskName;

    /**
     * 任务类型code
     */
    @Getter
    private final Integer code;


    TaskTypeEnum(Integer code, String taskName) {
        this.code = code;
        this.taskName = taskName;
    }

    /**
     * 根据类型code查询对应name
     *
     * @param code
     * @return
     */
    public static String getMsgByCode(Integer code) {
        if (null != code) {
            for (TaskTypeEnum value : TaskTypeEnum.values()) {
                if (value.code.equals(code)) return value.taskName;
            }
        }
        return null;
    }

    /**
     * 枚举值校验
     *
     * @param code
     * @return
     */
    public static Integer getCode(Integer code) {
        if (code == null) return null;
        for (TaskTypeEnum value : TaskTypeEnum.values()) {
            if (value.code.equals(code)) return code;
        }
        return null;
    }

    /**
     * 通过code匹配对应的任务
     *
     * @param code
     * @return
     */
    public static TaskTypeEnum getByCode(Integer code) {
        if (code == null) return null;
        for (TaskTypeEnum value : TaskTypeEnum.values()) {
            if (value.code.equals(code)) return value;
        }
        return null;
    }
}
