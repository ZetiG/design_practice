package com.example.demo._23_design_patterns.builder_Type5.factory.staticFactory;

import com.example.demo._23_design_patterns.builder_Type5.factory.ordinaryFactory.Mail;
import com.example.demo._23_design_patterns.builder_Type5.factory.ordinaryFactory.Sender;
import com.example.demo._23_design_patterns.builder_Type5.factory.ordinaryFactory.Sms;

/**
 * 静态工厂方法模式
 * 将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 */
public class SendFactory {
    public static Sender produceMail() {
        return new Mail();
    }

    public static Sender produceSms() {
        return new Sms();
    }
}
