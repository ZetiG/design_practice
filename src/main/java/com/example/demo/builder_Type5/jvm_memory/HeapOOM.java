package com.example.demo.builder_Type5.jvm_memory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * 限制Java堆内存大小为20M，最大内存和最小内存设置一样可避免堆自动扩展
 * 参数 -XX:+HeapDumpOnOutOfMemoryError 让虚拟机在出现内存溢出异常时 Dump当前内存堆转储快照，便于分析
 * <p>
 * Java堆内存溢出异常测试
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
