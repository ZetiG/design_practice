package com.example.demo._23_design_patterns.观察者模式;

/**
 * Description: 主题接口
 *
 * @author Zeti
 * @date 2023/12/4 14:28
 */
public interface Subject {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
