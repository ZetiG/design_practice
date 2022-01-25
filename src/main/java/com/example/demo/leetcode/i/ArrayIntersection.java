package com.example.demo.leetcode.i;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description: 返回两个数组交集
 * ps1: 输入：nums1 = [1,2,2,1], nums2 = [2,2]     输出：[2,2]
 * ps2: 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]     输出：[4,9]
 *
 * 进阶：如果给定的数组已经排好序呢？你将如何优化你的算法？
 *      如果 nums1 的大小比 nums2 小，哪种方法更优？
 *      如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author Zeti
 * @date 2022/1/14 4:07 PM
 */
public class ArrayIntersection {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 2, 1};
        int[] a2 = {2, 2};

        int[] b1 = {4, 9, 5};
        int[] b2 = {9, 4, 9, 8, 4};

        // d1
        System.err.println(Arrays.toString(intersection(a1, a2)));

    }

    // 4, 5, 9
    // 4, 4, 8, 9, 9
    // d1 双指针，先对两个数组正向排序，两个指针分别对应两个数组，比较两个指针指向的数据大小，不断移动值小的一方
    public static int[] intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;

        ArrayList<Integer> res = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                res.add(arr1[i]);
                i++;
                j++;

            } else if (arr1[i] > arr2[j]) {
                j++;

            } else {
                i++;
            }
        }

        int index = 0;
        int[] array = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            array[index++] = res.get(k);
        }
        return array;

    }


}
