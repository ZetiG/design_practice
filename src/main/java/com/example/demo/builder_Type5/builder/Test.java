package com.example.demo.builder_Type5.builder;


/**
 * 建造者模式
 */
public class Test {
    public static void main(String[] args) {
        new Builder().produceMail(10);
        new Builder().produceSms(10);
    }
}
