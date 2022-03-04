package com.example.demo.leetcode.ii;

/**
 * Description: 累加，求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * ps 1：
 *  输入: n = 3
 *  输出: 6
 *
 * ps 2：
 *  输入: n = 9
 *  输出: 45
 *
 *  解答： 思路，用递归代替for循环，用 && 短路代替if
 *
 * @author Zeti
 * @date 2022/3/4 3:30 PM
 */
public class NumberAdd {

    public static void main(String[] args) {
        int i1 = 3;
        int i2 = 5;
        int i3 = 9;
        System.err.println(add(i1));
        System.err.println(add(i2));
        System.err.println(add(i3));

    }


    public static int add(int i) {

        int sum = i;
        boolean flag = i > 0 && (sum += add(i - 1)) > 0;
        return sum;

    }



}
