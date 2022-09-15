package com.example.demo._23_design_patterns.builder_Type5.responsibility_chain;

/**
 * Description: 策略模式-具体处理类B
 *
 * @author Zeti
 * @date 2022/9/15 15:21
 */
public class ConcreteHandlerB extends AbstractHandler {

    @Override
    public void handleRequest(String condition) {
        if (condition.equals("B")) {
            System.out.println("ConcreteHandlerB处理");
        } else {
            System.out.println("ConcreteHandlerB不处理，由其他的Handler处理");
            super.getHandler().handleRequest(condition);
        }
    }
}
