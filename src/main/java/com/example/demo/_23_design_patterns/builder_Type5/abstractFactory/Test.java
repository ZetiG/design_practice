package com.example.demo._23_design_patterns.builder_Type5.abstractFactory;

/**
 * 抽象工厂模式
 *
 * <p>
 *     抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。
 *  在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。
 * </p>
 * 测试
 */
public class Test {
    public static void main(String[] args) {
        new MailFactory().produce().Send();
        new SmsFactory().produce().Send();
    }
}
