package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 18. 四数之和
 * 给你一个由n个整数组成的数组nums，和一个目标值target。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 *      0 <= a, b, c, d < n
 *      a、b、c 和 d 互不相同
 *      nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * 你可以按 任意顺序 返回答案 。
 *
 * @author Zeti
 * @date 2023/12/26 09:57
 */
public class FourSum {
    public static void main(String[] args) {
//        int[] n1 = {1,0,-1,0,-2,2}; int t1 = 0;
//        System.err.println(fourSum(n1, t1)); // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//        int[] n2 = {2,2,2,2,2}; int t2 = 8;
//        System.err.println(fourSum(n2, t2)); // [[2,2,2,2]]
//
//        int[] n3 = {-3,-2,-1,0,0,1,2,3}; int t3 = 0;
//        System.err.println(fourSum(n3, t3)); // [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//        int[] n4 = {1,-2,-5,-4,-3,3,3,5}; int t4 = -11;
//        System.err.println(fourSum(n4, t4)); // [[-5,-4,-3,1]]

        int[] n5 = {1000000000,1000000000,1000000000,1000000000}; int t5 = -294967296;
        System.err.println(fourSum(n5, t5)); // []


    }


    /**
     * {@link ThreeSum 解法同理三数之和}
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return new ArrayList<>();
        }

        // 递增排序
        Arrays.sort(nums);

        // -3,-2,-1,0,0,1,2,3
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len-3; i++) {
            // 首位数字重复，则有可能出现重复数据，跳过
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i+1; j < len-2; j++) {
                // 去重，当nums[j]==nums[j-1], 则可能出现重复数据，这里跳过
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int l = j + 1, r = len - 1;
                while (l < r) {
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum == target) {
                        res.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        l++;


                        while (l < r && nums[l] == nums[l-1]) {
                            l++;
                        }
                        while (l < r && r < len-1 && nums[r] == nums[r+1]) {
                            r--;
                        }
                    } else if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    }
                }
            }
        }
        return res;
    }


}
