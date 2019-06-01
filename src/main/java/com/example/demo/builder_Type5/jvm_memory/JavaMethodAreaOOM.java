package com.example.demo.builder_Type5.jvm_memory;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * JVM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * <p>
 * 借助CGLib不断产生类，填满方法区，使其出现内存溢出异常
 * 注：jdk1.8 已移除 PermSize 参数的设置
 */
public class JavaMethodAreaOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(obj, objects);
                }
            });
            enhancer.create();
        }
    }
}
