package com.example.demo.lock;

/**
 * Description: synchronized
 *
 * @author Zeti
 * @date 2022/2/21 9:58 AM
 */
public class SynchronizedDemo {

    /**
     * 锁单个实例对象：
     *  synchronized(this) {}
     *  synchronized(new Object()) {}
     *  synchronized 非静态方法前
     *
     * 锁住类：
     * synchronized(Object.class) {}
     * synchronized 静态方法前
     *
     */
    static class MoreThread implements Runnable {

        private static Integer count = 0;

        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) {
                Thread thread = new Thread(new MoreThread());
                thread.start();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("result: " + count);

        }

        @Override
        public void run() {

            synchronized (MoreThread.class) {   // 锁对象，保证多线程操作变量总是最新值

            for (int i = 0; i < 1000000; i++)
                count++;

            }
        }

    }

}
