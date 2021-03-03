package com.example.demo.behavior_type.observer;

/**
 * Description: 抽象观察者类，为所有具体观察者抽象统一的接口，在得到主题改变的通知后更新自己
 *
 * @author Zeti
 * @date 2021/3/3 下午7:53
 */
public abstract class Observer {

    /**
     * 抽象更新方法
     */
    abstract void update();

}
