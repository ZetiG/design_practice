package com.example.demo.leetcode.ii;

/**
 * Description: 1031. 两个非重叠子数组的最大和
 * 给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 firstLen 和 secondLen 。
 * 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。
 * 子数组是数组的一个 连续 部分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/4/26 10:55
 */
public class MaxSumTwoNoOverlap {
    public static void main(String[] args) {
        int[] n1 = {0,6,5,2,2,5,1,9,4};
        int f1 = 1, s1 = 2;
        System.err.println(maxSumTwoNoOverlap(n1, f1, s1)); // 20

        int[] n2 = {3,8,1,3,2,1,8,9,0};
        int f2 = 3, s2 = 2;
        System.err.println(maxSumTwoNoOverlap(n2, f2, s2)); // 29

        int[] n3 = {2,1,5,6,0,9,5,0,3,8};
        int f3 = 4, s3 = 3;
        System.err.println(maxSumTwoNoOverlap(n3, f3, s3)); // 31

    }

    // 3,8, 1,3,2,1,8, 9,0
    // 灵神题解，前缀和+单次遍历保存A/B的最大值及和
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++)
            s[i + 1] = s[i] + nums[i]; // 计算 nums 的前缀和
        int ans = 0, maxSumA = 0, maxSumB = 0;
        for (int i = firstLen + secondLen; i <= n; ++i) {
            maxSumA = Math.max(maxSumA, s[i - secondLen] - s[i - secondLen - firstLen]);
            maxSumB = Math.max(maxSumB, s[i - firstLen] - s[i - firstLen - secondLen]);
            ans = Math.max(ans, Math.max(maxSumA + s[i] - s[i - secondLen],  // 左 a 右 b
                    maxSumB + s[i] - s[i - firstLen])); // 左 b 右 a
        }
        return ans;
    }

    // 0, 6, 5,  2,  2,  5,  1,  9,  4
    // 0  6  11  13  15  20  21  30  34
    // 前缀和+暴力枚举
    public static int maxSumTwoNoOverlap_2(int[] nums, int firstLen, int secondLen) {
        // 前缀和; 通过前缀和可代替以firstLen和secondLen为长度的子数组的和，即以第i位为起点，firstLenSum = f(i+(firstLen-1))-f(i-1)
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }

        int res = 0;
        for (int i = firstLen-1; i < nums.length; i++) {
            for (int j = secondLen-1; j < nums.length; j++) {
                // 当第一个目标数组合，以i为起点，i+firstLen-1为终点时，第二个目标数组和不能在此范围内取值
                if (j > i-firstLen && j < i+secondLen) {
                    continue;
                }

                // i~i+firstLen-1
                int fiSum = nums[i] - (i-firstLen<0?0:nums[i-firstLen]);
                int fjSum = nums[j] - (j-secondLen<0?0:nums[j-secondLen]);
                res = Math.max(res, fiSum + fjSum);
            }
        }
        return res;
    }

    //  0, 6, 5,  2,  2,  5,  1,  9,  4
    //  0  6  11  13  15  20  21  30  34
    // 纯暴力枚举
    // 方法1：求出数组所有满足firstLen 和 secondLen长度的子数组，遍历两个数组求最大不重叠的和
    public static int maxSumTwoNoOverlap_3(int[] nums, int firstLen, int secondLen) {
        // firstLen list； 以i为起点，firstLen长度的子数组和
        int[] fn = new int[nums.length-firstLen+1];
        for (int i = 0; i < fn.length; i++) {
            int len = firstLen;
            while (len > 0) {
                fn[i] += nums[i+len-1];
                len--;
            }
        }

        // secondLen list；以i为起点，secondLen长度的子数组和
        int[] sn = new int[nums.length-secondLen+1];
        for (int i = 0; i < sn.length; i++) {
            int len = secondLen;
            while (len > 0) {
                sn[i] += nums[i+len-1];
                len--;
            }
        }

        int res = 0;
        // 遍历两个长度和的子数组，跳过重复位置
        for (int i = 0; i < fn.length; i++) {
            for (int j = 0; j < sn.length; j++) {
                // 当第一个目标数组合，以i为起点，i+firstLen-1为终点时，第二个目标数组和不能在此范围内取值
                if (j > i-secondLen && j <= i+firstLen-1) {
                    continue;
                }
                res = Math.max(res, fn[i]+sn[j]);
            }
        }
        return res;
    }


}
