package com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy.task;

import com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy.AbstractTaskOperate;
import com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy.TaskTypeEnum;

/**
 * Description: 测试任务2 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/1 2:14 下午
 */
public class Task02 extends AbstractTaskOperate {

    public Task02() {
        this.setTaskType(TaskTypeEnum.TASK_02);
    }


}
