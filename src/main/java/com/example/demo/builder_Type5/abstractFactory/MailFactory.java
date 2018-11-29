package com.example.demo.builder_Type5.abstractFactory;

/**
 * 邮件工厂
 */
public class MailFactory implements Provider {
    @Override
    public Sender produce() {
        return new Mail();
    }
}
