package com.example.demo.behavior_type.strategy.db;

import com.example.demo.behavior_type.strategy.TaskTypeEnum;
import com.example.demo.behavior_type.strategy.entity.Task;

/**
 * Description: 模拟任务信息数据库操作 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/1 2:06 下午
 */
public class TaskDao {

    /**
     * 查询任务是否启用
     *
     * @param type
     * @return
     */
    public Task selectByType(Integer type) {
        String msgByCode = TaskTypeEnum.getMsgByCode(type);
        System.out.println("查询任务数据库，当前任务：" + msgByCode);

        Task abstractTask = new Task();
        abstractTask.setTaskType(TaskTypeEnum.TASK_02.getCode());
        abstractTask.setIsSelect(0);
        abstractTask.setAddIntegral(30);
        abstractTask.setUpperLimit(3);
        return abstractTask;
    }


}
