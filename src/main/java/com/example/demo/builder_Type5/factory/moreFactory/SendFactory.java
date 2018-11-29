package com.example.demo.builder_Type5.factory.moreFactory;

import com.example.demo.builder_Type5.factory.ordinaryFactory.Mail;
import com.example.demo.builder_Type5.factory.ordinaryFactory.Sender;
import com.example.demo.builder_Type5.factory.ordinaryFactory.Sms;

/**
 * 多个工厂方法模式
 * 是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
 * 工厂类
 */
public class SendFactory {

    Sender produceMail() {
        return new Mail();
    }

    Sender produceSms() {
        return new Sms();
    }
}
