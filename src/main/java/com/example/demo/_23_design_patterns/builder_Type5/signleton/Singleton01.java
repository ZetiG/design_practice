package com.example.demo._23_design_patterns.builder_Type5.signleton;

/**
 * 单例-饿汉式
 * 基本实现思路：
 * 1.将该类的构造方法定义为私有方法。
 * 2.在该类内提供一个静态方法，当我们调用这个方法时，如果持有的引用不为空时就返回这个引用，为空就和创建该类的实例并将实例的引用赋予该类保持的引用。
 *
 * 饿汉式（静态常量，可用）
 * 优点：写法简单，类加载的时候就完成的实例化，避免了线程同步的问题。
 * 缺点：类加载的时候就完成的实例化，如果一直不用这个对象，将会造成内存浪费。
 */
public class Singleton01 {

    private static final  Singleton01 INSTANCE = new Singleton01();

    private Singleton01 () {}

    public static Singleton01 getInstance() {
        return INSTANCE;
    }
}
