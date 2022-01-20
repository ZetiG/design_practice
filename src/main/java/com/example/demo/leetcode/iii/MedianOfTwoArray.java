package com.example.demo.leetcode.iii;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description: 两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * </p>
 * <p>
 * ps1: 输入：nums1 = [1,3], nums2 = [2]   输出：2.00000  解释：合并数组 = [1,2,3] ，中位数 2
 * ps2: 输入：nums1 = [1,2], nums2 = [3,4]     输出：2.50000  解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * ps3: 输入：nums1 = [0,0], nums2 = [0,0]     输出：0.00000
 * ps4: 输入：nums1 = [], nums2 = [1]  输出：1.00000
 * ps5: 输入：nums1 = [2], nums2 = []  输出：2.00000
 *
 * @author Zeti
 * @date 2022/1/20 9:39 AM
 */
public class MedianOfTwoArray {

    public static void main(String[] args) {
        int[] n1 = {1,3};
        int[] n2 = {2};
        System.err.println(median2(n1, n2)); // 2

        int[] n3 = {1,2};
        int[] n4 = {3,4};
        System.err.println(median2(n3, n4)); // 2.5

        int[] n5 = {0,0};
        int[] n6 = {0,0};
        System.err.println(median2(n5, n6)); // 0

        int[] n7 = {};
        int[] n8 = {1};
        System.err.println(median2(n7, n8)); // 1

        int[] n9 = {2};
        int[] n10 = {};
        System.err.println(median2(n9, n10)); // 2

        int[] a = {1, 3, 5,  6, 11, 19};
        int[] b = {7, 8, 9, 10, 11};
        System.err.println(median2(a, b));  // 8.0

        int[] c = {1, 3, 5,  6};
        int[] d = {7, 8, 9, 10, 11, 11, 19};
        System.err.println(median2(c, d));  // 8.0

    }


    // d2  二分法查找
    public static double median2(int[] n1, int[] n2) {
        int totalLen = n1.length + n2.length;

        // 中位数所在位置
        int leftK = (totalLen + 1) / 2;
        int rightK = (totalLen + 2) / 2;

        return ((findMid(n1, n2, 0, 0, leftK) + findMid(n1, n2, 0, 0, rightK)) / 2.0);
    }

    public static int findMid(int[] n1, int[] n2, int i, int j, int k) {
        if (i >= n1.length) {
            return n2[j + k - 1];
        }

        if (j >= n2.length) {
            return n1[i + k - 1];
        }

        if (k == 1) {
            return Math.min(n1[i], n2[j]);
        }

        // {1, 3, 5};
        // {7, 8, 9, 10, 11, 11, 19};
        int i1 = (i + k / 2 - 1) < n1.length ? n1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int j1 = (j + k / 2 - 1) < n2.length ? n2[j + k / 2 - 1] : Integer.MAX_VALUE;

        if (i1 < j1) {
            return findMid(n1, n2, i + k / 2, j, k - k / 2);

        } else {
            return findMid(n1, n2, i, j + k / 2, k - k / 2);
        }
    }

    // d1  合并数组， 重排序， 取长度的一半为中位数下标
    public static double median(int[] n1, int[] n2) {
        if ((n1 == null && n2 == null)) {
            return 0;
        }

        // 合并
        int[] ns = IntStream.concat(Arrays.stream(n1), Arrays.stream(n2)).toArray();

        // 排序
        shellSort(ns);

        double median = 0;
        // 中位数 = 长度 / 2
        if (ns.length % 2 == 0) {

            median = (ns[(ns.length-1) / 2] + ns[ns.length / 2]) / 2d;
        } else {
            median = ns[ns.length / 2];
        }
        return median;
    }

    public static int[] shellSort(int[] arr) {
        var len = arr.length;

        for (int gap = (int)Math.floor(len / 2); gap > 0; gap = (int)Math.floor(gap / 2)) {
            // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
            for (var i = gap; i < len; i++) {
                var j = i;
                var current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
        return arr;
    }


}
