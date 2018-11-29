package com.example.demo.builder_Type5.abstractFactory;

/**
 * 抽象工厂模式
 * 测试
 */
public class Test {
    public static void main(String[] args) {
        new MailFactory().produce().Send();
        new SmsFactory().produce().Send();
    }
}
