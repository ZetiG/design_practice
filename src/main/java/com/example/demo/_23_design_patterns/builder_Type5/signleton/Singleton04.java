package com.example.demo._23_design_patterns.builder_Type5.signleton;

/**
 * 懒汉式（线程安全，同步方法，不推荐用）
 * 解决了上面线程不安全的问题，
 * 缺点：效率太低，每个线程想要获得实例的时候，执行getInstance都要同步。
 */
public class Singleton04 {
    private static Singleton04 singleton;

    private Singleton04() {}

    public static synchronized Singleton04 getInstance() {
        if (singleton == null) {
            singleton = new Singleton04();
        }
        return singleton;
    }
}
