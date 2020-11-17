package com.example.demo.blocking_queue;

/**
 * Description: 实现一个简单的队列
 *
 * @author Zeti
 * @date 2020/11/17 下午2:08
 */
public interface IQueue<E> {


    /**
     * 添加元素，队列满时抛出异常
     */
    boolean add(E e) throws InterruptedException;

    /**
     * 添加元素，队列满时返回false
     *
     * @return
     */
    boolean offer(E e) throws InterruptedException;

    /**
     * 弹出首个元素
     */
    E take() throws InterruptedException;

    /**
     * 删除元素
     *
     * @return
     */
    boolean remove(E e) throws InterruptedException;

    /**
     * 删除所有元素
     */
    boolean removeAll() throws InterruptedException;

    /**
     * 队列容量
     *
     * @return
     */
    int size();

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();

}
