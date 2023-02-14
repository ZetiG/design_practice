package com.example.demo.leetcode.ii;

/**
 * Description: 1124. 表现良好的最长时间段
 *
 * 给你一份工作时间表hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-well-performing-interval
 *
 * @author Zeti
 * @date 2023/2/14 14:16
 */
public class Hours996 {

    public static void main(String[] args) {
        int[] h1 = {9,9,6,0,6,6,9};
        System.err.println(3== longestWPI(h1));

        int[] h2 = {6,6,6};
        System.err.println(0== longestWPI(h2));

        int[] h3 = {6,6,9};
        System.err.println(1== longestWPI(h3));

        int[] h4 = {6,9,9};
        System.err.println(3== longestWPI(h4));

        int[] h5 = {9,9,9,6,6,6,6,9,9};
        System.err.println(9== longestWPI(h5));

        int[] h6 = {6,6,9,6,6,6};
        System.err.println(1== longestWPI(h6));

        int[] h7 = {6,6,6,9,9,6,6,9,6,9,6};
        System.err.println(7== longestWPI(h7));

        int[] h8 = {9,9,9};
        System.err.println(3== longestWPI(h8));

    }

    /**
     * todo
     */
    public static int longestWPI2(int[] hours) {
        // （>8 取 1）or（<=8 取 -1）
        int[] ints = new int[hours.length + 1];
        for (int i = 0; i < hours.length; i++) {
            int i1 = hours[i] > 8 ? 1 : -1;
            ints[i + 1] = i1;
        }

        // 数组前缀和，计算结果数组
        int[] ctInts = new int[ints.length];
        for (int i = 1; i < ctInts.length; i++) {
            ctInts[i] = ctInts[i - 1] + ints[i];
        }

        // [0, 1, 2, 1, 0, -1, -2, -1]
        for (int i = ctInts.length - 1; i > 0; i--) {
            if (ctInts[i] == 1) {
                return i;
            }
        }

        // TODO: 2023/2/14
        return 0;
    }

    public static int longestWPI(int[] hours) {
        int len, sum, max = 0;
        int[] ints = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            int i1 = hours[i] > 8 ? 1 : -1;
            ints[i] = i1;
        }

        for (int i = 0; i < ints.length; i++) {
            sum = ints[i];
            for (int j = i; j < ints.length; j++) {
                if (j != i) {
                    sum += ints[j];
                }
                if (sum > 0) {
                    len = j - i + 1;
                    max = Math.max(max, len);
                }
            }
        }
        return max;
    }

}
