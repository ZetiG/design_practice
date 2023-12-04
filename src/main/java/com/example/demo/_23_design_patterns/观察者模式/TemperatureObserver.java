package com.example.demo._23_design_patterns.观察者模式;

/**
 * Description: 具体的观察者
 *
 * @author Zeti
 * @date 2023/12/4 14:27
 */
public class TemperatureObserver implements Observer {

    @Override
    public void update(int temperature) {
        System.out.println("TemperatureObserver: Temperature is now " + temperature);
    }

}
