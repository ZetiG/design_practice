package com.example.demo.thread.thread_02;

/**
 * 多线程-生产者消费者问题
 */
public class ThreadTest {
    public static void main(String[] args) {
        Product p = new Product();
        p.name = "商品";
        p.shouldProduct = false;

        new Producer(p).run();
        new Customer(p).run();
    }
}
