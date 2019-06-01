package com.example.demo.builder_Type5.signleton;

/**
 * 饿汉式（静态代码块，可用）
 */
public class Singleton02 {
    private static Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02() {}

    public static Singleton02 getInstance() {
        return INSTANCE;
    }
}
