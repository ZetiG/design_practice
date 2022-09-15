package com.example.demo._23_design_patterns.builder_Type5.responsibility_chain;

/**
 * Description: 策略模式-具体处理类A
 *
 * @author Zeti
 * @date 2022/9/15 15:21
 */
public class ConcreteHandlerA extends AbstractHandler {

    @Override
    public void handleRequest(String condition) {
        if (condition.equals("A")) {
            System.out.println("ConcreteHandlerA处理");
        } else {
            System.out.println("ConcreteHandlerA不处理，由其他的Handler处理");
            super.getHandler().handleRequest(condition);
        }
    }
}
