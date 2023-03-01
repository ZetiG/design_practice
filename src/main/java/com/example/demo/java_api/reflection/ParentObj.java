package com.example.demo.java_api.reflection;

/**
 * Description: 父类
 *
 * @author Zeti
 * @date 2023/3/1 19:25
 */
public class ParentObj {
    private int a;

    private ParentObj() {
        System.err.println("父类私有构造方法");
    }

    public ParentObj(int a) {
        this.a = a;
        System.err.println("父类公共构造方法");
    }

    private void priT1() {
        System.err.println("父类私有普通方法");
    }

    public void pubT1() {
        System.err.println("父类公共普通方法");
    }


}
