package com.example.demo.jvm_memory;

import lombok.Data;

/**
 * Description: 逃逸分析 、 标量替换
 * <p>
 * 栈上分配，标量替换
 * *
 * * JVM 参数 -XX:+DoEscapeAnalysis & -XX:+EliminateAllocations
 * * JDK7之后默认开启逃逸分析 .
 * *
 * * 如果需要关闭逃逸分析 -XX:-DoEscapeAnalysis 即可，不推荐修改该参数。
 * *
 * * -XX:+EliminateAllocations 开启标量替换参数 . 该参数的前提是开启了逃逸分析，如果没有开启逃逸分析，仅开启该参数无效
 * *
 * <p>
 * 示例代码调用了1亿次alloc()，如果是分配到堆上，大概需要1GB以上堆空间，如果堆空间小于该值，必然会触发GC。
 * <p>
 * 使用如下参数不会发生GC
 * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * <p>
 * 使用如下参数都会发生大量GC
 * -Xmx15m -Xms15m -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 *
 * @author Zeti
 * @date 2022/2/23 2:29 PM
 */
public class ObjectOnThreadStack {

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        allocate();
        System.out.println("cost:" + (System.currentTimeMillis() - begin));

    }


    private static void allocate() throws InterruptedException {
        for (int i = 0; i < 100000000; i++) {
            Artisan artisan = new Artisan();
            artisan.setId(1);
            artisan.setDesc("artisan");
        }
    }


    @Data
    static class Artisan {
        private int id;
        private String desc;
        // set get
    }

}
