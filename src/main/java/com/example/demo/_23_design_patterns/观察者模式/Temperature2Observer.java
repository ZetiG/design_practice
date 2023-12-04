package com.example.demo._23_design_patterns.观察者模式;

/**
 * Description: 具体的观察者2
 *
 * @author Zeti
 * @date 2023/12/4 14:36
 */
public class Temperature2Observer implements Observer{
    @Override
    public void update(int temperature) {
        System.out.println("Temperature2_Observer: Temperature 2 is now " + temperature);
    }
}
