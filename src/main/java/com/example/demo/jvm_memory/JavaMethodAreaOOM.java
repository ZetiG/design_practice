package com.example.demo.jvm_memory;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * JVM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * <p>
 * 借助CGLib不断产生类，填满方法区，使其出现内存溢出异常
 * 注：jdk1.8 已移除 PermSize 参数的设置
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, objects, methodProxy) -> methodProxy.invokeSuper(obj, objects));
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
