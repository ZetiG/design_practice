package com.example.demo.builder_Type5.abstractFactory;

/**
 * 短信工厂
 */
public class SmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new Sms();
    }
}
