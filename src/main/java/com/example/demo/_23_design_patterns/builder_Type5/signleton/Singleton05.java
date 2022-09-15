package com.example.demo._23_design_patterns.builder_Type5.signleton;

/**
 * 懒汉式（线程安全，同步代码块，不可用）
 * 同第四种一样效率低，摒弃了同步方法，改为同步产生实例化的代码块，
 * 但和第三中一样，多线程不可用。
 */
public class Singleton05 {
    private static Singleton05 singleton;

    private Singleton05() {}

    public static Singleton05 getInstance() {
        if (singleton == null) {
            synchronized (Singleton05.class) {
                singleton = new Singleton05();
            }
        }
        return singleton;
    }
}
