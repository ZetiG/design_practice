package com.example.demo.jvm_memory;

/**
 * JVM Args：-Xss160k
 * <p>
 * 虚拟机栈和本地方法栈OOM异常测试
 * 单线程下，无论由于栈帧太大还是虚拟机栈容量太小，当内存无法分配的时候，
 * 虚拟机抛出的都是StackOverflowError
 */
public class JvmStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JvmStackSOF oom = new JvmStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.print("stack length:" + oom.stackLength);
            throw e;
        }

    }
}
