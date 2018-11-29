package com.example.demo.builder_Type5.abstractFactory;

/**
 * 抽象工厂模式
 * 邮件
 */
public class Mail implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mail");
    }
}
