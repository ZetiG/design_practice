package com.example.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Description:
 * <p>
 * BeanPostProcessor 是在 spring 容器加载了 bean 的定义文件并且实例化 bean 之后执行的。
 * BeanPostProcessor 的执行顺序是在 BeanFactoryPostProcessor 之后。
 * </p>
 *
 * @author Zeti
 * @date 2020/10/10 10:30 上午
 */
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.err.println("执行BeanFactoryPostProcess...");


        // 在这里修改orderService bean的scope为PROTOTYPE
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("personAction");
        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);

        // 注意坑：如果此处Bean为单例模式，且此处已提前实例化Bean， 则BeanPostProcessor 的前后置方法不会执行
        PersonAction bean = beanFactory.getBean(PersonAction.class);
        bean.say();
    }


}
