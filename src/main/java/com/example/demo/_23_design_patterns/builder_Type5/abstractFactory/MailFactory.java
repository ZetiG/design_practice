package com.example.demo._23_design_patterns.builder_Type5.abstractFactory;

/**
 * 邮件工厂
 */
public class MailFactory implements Provider {
    @Override
    public Sender produce() {
        return new Mail();
    }
}
