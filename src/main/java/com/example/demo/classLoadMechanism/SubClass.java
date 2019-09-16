package com.example.demo.classLoadMechanism;

public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init");
    }
}
