package com.example.demo.thread.thread_02;

/**
 * 生产者
 */
public class Producer extends Thread {
    Product p;

    public Producer() {
    }

    public Producer(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (p) { //将商品作为锁对象
                if (p.shouldProduct) {
                    if (count % 2 == 0) {
                        p.name = "pA";
                    } else {
                        p.name = "pB";
                    }
                    count++;
                    p.shouldProduct = false; //生产完毕
                    p.notify(); //唤醒消费者
                    System.err.println("生产者生产"+p.name);
                } else {
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
