package com.example.demo.leetcode.iii;

/**
 * Description: 1330. 翻转子数组得到最大的数组值 
 * 给你一个整数数组nums 。「数组值」定义为所有满足0 <= i < nums.length-1的|nums[i]-nums[i+1]|的和。
 * 你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作一次 。
 * 请你找到可行的最大 数组值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-subarray-to-maximize-array-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/5/12 16:32
 */
public class MaxValueAfterReverse {
    public static void main(String[] args) {
        int[] n1 = {2,3,1,5,4};
        System.err.println(maxValueAfterReverse(n1)); // 10

        int[] n2 = {2,4,9,24,2,1,10};
        System.err.println(maxValueAfterReverse(n2)); // 68

    }

    // 灵神解【https://leetcode.cn/problems/reverse-subarray-to-maximize-array-value/solution/bu-hui-hua-jian-qing-kan-zhe-pythonjavac-c2s6/】
    public static int maxValueAfterReverse1(int[] nums) {
        int base = 0, d = 0, n = nums.length;
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int a = nums[i - 1], b = nums[i];
            int dab = Math.abs(a - b);
            base += dab;
            mx = Math.max(mx, Math.min(a, b));
            mn = Math.min(mn, Math.max(a, b));
            d = Math.max(d, Math.max(Math.abs(nums[0] - b) - dab, // i=0
                    Math.abs(nums[n - 1] - a) - dab)); // j=n-1
        }
        return base + Math.max(d, 2 * (mx - mn));
    }

    // 2,3,1,5,4
    // 超时解；子数组翻转前后，只会有"第一个元素和最后一个元素"对总差值和有影响，只需要判断翻转前后，首尾元素的最大差值即可
    public static int maxValueAfterReverse(int[] nums) {
        // 原差值总和
        int ct = 0;
        for (int i = 0; i < nums.length-1; i++) {
            ct += Math.abs(nums[i] - nums[i+1]);
        }

        int max = 0;
        // 翻转位数；当翻转0/1位数字时，跟原数组一样，所以起始为2；
        for (int i = 2; i < nums.length; i++) {
            // 遍历寻找当翻转i位数字时，得到的最大值
            for (int j = 0; j < nums.length-i+1; j++) {

                // 翻转前的值（注意边界情况，下标不能越界）
                int before =((j-1)<0?0:Math.abs(nums[j-1] - nums[j])) + ((j+i)>nums.length-1?0:Math.abs(nums[j+i-1] - nums[j+i]));
                // 翻转后的值
                int after =((j-1)<0?0:Math.abs(nums[(j-1)] - nums[j+i-1])) + ((j+i)>nums.length-1?0:Math.abs(nums[j] - nums[j+i]));

                max = Math.max(max, after-before);
            }
        }
        return ct + max;
    }

}
