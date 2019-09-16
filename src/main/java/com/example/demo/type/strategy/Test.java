package com.example.demo.type.strategy;

/**
 * Description: 策略模式
 * <p>
 * 优点：减少 if-else 代码。避免代码阅读困难；解耦，真正实现 open close 原则，新增策略不影响原来的代码；
 * </p>
 * <p>
 * 缺点：如果策略较多，则代码编写负担较大，不同策略之间差异性由业务决定
 * </p>
 *
 * @Date 2019-09-16 18:54
 * @Author Zeti
 */
public class Test {

    public static void main(String[] args) {

        StrategyContext context1 = new StrategyContext(new AliPay());
        context1.context();
        StrategyContext context2 = new StrategyContext(new WeChatPay());
        context2.context();
        StrategyContext context3 = new StrategyContext(new BankPay());
        context3.context();
    }
}
