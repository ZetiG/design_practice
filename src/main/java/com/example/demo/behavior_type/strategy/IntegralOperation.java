package com.example.demo.behavior_type.strategy;

/**
 * Description: 积分操作接口（积分操作的基本方法）
 *
 * @author Zeti
 * @date 2020/8/1 10:41 上午
 */
public interface IntegralOperation {

    /**
     * 查询积分
     *
     * @return
     */
    Integer getIntegral();

    /**
     * 增加积分
     *
     * @return
     */
    Integer addIntegral(Integer var);

    /**
     * 减少积分
     *
     * @return
     */
    Integer reduceIntegral(Integer var);


}
