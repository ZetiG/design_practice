package com.example.spring.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/11/16 15:41
 */
public class ProxyFactory implements InvocationHandler {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    public Object getProxyInstance2() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {System.err.println("代理start");
                                            Object invoke = method.invoke(target, args);
                                            System.err.println("代理end");
                                            return invoke;});
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("代理start");
        Object invoke = method.invoke(target, args);
        System.err.println("代理end");
        return invoke;
    }
}
