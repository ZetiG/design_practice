package com.example.demo.leetcode.ii;

/**
 * Description: 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * @author Zeti
 * @date 2023/4/25 14:34
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] h1 = {1,8,6,2,5,4,8,3,7};
        System.err.println(maxArea(h1)); // 7-7 = 49

        int[] h2 = {1,1};
        System.err.println(maxArea(h2)); // 1

    }

    // 输入：[1,8,6,2,5,4,8,3,7]
    // Math.max(Math.min(x1, x2) * (idx_x2 - idx_x1))
    public static int maxArea(int[] height) {
        int res = 0;

        // 初始化，定义左右边界
        int left = 0, right = height.length-1;

        // 左边界一定小于右边界
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));

            // 移动较小的那个边界；如果相同，这里默认移动右边界
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }


    // 暴力遍历-超时
    public static int maxArea_2(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }


}
