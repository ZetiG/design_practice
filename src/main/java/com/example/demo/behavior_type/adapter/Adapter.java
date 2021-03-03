package com.example.demo.behavior_type.adapter;

/**
 * Description: 适配器
 *
 * @author Zeti
 * @date 2021/3/3 下午7:36
 */
public class Adapter implements Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adaptecMethod();
    }

}
