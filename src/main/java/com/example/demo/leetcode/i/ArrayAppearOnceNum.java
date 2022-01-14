package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * ps1: 输入: [2, 2, 1, 3, 3]     输出: 1
 * ps2: 输入: [4, 1, 2, 1, 2]     输出: 4
 *
 * @author Zeti
 * @date 2022/1/14 3:19 PM
 */
public class ArrayAppearOnceNum {

    public static void main(String[] args) {
        int[] a1 = {2, 2, 1, 3, 3};
        int[] a2 = {4, 1, 2, 1, 2};

        // d1
        System.err.println(tt1(a2));

        // d2
        System.err.println(tt2(a2));
    }

    // d2 异或运算
    public static int tt2(int[] arr) {
        int reduce = 0;
        for (int num : arr) {
            reduce =  reduce ^ num;
        }
        return reduce;
    }


    // d1  总和 -（重复数之和 * 2）
    public static int tt1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int sum1 = Arrays.stream(arr).sum();
        int sum2 = Arrays.stream(arr).distinct().sum();

        return  sum1 - (sum1 - sum2) * 2;
    }

}
