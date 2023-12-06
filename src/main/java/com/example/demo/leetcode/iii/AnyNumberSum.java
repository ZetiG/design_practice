package com.example.demo.leetcode.iii;

/**
 * Description: 1250. 检查「好数组」
 *
 *  给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
 * 假如该和结果为1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-it-is-a-good-array
 *
 * @author Zeti
 * @date 2023/2/15 09:57
 */
public class AnyNumberSum {
    public static void main(String[] args) {
        int[] a1 = {12,5,7,23};
        System.err.println(isGoodArray(a1));

        int[] a2 = {29,6,10};
        System.err.println(isGoodArray(a2));

        int[] a3 = {3,6};
        System.err.println(isGoodArray(a3));

    }

    //
    public static boolean isGoodArray(int[] nums) {


        return true;
    }


}
