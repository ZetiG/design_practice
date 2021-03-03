package com.example.demo.behavior_type.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 抽象主题类，将所有的观察者对象的引用保存在一个集合里，
 * 每个主题都可以有任何数量的观察者，抽象观察者类可提供增加或删除观察者方法
 *
 * @author Zeti
 * @date 2021/3/3 下午8:00
 */
public abstract class Subject {

    private List<Observer> obList = new ArrayList<>();

    /**
     * 新增观察者
     *
     * @param observer
     */
    public void addObserver(Observer observer) {
        obList.add(observer);
    }

    /**
     * 新增观察者
     *
     * @param observer
     */
    public void reduceObserver(Observer observer) {
        obList.remove(observer);
    }

    /**
     * 通知所有观察者更新
     */
    public void notifyAllObserver() {
        for (Observer observer : obList) {
            observer.update();
        }
    }


}
