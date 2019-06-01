package com.example.demo.builder_Type5.jvm_memory;

/**
 * JVM Args：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=1
 * -XX:+PrintTenuringDistribution
 * <p>
 * 注：MaxTenuringThreshold参数限制对象在新生代中存活的年龄，大于设置的年龄就会进入老年代，
 * 默认值为15(例如：设置为1时，如果当对象在MinorGC后能存活(年龄+1)，那么在下次MinorGC时将进入老年代)
 * <p>
 * 测试长期存活的对象进入老年代
 */
public class LongAliveMemoryGC {

    private static final int _1M = 1024 * 1024;

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1M / 4];

        //什么时候进入老年代取决于 XX:MaxTenuringThreshold参数
        allocation2 = new byte[4 * _1M];
        allocation3 = new byte[4 * _1M];
        allocation3 = null;
        allocation3 = new byte[4 * _1M];

    }

}
