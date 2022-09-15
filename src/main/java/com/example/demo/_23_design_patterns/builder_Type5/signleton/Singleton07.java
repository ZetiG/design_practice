package com.example.demo._23_design_patterns.builder_Type5.signleton;

/**
 * 静态内部类（推荐用）
 *
 * 这种方式跟饿汉方式采用的机制类似，都采用了类装载的机制来保证初始化实例只有一个线程，
 * 不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
 * 而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，
 * 才会装载SingletonInstance类，从而完成Singleton的实例化。 类的静态属性只会在第一次加载类的时候初始化，
 * 所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 * 优点：避免了线程不安全，延迟加载，效率高。
 */
public class Singleton07 {
    private Singleton07() {}

    private static class SingletonInstance {
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    public static Singleton07 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
