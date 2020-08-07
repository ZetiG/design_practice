package com.example.demo.behavior_type.strategy;

import java.lang.reflect.InvocationTargetException;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/6 6:27 下午
 */
public class StrategyContext {


    public static boolean addUserIntegral(Integer taskType, Long userId) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        IntegralOperation integralOperation = StrategyFactory.getInstance().getTaskInterfaceByType(taskType);
        return integralOperation.addIntegral(userId) > 0;
    }

}
