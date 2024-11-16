package com.example.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/11/16 17:09
 */
public class TestMain {

    public static void main(String[] args) {
        // 加载 Spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        // 获取目标 Bean（代理对象）
        MyService myService = context.getBean(MyService.class);

        // 调用方法
        myService.performTask();

        // 关闭上下文
        context.close();
    }
}
