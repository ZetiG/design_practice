package com.example.demo.builder_Type5.jvm_memory;

/**
 * JVM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728
 * <p>
 * 注：PretenureSizeThreshold这个参数代表大对象限制，超过该限制的都会被直接分配到老年代中，
 *    3145728=3M，但是该参数并不能直接写为3M
 *    但是，Parallel Scavenge收集器并不需要设置， ParNew和CMS收集器皆可设置
 * <p>
 * 测试为大对象分配内存时，直接进入老年代
 */
public class BigObjectMemoryGC {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allocation;

        allocation = new byte[4 * _1M]; //大对象直接分配到老年代中

    }

}
