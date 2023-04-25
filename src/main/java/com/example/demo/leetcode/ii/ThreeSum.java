package com.example.demo.leetcode.ii;

import java.util.*;

/**
 * Description: 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author Zeti
 * @date 2023/4/25 15:14
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] n1 = {-1,0,1,2,-1,-4};
        System.err.println(threeSum(n1)); // [[-1,-1,2],[-1,0,1]]

        int[] n2 = {0,1,1};
        System.err.println(threeSum(n2)); // []

        int[] n3 = {0,0,0};
        System.err.println(threeSum(n3)); // [[0,0,0]]

        int[] n4 = {1,2,-2,-1};
        System.err.println(threeSum(n4)); // []

        int[] n5 = {0,0,0,0};
        System.err.println(threeSum(n5)); // [[0,0,0]]

        int[] n6 = {-2,0,0,2,2};
        System.err.println(threeSum(n6)); // [[-2,0,2]]


    }

    // -1, 0, 1, 2, -1, -4
    // -4  -1  -1  0  1  2
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // 排序
        List<List<Integer>> res = new ArrayList<>();

        // 遍历，每次取nums[i]为固定第一个值，内部双指针取(两个数+nums[i]=0)的数
        for (int i = 0; i < nums.length; i++) {

            // 第一个数大于0，由于是增序有序数组，所以和后面的数相加，总和无论如何也不为0
            if (nums[i] > 0) {
                break;
            }

            // 需要和上一次枚举的数不相同，否则可能出现重复数字
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 左指针初始为i+1, 右指针为数组最后一位数；因为数组最开始已经排过序，所以(i<=i+1)一定是恒等的
            int l = i+1, r = nums.length-1;

            while (l < r) {
                int n1 = nums[i],  n2 = nums[l], n3 = nums[r];
                int sum = n1 + n2 + n3;
                if (sum == 0) {
                    res.add(List.of(n1, n2, n3));
                    l++;    // 当满足总和为0时，且题目要求非重复数字，所以单单移动任何一侧的指针都有可能出现重复
                    r--;

                    // 当上面条件满足时，且已同时移动过两个指针时，当前指针指向的数字仍然重复，则继续移动重复数字的指针
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum > 0) {
                    r--;    // 总和大于0，则缩小较大值的指针
                } else {
                    l++;    // 总和小于0，则增加较小值的指针
                }
            }
        }
        return res;
    }

}
