package com.example.demo._23_design_patterns.builder_Type5.factory.moreFactory;


/**
 * 多个工厂方法模式
 * 是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
 * 测试
 */
public class FactoryTest {
    public static void main(String[] args) {
        new SendFactory().produceMail().send();
    }
}
