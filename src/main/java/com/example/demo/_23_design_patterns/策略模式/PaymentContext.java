package com.example.demo._23_design_patterns.策略模式;

/**
 * Description: 支付策略上下文
 *
 * @author Zeti
 * @date 2023/12/4 14:20
 */
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(int amount) {
        paymentStrategy.pay(amount);
    }

}
