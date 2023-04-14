package com.example.demo.leetcode.ii;

import org.apache.flink.shaded.guava18.com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/4/14 11:43
 */
public class DP_MinimumTotal {

    public static void main(String[] args) {
        List<List<Integer>> ls1 = new ArrayList<>();
        ls1.add(Lists.newArrayList(2));
        ls1.add(Lists.newArrayList(3,4));
        ls1.add(Lists.newArrayList(6,5,7));
        ls1.add(Lists.newArrayList(4,1,8,3));
        System.err.println(minimumTotal(ls1)); // 输出：11

        List<List<Integer>> ls2 = new ArrayList<>();
        ls2.add(Lists.newArrayList(-10));
        System.err.println(minimumTotal(ls2)); // 输出：-10

        List<List<Integer>> ls3 = new ArrayList<>();
        ls3.add(Lists.newArrayList(2));
        ls3.add(Lists.newArrayList(3,3));
        ls3.add(Lists.newArrayList(6,5,6));
        ls3.add(Lists.newArrayList(4,8,8,3));
        System.err.println(minimumTotal(ls3)); // 输出：14

    }

    //     2
    //   3   3
    //  6  5  6
    // 4  8  8  3
    public static int minimumTotal(List<List<Integer>> t) {
        if (t.size() == 1) {
            return t.get(0).get(0);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < t.size(); i++) {
            List<Integer> sonList = t.get(i);

            int i0 = sonList.get(0) + t.get(i - 1).get(0);
            sonList.set(0, i0);
            if (i == t.size() - 1) {
                res = Math.min(res, i0);
            }

            for (int j = 1; j < sonList.size() - 1; j++) {
                int ij = sonList.get(j) + Math.min(t.get(i - 1).get(j-1), t.get(i - 1).get(j));
                sonList.set(j, ij);
                if (i == t.size()-1) {
                    res = Math.min(res, ij);
                }
            }

            int in = sonList.get(sonList.size() - 1) + t.get(i - 1).get(t.get(i - 1).size() - 1);
            sonList.set(sonList.size() - 1, in);
            if (i == t.size() - 1) {
                res = Math.min(res, in);
            }

            t.set(i, sonList);
        }
        return res;
    }

}
