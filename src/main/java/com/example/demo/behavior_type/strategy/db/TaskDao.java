package com.example.demo.behavior_type.strategy.db;

import com.example.demo.behavior_type.strategy.Task;
import com.example.demo.behavior_type.strategy.TaskTypeEnum;

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

        Task task = new Task();
        task.setTaskType(TaskTypeEnum.getByCode(type));
        task.setIsSelect(0);
        task.setAddIntegral(30);
        task.setUpperLimit(3);
        return task;
    }


}
