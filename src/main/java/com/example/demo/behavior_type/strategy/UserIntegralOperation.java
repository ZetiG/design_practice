package com.example.demo.behavior_type.strategy;

/**
 * Description: 用户积分操作 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/1 4:40 下午
 */
public interface UserIntegralOperation extends IntegralOperation {

    /**
     * 查询积分
     *
     * @return
     */
    Integer getIntegral(Long userId);

    /**
     * 增加积分
     *
     * @return
     */
    Integer addIntegral(Long userId, Integer var);

    /**
     * 减少积分
     *
     * @return
     */
    Integer reduceIntegral(Long userId, Integer var);


}
