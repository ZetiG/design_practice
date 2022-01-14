package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: 移动数组中的0， 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * ps1: 输入: [0,1,0,3,12]    输出: [1,3,12,0,0]
 *
 * @author Zeti
 * @date 2022/1/14 5:10 PM
 */
public class ArrayMoveZero {

    public static void main(String[] args) {
        int[] a1 = {0, 12, 0, 1, 3};
        int[] a2 = {9, 0, 1, 0, 3, 12, 0, 4, 0};

        // d1
        System.err.println(Arrays.toString(moveZero(a1)));
        System.err.println(Arrays.toString(moveZero(a2)));

    }

    public static int[] moveZero(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int idx = 0;
        int count0 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
                continue;
            }
            arr[idx] = arr[i];
            idx++;
        }

        for (int i = arr.length - count0; i < arr.length; i++) {
            arr[i] = 0;
        }

        return arr;
    }


}
