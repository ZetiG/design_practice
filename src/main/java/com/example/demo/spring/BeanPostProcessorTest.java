package com.example.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Description:  BeanPostProcessor 接口的作用是 在获取Bean 的前置或者后置
 * 注意坑：如果Bean为单例模式，且已提前实例化Bean， 则BeanPostProcessor 的前后置方法不会执行
 *
 * @author Zeti
 * @date 2020/10/10 10:30 上午
 */
public class BeanPostProcessorTest implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("调用BeanPostProcessor before..." + beanName);

        PersonAction action = (PersonAction) bean;
        action.setName("小王");
        action.say();
        return action;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("调用BeanPostProcessor after..." + beanName);

        PersonAction action = (PersonAction) bean;
        action.setName("小三");
        return action;

    }
}
