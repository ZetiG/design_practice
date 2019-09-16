package com.example.demo.type.strategy;

/**
 * Description: 具体策略_1
 *
 * @Date 2019-09-16 18:47
 * @Author Zeti
 */
public class AliPay extends AbstractHandle {

    @Override
    Object handle() {
        System.out.println("Ali pay...");
        return null;
    }
}
