package com.example.demo.leetcode.ii;

/**
 * Description: 1567. 乘积为正数的最长子数组长度
 *  给你一个整数数组 nums，请你求出乘积为正数的最长子数组的长度。
 *  一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 *  请你返回乘积为正数的最长子数组长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-length-of-subarray-with-positive-product
 * 
 * @author Zeti
 * @date 2023/4/6 16:46
 */
public class DP_GetMaxLen {

    public static void main(String[] args) {
        int[] n1 = {1,-2,-3,4,0}; // 4
        System.err.println(getMaxLen(n1));

        int[] n2 = {0,1,-2,-3,-4}; // 3
        System.err.println(getMaxLen(n2));

        int[] n3 = {-1,-2,-3,0,1};  // 2
        System.err.println(getMaxLen(n3));

        int[] n4 = {-1,2};  // 1
        System.err.println(getMaxLen(n4));

        int[] n5 = {5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2};  // 8
        //          0  1   2   3  4  5 6 7 8  9  10 11  12 13 14 15  15  17 18 19
        System.err.println(getMaxLen(n5));

    }

    // DP，维护最长正数长度、和最长负数长度，每进来一个元素，则判断当前正负数长度是否需要增加
    public static int getMaxLen(int[] nums) {
        int res = 0;

        int pos = 0;    // 当前最长正数长度
        int neg = 0;    // 当前最长负数长度

        for (int n : nums) {
            int nextPos = 0;
            int nextNeg = 0;

            if (n > 0) {
                nextPos = pos + 1;  // 若前面积为正数，且n也为正数，则正数pos长度+1；
                if (neg > 0) {
                    nextNeg = neg + 1;  // 若前面的积为负数<有且只有>，而n为正数，则负数长度+1;
                }

            } else if (n < 0) {
                if (neg > 0) {
                    nextPos = neg + 1;  // 若当前积为负数，而n也为负数，则结果为正数，所以pos+1；
                }
                nextNeg = pos + 1;  // 若当前积为正数，而n为负数，则结果为负数，所以neg+1；

            }

            pos = nextPos;
            neg = nextNeg;

            res = Math.max(res, pos);
        }

        return res;
    }

    // DP 未优化
    public static int getMaxLen3(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];
        pos[0] = (nums[0] > 0) ? 1 : 0;
        neg[0] = (nums[0] < 0) ? 1 : 0;

        int ans = pos[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                pos[i] = pos[i - 1] + 1;
                neg[i] = (neg[i - 1] > 0) ? neg[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                pos[i] = (neg[i - 1] > 0) ? neg[i - 1] + 1 : 0;
                neg[i] = pos[i - 1] + 1;
            } else {
                pos[i] = 0;
                neg[i] = 0;
            }
            ans = Math.max(ans, pos[i]);
        }
        return ans;
    }

    // 1,-2,-3,4
    // 1 -1 -1 1
    public static int getMaxLen2(int[] nums) {
        int max = 0;
        int positive = 0,negative = 0;
        for(int i : nums) {
            int nextPositive = 0;
            int nextNegative = 0; // 如果i==0,清零
            if(i > 0){
                nextPositive = positive + 1;// 正 * 正 = 正 这里的1就是代表i的个数(前面没有负数，这个正数也可以自己成为一个正数，所以不需要if再判断)
                if(negative > 0) {
                    nextNegative = negative + 1;// 负 * 负 = 正（负负得正前提是前面要有负数，所以这里加一个if判断）
                }
            }else if(i < 0){
                nextNegative = positive + 1;// 正 * 负 = 负(前面没有正数，这个负数也可以自己成为一个负数，所以不需要if再判断)
                if(negative > 0) {
                    nextPositive = negative + 1;// 负 * 负 = 正（负负得正前提是前面要有负数，所以这里加一个if判断）
                }
            }
            positive = nextPositive;// 迭代
            negative = nextNegative;

            max = Math.max(max,positive);// 打擂法选出最长乘积为正的数组
        }
        return max;
    }

}
