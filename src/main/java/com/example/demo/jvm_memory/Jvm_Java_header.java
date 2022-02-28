package com.example.demo.jvm_memory;



/**
 * Description: jvm 中Java对象结构
 *
 * @author Zeti
 * @date 2022/2/21 11:54 AM
 */
public class Jvm_Java_header {


    public static void main(String[] args) {
//        String str = new String();
//
////        System.err.println(VM.current().details());
//
////        System.err.println("123".compareTo("1111"));
////        System.err.println("123".compareTo("123"));
//        System.err.println("abc".compareTo("abcd"));

        Integer a=1025,b=1025;

        Integer c=100,d=100;

        // -XX:AutoBoxCacheMax=1024
        System.err.println(a==b);
        System.err.println(c==d);

    }

}
