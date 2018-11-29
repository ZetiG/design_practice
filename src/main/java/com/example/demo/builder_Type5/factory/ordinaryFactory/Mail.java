package com.example.demo.builder_Type5.factory.ordinaryFactory;

/**
 * 普通工厂模式
 * 发送邮件
 */
public class Mail implements Sender {

    @Override
    public void send() {
        System.out.println("this is mail");
    }
}
