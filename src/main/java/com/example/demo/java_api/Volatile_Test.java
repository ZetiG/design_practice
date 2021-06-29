package com.example.demo.java_api;

import java.util.concurrent.TimeUnit;

/**
 * Description:  volatile 关键字详解
 *
 * <p>
 * volatile关键字用于多线程修改同一变量值的场景，它使线程能安全的访问、操作共享变量。
 * 这意味着多个线程能同时使用一个方法和实例，而不会出任何问题。这个关键字既能修饰Java的基本类型，也能修饰引用类型。
 *
 * * 可见性：对一个volatile变量的读，总是能看到（任意线程）对这个volatile变量最后的写入。
 * * 原子性：对任意单个volatile变量的读/写具有原子性。但是对于i++这种复合操作不具有原子性。
 * * 顺序性：volatile关键字能禁止指令重排序，所以volatile能在一定程度上保证有序性。
 *
 * </p>
 *
 * @author Zeti
 * @date 2021/6/29 上午9:46
 */
public class Volatile_Test {

    /**
     * thread safely
     */
    public static volatile boolean run = true;

    /**
     * thread not safely
     */
//    public static  boolean run = true;
    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            int i = 0;
            while (run) {
                i++;
                Thread.yield();
                System.out.println(i + " loading...");
            }
        }).start();


        System.out.println("Main Thread ready to sleep...");

        TimeUnit.SECONDS.sleep(10);

        System.out.println("Main Thread finish sleep...");
        run = false;

    }


}
