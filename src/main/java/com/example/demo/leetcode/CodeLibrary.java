package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 题库
 *
 * @author Zeti
 * @date 2021/4/9 上午11:56
 */
public class CodeLibrary {

    /**
     * 两数之和
     * <p>
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/tencent/xxqfy5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length <= 0) {
                return new int[]{};
            }

            Map<Integer, Integer> map = new HashMap();

            for (int i = 0; i < nums.length; i++) {
                int a = target - nums[i];
                if (map.containsKey(a)) {
                    return new int[]{map.get(a), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }


    int[] a = {3,8,9,10};

    int[] b = {2,4,6,12,18,20};

    int[] c = {1,2,3,7};

    int[]nums1 = {-1,1,3,5,7,19};

    int[]nums2 ={2,4,6,6,10,12,14,16};


    public static void main(String[] args) {
        int[] a = {3,8,9,10};
        int[] b = {2,4,6,12,18,20};

//        double medianSortedArrays2 = findMedianSortedArrays2(a, b);
//        System.err.println(medianSortedArrays2);
        int[]nums1 = {-1,1,3,5,7,19};

        int[]nums2 ={2,3,4,4,10,12,14,16};



    }



    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1>n2)
            return findMedianSortedArrays(nums2, nums1);

        int k = (n1 + n2 + 1)/2; // 7
        int left = 0;
        int right = n1; // 6

        while(left < right){
            int m1 = left +(right - left)/2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2-1])
                left = m1 + 1;
            else
                right = m1;
        }

        int m1 = left;
        int m2 = k - left;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1-1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2-1]);
        if ((n1 + n2) % 2 == 1)
            return c1;
        int c2 = Math.min( m1 >= n1 ? Integer.MAX_VALUE :nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;

    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }



}
