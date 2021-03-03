package com.example.demo.behavior_type.observer;

/**
 * Description: 具体主题
 *
 * @author Zeti
 * @date 2021/3/3 下午8:17
 */
public class ConcreteObserver extends Observer {

    private String name;
    private ConcreteSubject subject;
    private String observerState;

    public ConcreteObserver(ConcreteSubject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    public String getState() {
        return observerState;
    }

    public void setState(String state) {
        this.observerState = state;
    }

    @Override
    void update() {
        observerState = subject.getSubjectState();
        System.out.println("观察者：" + name + "  您订阅的主题状态有更新： " + observerState);
    }


}
