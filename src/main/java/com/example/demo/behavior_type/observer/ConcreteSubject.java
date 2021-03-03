package com.example.demo.behavior_type.observer;

/**
 * Description: 具体主题
 *
 * @author Zeti
 * @date 2021/3/3 下午8:14
 */
public class ConcreteSubject extends Subject{

    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }

}
