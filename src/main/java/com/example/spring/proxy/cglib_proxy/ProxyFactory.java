package com.example.spring.proxy.cglib_proxy;

import javassist.util.proxy.MethodHandler;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/11/16 16:21
 */
public class ProxyFactory implements MethodInterceptor {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 为目标生成代理对象
    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());  // 设置父类
        enhancer.setCallback(this); // 回调函数
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.err.println("代理start");
        Object invoke = method.invoke(target, args);
        System.err.println("代理end");
        return invoke;
    }

}
