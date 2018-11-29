package com.example.demo.builder_Type5.signleton;

/**
 * 懒汉式（线程不安全，不可用）
 * 这种写法起到了懒加载的作用，但是只能在单线程下使用，如果在多线程下，
 * 一个线程进入了if语句，还未来得及往下执行，另一个线程也进入到了这个if判断语句，便会产生多个实例，所以多线程不可用。
 */
public class Singleton03 {
    private static Singleton03 singleton;

    private Singleton03() {}

    public static Singleton03 getInstance() {
        if (singleton == null) {
            singleton = new Singleton03();
        }
        return singleton;
    }
}
