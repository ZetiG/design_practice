package com.example.demo.blocking_queue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 基于数组和Lock实现的阻塞队列
 *
 * @author Zeti
 * @date 2020/11/17 下午2:58
 */
public class ArrayBlockingQueueWithLock<E> implements IBlockingQueue<E> {


    /**
     * Main lock guarding all access
     */
    final ReentrantLock lock;
    /**
     * Condition for waiting takes
     */
    @SuppressWarnings("serial")
    private final Condition notEmpty;
    /**
     * Condition for waiting puts
     */
    @SuppressWarnings("serial")
    private final Condition notFull;
    /**
     * 数组
     */
    private E[] arr;
    /**
     * 队列头指针
     */
    private int head;
    /**
     * 队列尾指针
     */
    private int tail;
    /**
     * 队列容量
     */
    private volatile int size;

    public ArrayBlockingQueueWithLock(int capacity, boolean fair) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.arr = (E[]) new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }


    @Override
    public boolean add(E e) throws InterruptedException {
        if (size == arr.length) {
            throw new IllegalStateException("Queue full");
        }

        return addQueue(e);
    }

    @Override
    public boolean offer(E e) throws InterruptedException {
        if (size == arr.length) {
            return false;
        }
        return addQueue(e);
    }


    private boolean addQueue(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            // 队列满，阻塞
            while (size == arr.length) {
                notFull.await();
            }
            arr[tail] = e;
            if (++tail == arr.length) {
                tail = 0;
            }
            ++size;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
        return true;
    }

    @Override
    public E take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()) {
                notEmpty.wait();
            }

            E element = arr[head];
            if (++head == arr.length) {
                head = 0;
            }
            --size;
            // 通知isFull条件队列有元素出去
            notFull.signal();
            return element;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            List<E> es = Arrays.asList(arr);
            return es.remove(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean removeAll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            List<E> es = Arrays.asList(arr);
            es.clear();
        } finally {
            lock.unlock();
        }
        return true;
    }

    @Override
    public int size() {
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try {
            return size == 0;
        } finally {
            lock.unlock();
        }
    }
}
