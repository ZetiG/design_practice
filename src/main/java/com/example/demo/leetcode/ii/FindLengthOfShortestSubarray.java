package com.example.demo.leetcode.ii;

/**
 * Description: 1574. 删除最短的子数组使剩余数组有序
 *  给你一个整数数组 arr，请你删除一个子数组（可以为空），使得 arr中剩下的元素是 非递减 的。
 *  一个子数组指的是原数组中连续的一个子序列。
 *  请你返回满足题目要求的最短子数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted
 *
 * @author Zeti
 * @date 2023/3/28 19:25
 */
public class FindLengthOfShortestSubarray {

    public static void main(String[] args) {
//        int[] a1 = {1,2,3,10,4,2,2,3,5};  // 输出：3
//        System.err.println(findLengthOfShortestSubarray(a1));
//
//        int[] a2 = {5,4,3,2,1}; // 输出：4
//        System.err.println(findLengthOfShortestSubarray(a2));
//
//        int[] a3 = {1,2,3}; // 输出：0
//        System.err.println(findLengthOfShortestSubarray(a3));
//
//        int[] a4 = {1,2,2,3,3,78,5,2,3,2,4,7}; // 输出：5
//        System.err.println(findLengthOfShortestSubarray(a4));

//        int[] a5 = {1}; // 输出：0
//        System.err.println(findLengthOfShortestSubarray(a5));

        int[] a6 = {10,13,17,21,15,15,9,17,22,22,13}; // 输出：7
        System.err.println(findLengthOfShortestSubarray(a6));


    }

    public static int findLengthOfShortestSubarray2(int[] arr) {
        int n = arr.length, j = n - 1;
        while (j > 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        if (j == 0) {
            return 0;
        }
        int res = j;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] < arr[i]) {
                j++;
            }
            res = Math.min(res, j - i - 1);
            if (i + 1 < n && arr[i] > arr[i + 1]) {
                break;
            }
        }
        return res;
    }

    // 1, 2, 3, 10, 4, 2, 3, 5
    public static int findLengthOfShortestSubarray(int[] arr) {
        if (arr.length == 1)
            return 0;

        int preIdx = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                preIdx = i;
                break;
            }
            if (i == arr.length-2) {
                return 0;
            }
        }

        int minSubLen = arr.length - (preIdx+1);
        for (int i = arr.length-1; i >= 0; i--) {
            while (preIdx >= 0 && preIdx <= i && arr[preIdx] > arr[i]) {
                preIdx--;
            }

            minSubLen = Math.min(minSubLen, i - (preIdx + 1));
            if (i > 0 && arr[i - 1] > arr[i]) {
                break;
            }
        }
        return minSubLen;
    }

}
