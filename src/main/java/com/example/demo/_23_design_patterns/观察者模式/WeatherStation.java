package com.example.demo._23_design_patterns.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 实现主题的类
 *
 * @author Zeti
 * @date 2023/12/4 14:29
 */
public class WeatherStation implements Subject {
    private int temperature;
    private List<Observer> observers;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
