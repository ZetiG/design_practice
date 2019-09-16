package com.example.demo.classLoadMechanism;

/**
 * 使用该类的常量"HELLOWORD"时， 并未加载该类, 因为在编译阶段通过常量传播优化，已经将常量存储到了引用类的常量池中
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init");
    }

    public static final String HELLOWORD = "hello word2323";
}
