package com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy;

import java.lang.reflect.InvocationTargetException;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/6 6:22 下午
 */
public class StrategyFactory {
    private static final StrategyFactory factory = new StrategyFactory();

    public static StrategyFactory getInstance() {
        return factory;
    }

    public IntegralOperation getTaskInterfaceByType(Integer taskType) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        if (taskType == null) return null;
        return TaskTypeEnum.getByCode(taskType).getIntegralOperation().getConstructor().newInstance();
    }


}
