package com.example.demo.builder_Type5.jvm_memory;

/**
 * JVM Args:
 * -XX:+PrintGC 输出GC日志
 * -XX:+PrintGCDetails 输出GC的详细日志
 * -XX:+PrintGCTimeStamps 输出GC的时间戳（以基准时间的形式）
 * -XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2013-05-04T21:53:59.234+0800）
 * -XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
 * -Xloggc:../logs/gc.log 日志文件的输出路径
 * <p>
 * 测试JVM是否引用计数算法去回收不在引用的对象，
 * 如果objA和objB被GC, 则代表JVM并不是采用技术算法回收垃圾
 * <p>
 * Java、c#等语言，都是通过可达性算法来判断一个对象是否存活，
 * 这个算法的基本思路就是通过一系列的称为"GC Roots"的对象作为起始点，
 * 从这些节点开始向下搜索，走过的路径称为"引用链"，当一个对象到"GC Roots"没有任何引用链时，
 * （就是GC Roots 到这个对象不可达）证明此对象不可用，那么就判为可回收(并非一定回收)
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的目的就是多占用点内存，以便在GC日志中能看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设这里发生GC, objA和objB是否能被回收？
        System.gc();
    }

    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }
}
