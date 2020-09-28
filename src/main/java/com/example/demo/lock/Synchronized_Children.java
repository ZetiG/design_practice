package com.example.demo.lock;

import java.util.concurrent.TimeUnit;

/**
 * Description:  验证 Synchronized 是否为可重入锁
 *
 * @author Zeti
 * @date 2020/9/27 6:01 下午
 */
public class Synchronized_Children extends Synchronized_Father {

    public static void main(String[] args) throws InterruptedException {
        Synchronized_Children synchronizedDemo = new Synchronized_Children();
        synchronizedDemo.doSomething();


    }

    @Override
    public synchronized void doSomething() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("child.doSomething()" + Thread.currentThread().getName() + "----> " + i);
        }
        doAnotherThing(); // 调用自己类中其他的synchronized方法

    }

    private synchronized void doAnotherThing() throws InterruptedException {
        super.doSomething(); // 调用父类的synchronized方法
        System.out.println("child.doAnotherThing()" + Thread.currentThread().getName());
    }
}
