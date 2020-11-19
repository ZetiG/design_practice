package com.example.demo.blocking_queue;

import java.util.concurrent.TimeUnit;

/**
 * Description: 实现简单的阻塞队列
 *
 * @author Zeti
 * @date 2020/11/17 下午2:07
 */
public interface IBlockingQueue<E> extends IQueue<E> {


    /**
     * 阻塞添加，超时返回false
     *
     * @param e
     * @param timeout
     * @param unit
     * @return
     */
    boolean put(E e, long timeout, TimeUnit unit) throws InterruptedException;


}
