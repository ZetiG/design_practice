package com.example.demo._23_design_patterns.builder_Type5.behavior_type.observer;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2021/3/3 下午8:20
 */
public class Test {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.addObserver(new ConcreteObserver(subject,"xa"));
        subject.addObserver(new ConcreteObserver(subject,"xb"));
        subject.addObserver(new ConcreteObserver(subject,"xc"));
        subject.setSubjectState("观察者设计模式，又称发布订阅！，，发送通知。。。");
        subject.notifyAllObserver();
    }

}
