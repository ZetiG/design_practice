package com.example.demo.type.strategy;

/**
 * Description: 抽象类，提取供子类不同策略去实现的共同方法
 *
 * @Date 2019-09-16 18:40
 * @Author Zeti
 */
public abstract class AbstractHandle {

    /**
     * 抽象方法，供子类处理实际业务
     *
     * @return
     */
    abstract Object handle();
}
