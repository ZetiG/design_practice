package com.example.demo._23_design_patterns.发布订阅模式;

/**
 * Description: 测试程序
 * <>发布-订阅模式（Publish-Subscribe Pattern）是一种软件设计模式，其中对象（发布者）维护一个依赖对象列表（订阅者），
 * 当状态发生变化时通知所有订阅者。以下是一个简单的Java发布-订阅模式的示例，以一个新闻发布系统为例：</>
 *
 * @author Zeti
 * @date 2023/12/4 15:04
 */
public class Main {

    public static void main(String[] args) {
        // 创建一个事件的发布者
        NewsPublisher np = new NewsPublisher();

        // 订阅者1、2
        EmailSubscriber sb1 = new EmailSubscriber();
        SMSSubscriber sb2 = new SMSSubscriber();

        // 订阅者1，订阅该事件
        np.subscribe(sb1);

        // 发布消息1
        np.publishNews("发布消息1");

        // 订阅者2，订阅该事件
        np.subscribe(sb2);

        // 发布消息2
        np.publishNews("发布消息2");

        // 订阅者1，退订该事件
        np.unsubscribe(sb1);

        // 发布消息3
        np.publishNews("发布消息3");

    }


}
