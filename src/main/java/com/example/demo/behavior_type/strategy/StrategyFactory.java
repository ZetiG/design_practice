package com.example.demo.behavior_type.strategy;

import com.example.demo.behavior_type.strategy.task.Task01;
import com.example.demo.behavior_type.strategy.task.Task02;
import com.example.demo.behavior_type.strategy.task.Task03;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/6 6:22 下午
 */
public class StrategyFactory {
    private static StrategyFactory factory = new StrategyFactory();

    public StrategyFactory() {
    }

    public static StrategyFactory getInstance() {
        return factory;
    }

    public IntegralOperation getTaskInterfaceByType(Integer taskType) throws IllegalAccessException,
            InstantiationException {
        if (taskType == null) return null;
        return TaskTypeEnum.TASK_01.getIntegralOperation().newInstance();

    }


}
