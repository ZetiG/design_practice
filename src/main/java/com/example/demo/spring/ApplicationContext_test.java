package com.example.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/10/9 11:16 上午
 */
public class ApplicationContext_test {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/PersonAction.xml");
        System.out.println("context 启动成功");

        PersonAction bean = context.getBean(PersonAction.class);
        bean.say();


    }

}
