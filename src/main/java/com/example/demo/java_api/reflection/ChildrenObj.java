package com.example.demo.java_api.reflection;

/**
 * Description: 子类
 *
 * @author Zeti
 * @date 2023/3/1 19:25
 */
public class ChildrenObj extends ParentObj {
    private int b;

    public ChildrenObj(int a) {
        super(a);
        System.err.println("子类公共构造方法");
    }

    private ChildrenObj(int a, int b) {
        super(a);
        this.b = b;
    }

    private void priT2() {
        System.err.println("子类私有普通方法");
    }

    public void pubT2() {
        System.err.println("子类公共普通方法");
    }



}
