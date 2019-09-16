package com.example.demo.jvm_memory;

/**
 * JVM Args：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:-HandlePromotionFailure=false
 * <p>
 * 注：-XX:HandlePromotionFailure 避免 Full GC 过于频繁，在 JDK 6 Update 24之后该参数并不能影响空间分配担保策略
 * <p>
 * 测试：老年空间分配担保
 */
public class GuaranteeMemoryGC {

    private static final int _1M = 1024 * 1024;

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;

        allocation1 = new byte[2 * _1M];
        allocation2 = new byte[2 * _1M];
        allocation3 = new byte[2 * _1M];
        allocation1 = null;
        allocation4 = new byte[2 * _1M];
        allocation5 = new byte[2 * _1M];
        allocation6 = new byte[2 * _1M];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1M];

    }

}
