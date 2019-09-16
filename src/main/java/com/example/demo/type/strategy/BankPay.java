package com.example.demo.type.strategy;

/**
 * Description: 具体策略_3
 *
 * @Date 2019-09-16 18:50
 * @Author Zeti
 */
public class BankPay extends AbstractHandle {

    @Override
    Object handle() {
        System.out.println("Bank pay...");
        return null;
    }
}
