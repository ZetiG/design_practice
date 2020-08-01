package com.example.demo.behavior_type.strategy.task;

import com.example.demo.behavior_type.strategy.AbstractTaskOperate;
import com.example.demo.behavior_type.strategy.TaskTypeEnum;

/**
 * Description: 测试任务1 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/1 11:22 上午
 */
public class Task01 extends AbstractTaskOperate {

    public Task01() {
        this.setTaskType(TaskTypeEnum.TASK_01);
    }


}
