package com.example.demo.moreThread;


/**
 * 经典多线程问题
 * 子线程循环10次，主线程循环100次，来回循环50次
 */
public class ThreadTest {

    //内部类
    class Business {
        //主线程
        public synchronized void mainThread() {
            for (int i = 0; i < 100; i++) {
                System.err.println(Thread.currentThread().getName()+"执行"+i);
            }
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //子线程
        public synchronized void subThread() {
            for (int i = 0; i < 10; i++) {
                System.err.println(Thread.currentThread().getName()+"执行"+i);
            }
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void init() throws InterruptedException {
        //创建内部类对象
        final Business business = new Business();
        //创建线程，重写run方法
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                business.subThread();
            }
        }).start();

        Thread.sleep(1000);//让主线程让出cpu，执行子线程

        for (int i = 0; i < 50l; i++) {
            business.mainThread();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建对象
        ThreadTest t1 = new ThreadTest();
        t1.init();
    }
}
