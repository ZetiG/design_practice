package com.example.demo.classLoadMechanism;

/**
 * 测试类
 *
 * JVM Args: -XX:+TraceClassLoading 打印子类的加载
 */
public class NotInitialization {

    public static void main(String[] args) {
//        System.out.println(SubClass.valuse);

//        SuperClass[] sc = new SuperClass[10];

        System.out.println(ConstClass.HELLOWORD);


    }
}
