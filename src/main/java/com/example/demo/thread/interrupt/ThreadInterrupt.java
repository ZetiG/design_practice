package com.example.demo.thread.interrupt;

/**
 * Description: 线程中断
 *
 * @author Zeti
 * @date 2021/4/22 下午2:00
 */
public class ThreadInterrupt implements Runnable {

    public static void main(String[] args) {
        ThreadInterrupt interruptedTask = new ThreadInterrupt();
        Thread interruptedThread = new Thread(interruptedTask);
        interruptedThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptedThread.interrupt();
    }

    /**
     * 处理InterruptedException异常时要小心，
     * 如果在调用执行线程的interrupt()方法中断执行线程时，抛出了InterruptedException异常，则在触发InterruptedException异常的同时，
     * JVM会同时把执行线程的中断标志位清除，此时调用执行线程的isInterrupted()方法时，会返回false。
     * 此时，正确的处理方式是在执行线程的run()方法中捕获到InterruptedException异常，
     * 并重新设置中断标志位（也就是在捕获InterruptedException异常的catch代码块中，重新调用当前线程的interrupt()方法）。
     */
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (true) {
            if (currentThread.isInterrupted()) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                currentThread.interrupt();
            }
        }
        System.err.println("thread are interrupted...");
    }

}
