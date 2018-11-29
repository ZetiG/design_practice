package com.example.demo.builder_Type5.signleton;

/**
 * 枚举（推荐用）
 * 借助JDK1.5中添加的枚举来实现，避免了多线程问题，而且还能防止反序列化重新创建新的对象。
 */
public enum Singleton08 {

    INSTANCE;

    void whateverMethod() {}
}
