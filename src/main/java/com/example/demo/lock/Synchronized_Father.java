package com.example.demo.lock;

/**
 * Description:  验证 Synchronized 是否为可重入锁
 *
 * @author Zeti
 * @date 2020/9/27 6:03 下午
 */
public class Synchronized_Father {

    public synchronized void doSomething() throws InterruptedException {
        System.out.println("father.doSomething()" + Thread.currentThread().getName());
    }
}
