package com.example.demo.moreThread.Thread_02;

public class ThreadTest {
    public static void main(String[] args) {
        Product p = new Product();
        p.name = "商品";
        p.shouldProduct = false;

        new Producer(p).run();
        new Customer(p).run();
    }
}
