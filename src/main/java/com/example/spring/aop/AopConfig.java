package com.example.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/11/16 17:08
 */
@Configuration
//@EnableAspectJAutoProxy // 启用 AOP 自动代理
@EnableAspectJAutoProxy(proxyTargetClass = true) // 强制使用 CGLIB 代理
@ComponentScan("com.example.spring.aop") // 确保扫描到切面类
public class AopConfig {
    // 定义目标对象
    @Bean
    public MyService myService() {
        return new MyService();
    }

}


