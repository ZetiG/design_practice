package com.example.demo.builder_Type5.abstractFactory;

/**
 * 抽象工厂模式
 * 短信
 */
public class Sms implements Sender {
    @Override
    public void Send() {
       System.out.println("this is Sms");
    }
}
