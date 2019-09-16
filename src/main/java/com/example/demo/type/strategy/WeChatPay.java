package com.example.demo.type.strategy;

/**
 * Description: 具体策略_2
 *
 * @Date 2019-09-16 18:48
 * @Author Zeti
 */
public class WeChatPay extends AbstractHandle {

    @Override
    Object handle() {
        System.out.println("WeChat pay...");
        return null;
    }
}
