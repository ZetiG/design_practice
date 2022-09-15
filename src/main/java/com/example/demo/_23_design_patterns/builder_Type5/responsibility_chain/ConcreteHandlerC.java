package com.example.demo._23_design_patterns.builder_Type5.responsibility_chain;

/**
 * Description: 策略模式-具体处理类C, 这里作为最后一个处理者 (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2022/9/15 15:25
 */
public class ConcreteHandlerC extends AbstractHandler {

    @Override
    public void handleRequest(String condition) {
        // 这里作为最后一个处理者
        System.out.println("ConcreteHandlerC最后处理");
    }
}
