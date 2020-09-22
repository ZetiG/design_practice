package com.example.demo.java_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Description: ThreadLocal gc
 *
 * @author Zeti
 * @date 2020/9/22 5:49 下午
 */
public class ThreadLocal_Demo {
    private static final Logger logger = LoggerFactory.getLogger(ThreadLocal_Demo.class);


    public static void main(String[] args) throws InterruptedException {
        Thread thread_1 = new Thread(() -> test("aaa", false));
        thread_1.start();
        thread_1.join();

        logger.info("------- GC -------");

        Thread thread_2 = new Thread(() -> test("bbb", true));
        thread_2.start();
        thread_2.join();

    }


    private static void test(String localValue, boolean isGC) {

        try {
            new ThreadLocal<>().set(localValue);

            // gc
            if (isGC) {
                System.gc();
            }

            Thread currentThread = Thread.currentThread();

            Class<? extends Thread> aClass = currentThread.getClass();
            Field threadLocals = aClass.getDeclaredField("threadLocals");
            threadLocals.setAccessible(true); // 启用、禁用Java语言安全检查
            Object threadLocalMap = threadLocals.get(currentThread);

            Class<?> localMap = threadLocalMap.getClass();
            Field localMapEntry = localMap.getDeclaredField("table");
            localMapEntry.setAccessible(true);
            Object[] arr = (Object[]) localMapEntry.get(threadLocalMap);

            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);

                    logger.info(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            logger.info("==>", e);
        }


    }

}
