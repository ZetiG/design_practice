package com.example.demo._23_design_patterns.builder_Type5.factory.ordinaryFactory;

/**
 * 普通工厂模式
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * 测试
 */
public class FactoryTest {
    public static void main(String[] args) {
        new SendFactory().produce("sms").send();
    }
}
