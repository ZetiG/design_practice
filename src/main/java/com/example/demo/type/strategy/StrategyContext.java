package com.example.demo.type.strategy;

/**
 * Description: 为策略提供一个全局访问的入口，可以隐藏具体的策略
 *
 * @Date 2019-09-16 18:52
 * @Author Zeti
 */
public class StrategyContext {

    private AbstractHandle abstractHandle;

    StrategyContext(AbstractHandle abstractHandle) {
        this.abstractHandle = abstractHandle;
    }

    public Object context() {
        return abstractHandle.handle();
    }

}
