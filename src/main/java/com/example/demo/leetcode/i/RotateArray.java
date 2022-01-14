package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: 轮转数组, 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * ps1: 输入: nums = [1,2,3,4,5,6,7], k = 3   输出: [5,6,7,1,2,3,4]
 * ps2: 输入：nums = [-1,-100,3,99], k = 2     输出：[3,99,-1,-100]
 *
 *
 * @author Zeti
 * @date 2022/1/14 11:47 AM
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {-1, -100, 3, 99};

        // d1
//        System.err.println(Arrays.toString(rotate1(arr1, 3)));
//        System.err.println(Arrays.toString(rotate2(arr1, 3)));
        System.err.println(Arrays.toString(rotate3(arr1, 3)));

    }

    /**
     * 数组按k切割为两个数组，再进行copy合并
     * @param arr
     * @return
     */
    public static int[] rotate1(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        if (k <= 0 || k > arr.length) {
            return arr;
        }

        // new
        int[] a1 = Arrays.copyOfRange(arr, arr.length - k, arr.length);
        int[] a2 = Arrays.copyOfRange(arr, 0, arr.length - k);

        int[] result = Arrays.copyOf(a1, a1.length + a2.length);
        System.arraycopy(a2, 0, result, k, arr.length - k);

        return result;
    }

    public static int[] rotate2(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        if (k <= 0 || k > arr.length) {
            return arr;
        }

        int idx = k - 1;
        int tmp;
        for (int i = arr.length - 1; i > k; i--) {
            tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
            idx--;
        }

        return arr;
    }

    public static int[] rotate3(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        if(k==0||len==1) {
            return nums;
        }
        int temp;
        temp=nums[0];
        int count = 0;
        for(int i=k, cnt=0; cnt < len; i += k, cnt++) {
            int t=nums[i % len];
            nums[i % len]=temp;
            temp=t;
            if(i % len == count) {
                count++;
                i = count;
                temp = nums[(i) % len];
            }
        }
        return nums;
    }


}
