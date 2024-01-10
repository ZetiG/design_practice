package com.example.demo.leetcode.iii;

import java.util.Arrays;

/**
 * Description: 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 1 <= nums.length <= 5 * 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * @author Zeti
 * @date 2024/1/10 09:45
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] n0 = {1,2,3};
        System.err.println(firstMissingPositive(n0));   // 4

        int[] n1 = {1,2,0};
        System.err.println(firstMissingPositive(n1));   // 3

        int[] n2 = {3,4,-1,1};
        System.err.println(firstMissingPositive(n2));   // 2

        int[] n3 = {7,8,9,11,12};
        System.err.println(firstMissingPositive(n3));   // 1

        int[] n4 = {-5,-3,0,-8,-6,-9};
        System.err.println(firstMissingPositive(n4));   // 1

        int[] n5 = {1,1000};
        System.err.println(firstMissingPositive(n5));   // 2

        int[] n6 = {2147483647,2147483646,2147483645,3,2,1,-1,0,-2147483648};
        System.err.println(firstMissingPositive(n6));   //

    }

    // 正整数（自然数中>0的那一部分，1、2、3、4、5...）
    // 要求：时间复杂度O(n) 常数级别额外空间
    public static int firstMissingPositive(int[] nums) {
        int[] ints = new int[nums.length];  // 定义可容纳原数组nums长度的新数组

        // 遍历原数组，将每个元素-1得到一个下标值，并修改ints中对应下标的值
        for (int num : nums) {
            if (num-1 >= 0 && num-1 < ints.length) {
                ints[num-1] = 1;
            }
        }

        // 遍历新数组，未被修改的下标即为缺失的最小正整数-1
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                return i+1;
            }
        }
        // 如果ints内都被修改，则代表nums内为(1->nums.length)的有序数组，则缺失的最小正整数为nums.length+1
        return ints.length+1;
    }


    // 先排序，剔除<0的整数，再遍历用后一个值减去前一个值，结果大于1的即为缺失中间的正整数
    public static int firstMissingPositive2(int[] nums) {
        nums = Arrays.stream(nums).filter(n -> n > 0).sorted().toArray();
        if (nums.length == 0 || nums[0] > 1) {
            return 1;
        }

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i-1]) > 1)  {
                return nums[i-1] + 1;
            }
        }
        return nums[nums.length-1] + 1;
    }

}
