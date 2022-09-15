package com.example.demo._23_design_patterns.builder_Type5.behavior_type.strategy;

/**
 * Description: 积分操作接口（积分操作的基本方法）
 *
 * @author Zeti
 * @date 2020/8/1 10:41 上午
 */
public interface IntegralOperation {

    /**
     * 增加积分
     *
     * @return
     */
    Integer addIntegral(Long userId);


    /**
     * 减少积分
     *
     * @return
     */
    default Integer reduceIntegral(Long userId) {
        return null;
    }


}
