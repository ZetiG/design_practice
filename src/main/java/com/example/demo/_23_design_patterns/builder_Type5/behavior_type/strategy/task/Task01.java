package com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy.task;

import com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy.AbstractTaskOperate;
import com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy.TaskTypeEnum;

/**
 * Description: 测试任务1 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/1 11:22 上午
 */
public class Task01 extends AbstractTaskOperate {

    private static final long serialVersionUID = 5124052619410993326L;

    public Task01() {
        this.setTaskType(TaskTypeEnum.TASK_01);
    }


}
