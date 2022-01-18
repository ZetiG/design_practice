package com.example.demo.leetcode.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Description:  给定一个数组和一个目标值，求得整数数组中两个数之和等于目标值的数组下标
 * ps1: 输入[3, 1, 0, 4, 6]，5   输出[1, 3]
 *
 * @author Zeti
 * @date 2022/1/14 6:02 PM
 */
public class ArrayDoubleNumSum {

    public static void main(String[] args) {
        int[] a = {3, 1, 0, 4, 6};
        int t = 5;

        int[] a2 = {-1, -2, -3, -4, -5};
        int t2 = -8;

        // d1
        System.err.println(Arrays.toString(sumIdx(a2, t2)));
        System.err.println(Arrays.toString(sumIdx2(a2, t2)));

    }

    // d2 map
    public static int[] sumIdx2(int[] arr, int t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(t - arr[i]) != null) {
                return new int[]{map.get(t - arr[i]), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }


    // d1 目标数循环减去数组内数据，得出下标
    public static int[] sumIdx(int[] arr, int t) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int rd = t - arr[i];
            for (int j = 1; j < arr.length; j++) {
                if (rd == arr[j] && i != j) {
                    if (list.contains(i)) {
                        continue;
                    }

                    list.add(i);

                    if (list.contains(j)) {
                        continue;
                    }
                    list.add(j);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

}
