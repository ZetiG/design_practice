package com.example.spring.proxy.jdk_proxy;

/**
 * Description: 测试jdk动态代理能否代理未实现任何接口的类
 *
 * @author Zeti
 * @date 2024/11/16 16:12
 */
public class Person {

    public void getUser(Long id) {
        System.err.printf("用户-userId:[%d]%n", id);
    }

}
