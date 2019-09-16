package com.example.demo.jvm_memory;

/**
 * JVM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * <p>
 * JVM参数设置：将Java堆内存限制20M，不可扩展(最大和最小内存相同)，将这20M内存，10M分给新生代，10M分给老年代
 * <p>
 * 测试 新生代区 Minor GC
 * <p>
 * 期间一共发生两次GC, 第一次是给allocation4分配内存时，剩余容量不足，于是对存在新生代中的数据(allocation1、allocation2、allocation3)进行GC
 * 但是由于对象还在存活中，同时GC期间虚拟机发现已有的这三个对象并无法全部放入Survivor中(新生代内存分为Eden、Survivor1、Survivor2，GC复制算法，
 * 将Eden和Survivor1中的数据转移到Survivor2中)，
 * 所以只好通过分配担保机制提前转移到老年代去
 */
public class EdenMemoryGCTest {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1M];
        allocation2 = new byte[2 * _1M];
        allocation3 = new byte[2 * _1M];
        allocation4 = new byte[4 * _1M];  //此处会发生一次GC

    }
}
