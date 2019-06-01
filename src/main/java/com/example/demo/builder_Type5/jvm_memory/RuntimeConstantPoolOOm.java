package com.example.demo.builder_Type5.jvm_memory;

/**
 * String.intern() 返回引用的测试
 */
public class RuntimeConstantPoolOOm {
    public static void main(String[] args) {

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1); //true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2); //false

        //true   false
        //解释：自jdk 1.7后，intern()的实现不会再复制实例，只是在常量池中记录首次出现的实例引用
        //因此intern()返回的引用和StringBuilder创建的字符串是同一个，所有第一个打印结果为true，
        //第二个为false，原因为"java"这个字符串在执行StringBuilder之前已经出现过，字符串常量池中已经有它的引用了

    }
}
