package com.example.demo.lock;

import java.util.concurrent.TimeUnit;

/**
 * Description: 模拟死锁
 *
 * <p>
 *     线程1和线程2互相等待对方释放拥有的锁，进而导致死锁
 *     解决: 等待超时获取不到锁，自动释放自己拥有的锁
 * </p>
 *
 * @author Zeti
 * @date 2020/9/18 10:16 上午
 */
public class LockDiedTest {

    private static final Object source_1 = new Object();
    private static final Object source_2 = new Object();


    public static void main(String[] args) {

        new Thread(() -> {

            synchronized (source_1) {
                System.err.println(Thread.currentThread() + ": get the source_1");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.err.println(Thread.currentThread() + ": complete source_1");

                synchronized (source_2) {
                    System.err.println(Thread.currentThread() + ": get the source_2");
                }
            }

        }, "线程1").start();



        new Thread(() -> {

            synchronized (source_2) {
                System.err.println(Thread.currentThread() + ": get the source_2");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.err.println(Thread.currentThread() + ": complete source_2");

                synchronized (source_1) {
                    System.err.println(Thread.currentThread() + ": get the source_1");
                }
            }

        }, "线程2").start();

    }


}
