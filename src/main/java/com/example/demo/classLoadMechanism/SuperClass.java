package com.example.demo.classLoadMechanism;

/**
 * 类加载机制，被动引用
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init");
    }

    public static int valuse = 123;

}
