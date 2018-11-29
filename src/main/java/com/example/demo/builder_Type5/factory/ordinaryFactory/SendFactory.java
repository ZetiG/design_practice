package com.example.demo.builder_Type5.factory.ordinaryFactory;

/**
 * 普通工厂模式
 * 工厂类
 */
public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new Mail();
        } else if ("sms".equals(type)) {
            return new Sms();
        } else {
            System.out.println("请输入正确的类型");
        }
        return null;
    }
}
