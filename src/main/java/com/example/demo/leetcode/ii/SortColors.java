package com.example.demo.leetcode.ii;

import java.util.Arrays;

/**
 * Description: 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 *
 * @author Zeti
 * @date 2023/5/31 17:00
 */
public class SortColors {
    public static void main(String[] args) {
        int[] n1 = {2,0,2,1,1,0};
        sortColors(n1);
        System.err.println(Arrays.toString(n1)); // [0,0,1,1,2,2]

        int[] n2 = {2,0,1};
        sortColors(n2);
        System.err.println(Arrays.toString(n2)); // [0,1,2]

        int[] n3 = {1,2,0};
        sortColors(n3);
        System.err.println(Arrays.toString(n3)); // [0,1,2]

        int[] n4 = {2,1,2};
        sortColors(n4);
        System.err.println(Arrays.toString(n4)); // [1,2,2]

    }
    public static void sortColors(int[] nums) {
        int length = nums.length;
        int left = 0, right = length-1;

        for (int i = left; i <= right; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            }

            if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
                if (nums[i] != 1) {
                    --i;
                }
            }
        }
    }


}
