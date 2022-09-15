package com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy;

import java.lang.reflect.InvocationTargetException;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/6 6:27 下午
 */
public class StrategyContext {

    private StrategyContext() {
    }

    public static boolean addUserIntegral(TaskTypeEnum typeEnum, Long userId) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        IntegralOperation integralOperation = StrategyFactory.getInstance().getTaskInterfaceByType(typeEnum.getCode());
        return integralOperation.addIntegral(userId) > 0;
    }



}
