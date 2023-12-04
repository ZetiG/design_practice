package com.example.demo._23_design_patterns.策略模式;

/**
 * Description:
 *
 * @author Zeti
 * @date 2023/12/4 14:19
 */
public class AliPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Alipay");
    }
}
