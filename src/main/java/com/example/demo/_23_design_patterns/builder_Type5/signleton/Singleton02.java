package com.example.demo._23_design_patterns.builder_Type5.signleton;

import java.io.Serializable;

/**
 * 饿汉式（静态代码块，可用）
 */
public class Singleton02 implements Serializable {
    private static final Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02() {}

    public static Singleton02 getInstance() {
        return INSTANCE;
    }
}
