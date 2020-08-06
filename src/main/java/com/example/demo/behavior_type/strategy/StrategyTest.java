package com.example.demo.behavior_type.strategy;

import com.example.demo.behavior_type.strategy.task.Task01;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/1 3:00 下午
 */
public class StrategyTest {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Task01 task01 = new Task01();

//        boolean enable = task01.isEnable();
//        System.err.println("当前任务是否启用：" + enable);
//
//
//        // 当前任务奖励积分值
//        Integer taskIntegral = task01.getTaskIntegral();
//        System.err.println("当前任务奖励积分值：" + taskIntegral);
//
//        // 查询任务可执行总次数
//        Integer taskTotalFrequency = task01.getTaskTotalFrequency();
//        System.err.println("查询任务可执行总次数：" + taskTotalFrequency);
//
//        //  任务是否完成
//        boolean completeTask = task01.isCompleteTask();
//        System.err.println("任务是否完成：" + completeTask);

        StrategyContext.addUserIntegral(1, 1L);


    }

}
