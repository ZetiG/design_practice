package com.example.demo._23_design_patterns.策略模式;

/**
 * Description: 测试程序
 * <>策略模式是一种行为设计模式，它定义了一族算法、将每个算法封装起来，并且使它们可以互换。这种模式使得算法的变化独立于使用算法的客户。</>
 *
 * @author Zeti
 * @date 2023/12/4 14:20
 */
public class Main {

    public static void main(String[] args) {
        // 测试1
        PaymentContext pc1 = new PaymentContext(new WechatPayment());
        pc1.executePayment(10);

        // 测试2
        PaymentContext pc2 = new PaymentContext(new AliPayment());
        pc2.executePayment(20);


    }

}
