package com.example.demo.builder_Type5.jvm_memory;

/**
 * JVM Args：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=15
 * -XX:+PrintTenuringDistribution
 * <p>
 * 注：对象进入老年代并不完全依赖年龄的限制，当Survivor中相同年龄的所有对象的大小总和超过Survivor空间的一半时，
 * 那么大于等于该年龄的对象就可以直接进入老年代，并不一定需要年龄满足MaxTenuringThreshold的限制
 * <p>
 * 测试根据Survivor中对象的年龄动态分配进入老年代
 */
public class AverageAgeMemoryGC {

    private static final int _1M = 1024 * 1024;

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1M / 4];

        //allocation1 + allocation2 的年龄大于Survivor空间的一半
        allocation2 = new byte[_1M /4];
        allocation3 = new byte[4 * _1M];
        allocation4 = new byte[4 * _1M];
        allocation4 = null;
        allocation4 = new byte[4 * _1M];

    }

}
