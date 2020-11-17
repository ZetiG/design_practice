package com.example.demo.blocking_queue;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 基于数组和synchronized实现的阻塞队列
 *
 * @author Zeti
 * @date 2020/11/17 下午2:19
 */
public class ArrayBlockingQueueWithSync<E> implements IBlockingQueue<E> {

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

    public ArrayBlockingQueueWithSync(int capacity) {
        arr = (E[]) new Object[capacity];
    }

    @Override
    public synchronized boolean add(E e) throws InterruptedException {
        if (size == arr.length) {
            throw new IllegalStateException("Queue full");
        }
        addQueue(e);
        return true;
    }

    @Override
    public synchronized boolean offer(E e) throws InterruptedException {
        if (size == arr.length) {
            return false;
        }
        addQueue(e);
        return true;
    }

    private synchronized boolean addQueue(E e) throws InterruptedException {
        // 队列满时，阻塞等待
        while (arr.length == size) {
            this.wait();
        }

        arr[tail] = e;
        if (++tail == arr.length) {
            tail = 0;
        }

        ++size;

        this.notifyAll();

        return true;
    }

    @Override
    public synchronized E take() throws InterruptedException {
        // 当队列空的时候阻塞
        while (isEmpty()) {
            this.wait();
        }

        E element = arr[head];
        // 消费完后从0开始
        if (++head == arr.length) {
            head = 0;
        }
        --size;
        // 通知其他生产者可以生产了
        this.notifyAll();
        return element;
    }

    @Override
    public synchronized boolean remove(E e) {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        List<E> es = Arrays.asList(arr);
        boolean contains = es.contains(e);
        if (contains) {
            return es.remove(e);
        }

        return false;
    }

    @Override
    public synchronized boolean removeAll() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Arrays.asList(arr).clear();
        return true;
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized boolean isEmpty() {
        return size == 0;
    }


}
