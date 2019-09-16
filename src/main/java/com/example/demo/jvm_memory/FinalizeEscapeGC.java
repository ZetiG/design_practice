package com.example.demo.jvm_memory;

/**
 * 此代码演示两点：
 * 1、对象可以在GC时自救
 * 2、这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.print("yes, i am still alive:)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以等待它0.5秒
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead:(");
        }

        //同上代码，再次自救，失败！因为一个对象的finalize()方法最多只会被系统自动调用一次
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以等待它0.5秒
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead:(");
        }

    }
}
