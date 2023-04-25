package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: 2418. 按身高排序
 * 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 *
 * @author Zeti
 * @date 2023/4/25 10:07
 */
public class SortPeople {

    public static void main(String[] args) {
        String[] n1 = {"Mary","John","Emma"};
        int[] h1 = {180,165,190};
        System.err.println(Arrays.toString(sortPeople(n1, h1))); // ["Mary","Emma","John"]

        String[] n2 = {"Alice","Bob","Bob2"};
        int[] h2 = {155,185,190};
        System.err.println(Arrays.toString(sortPeople(n2, h2))); // ["Bob","Alice","Bob"]


    }


    public static String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0; i < heights.length-1; i++) {
            for(int j = i+1; j < heights.length; j++) {
                int tmpH = heights[i];
                String tmpN = names[i];

                if (heights[j] > heights[i]) {
                    heights[i] = heights[j];
                    heights[j] = tmpH;

                    names[i] = names[j];
                    names[j] = tmpN;
                }
            }
        }
        return names;
    }
}
