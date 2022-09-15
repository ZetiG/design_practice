package com.example.demo._23_design_patterns.builder_Type5.responsibility_chain;

/**
 * Description: 策略模式-发起请求 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2022/9/15 15:26
 */
public class ChainClient {

    public static void main(String[] args) {
        AbstractHandler handlerA = new ConcreteHandlerA();
        AbstractHandler handlerB = new ConcreteHandlerB();
        AbstractHandler handlerC = new ConcreteHandlerC();

        // 如无法处理转交给其他handler
        handlerA.setHandler(handlerB);
        handlerB.setHandler(handlerC);

        // 开始处理请求
        handlerA.handleRequest("C");

    }

}
