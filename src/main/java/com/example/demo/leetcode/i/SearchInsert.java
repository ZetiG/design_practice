package com.example.demo.leetcode.i;

/**
 * Description: 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 *
 * @author Zeti
 * @date 2023/6/8 10:44
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] n1 = {1, 3, 5, 6};
        int t1 = 5;
        System.err.println(searchInsert(n1, t1));   // 2

        int[] n2 = {1, 3, 5, 6};
        int t2 = 2;
        System.err.println(searchInsert(n2, t2));   // 1

        int[] n3 = {1, 3, 5, 6};
        int t3 = 7;
        System.err.println(searchInsert(n3, t3));   // 4

    }
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            // 中间坐标
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
