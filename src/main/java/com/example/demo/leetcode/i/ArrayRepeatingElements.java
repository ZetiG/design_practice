package com.example.demo.leetcode.i;

import java.util.HashSet;

/**
 * Description: 判断给定的数组是否存在重复元素
 * ps1: 输入: [1,2,3,1]   输出: true
 * ps2: 输入: [1,2,3,4]   输出: false
 *
 * @author Zeti
 * @date 2022/1/14 2:52 PM
 */
public class ArrayRepeatingElements {

    public static void main(String[] args) {
        int[] a1 = {1,2,3,1};
        int[] a2 = {1,2,3,4};

        // d1
        System.err.println(repeat(a1));
        System.err.println(repeat(a2));

    }

    // set 集合
    public static boolean repeat(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) {
                return true;
            }
        }
        return false;
    }


}
