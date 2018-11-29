package com.example.demo.builder_Type5.builder;

import com.example.demo.builder_Type5.factory.ordinaryFactory.Mail;
import com.example.demo.builder_Type5.factory.ordinaryFactory.Sender;
import com.example.demo.builder_Type5.factory.ordinaryFactory.Sms;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 * 工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，
 * 用来创建复合对象，所谓复合对象就是指某个类具有不同的属性，其实建造者模式就是前面抽象工厂模式和最后的Test结合起来得到的。
 */
public class Builder {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMail(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new Mail());
        }
    }

    public void produceSms(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new Sms());
        }
    }
}
