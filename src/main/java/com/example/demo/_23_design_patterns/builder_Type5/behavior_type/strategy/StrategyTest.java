package com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy;

import java.lang.reflect.InvocationTargetException;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/1 3:00 下午
 */
public class StrategyTest {


    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        Task01 task01 = new Task01();

//        System.err.println("当前任务是否启用：" + task01.isEnable());
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


        StrategyContext.addUserIntegral(TaskTypeEnum.TASK_03, 1L);


    }

}
