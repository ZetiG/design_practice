package com.example.demo.builder_Type5.signleton;

/**
 * 双重检查（推荐用）
 * 代码中进行了两次if判断检验，保证了实例化代码只执行一次，优点：线程安全，延迟加载，效率高。
 */
public class Singleton06 {

    private static volatile Singleton06 singleton;

    private Singleton06() {}

    public static Singleton06 getInstance() {
        if (singleton == null) {
            synchronized (Singleton06.class) {
                if (singleton == null) {
                    singleton = new Singleton06();
                }
            }
        }
        return singleton;
    }
}
