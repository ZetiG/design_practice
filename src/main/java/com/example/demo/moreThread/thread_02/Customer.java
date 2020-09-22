package com.example.demo.moreThread.thread_02;

/**
 * 消费者
 */
public class Customer extends Thread {
    Product p;

    public Customer() {
    }

    public Customer(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (p) {
                if (!p.shouldProduct) {
                    System.err.println("消费者消费"+p.name);
                    p.shouldProduct = true;
                    p.notify();
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
