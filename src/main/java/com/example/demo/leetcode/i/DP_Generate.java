package com.example.demo.leetcode.i;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 118. 杨辉三角
 *  给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 * @author Zeti
 * @date 2023/4/12 09:32
 */
public class DP_Generate {

    public static void main(String[] args) {
//        int r1 = 5; // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//        System.err.println(generate(r1));
//
//        int r2 = 1; // [[1]]
//        System.err.println(generate(r2));
        

        int row1 = 5;
        System.err.println(getRow(row1));

        int row2 = 1;
        System.err.println(getRow(row2));

        int row3 = 0;
        System.err.println(getRow(row3));


    }

    //      1            len=1
    //     1  1          len=2
    //   1  2  1         len=3
    //  1  3  3  1       len=4
    // 1  4  6  4  1     len=5

    // 0  1  2  3  4  // 下标
    // int num = (i - 1) * (len - i + 1) / i;
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }

        Integer[] tmp = new Integer[1];
        tmp[0] = 1;
        res.add(Arrays.asList(tmp));
        if (numRows == 1) {
            return res;
        }

        for (int i = 1; i < numRows; i++) {
            Integer[] dp = new Integer[i+1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[j] = tmp[0];
                    continue;
                }
                dp[j] = tmp[j-1] + tmp[j];
            }
            tmp = dp;
            res.add(Arrays.asList(dp));
        }
        return res;
    }

    // 返回第n行，优化后
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            int i1 = row.get(i - 1) * (rowIndex - i + 1) / i;
            row.add(i1);
        }
        return row;
    }

    // 返回第n行, 待优化
    public static List<Integer> getRow2(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<>();
        }

        Integer[] res = new Integer[1];
        res[0] = 1;

        for (int i = 1; i <= rowIndex+1; i++) {
            Integer[] dp = new Integer[i];
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i-1) {
                    dp[j] = res[0];
                    continue;
                }
                dp[j] = res[j-1] + res[j];
            }
            res = dp;
        }
        return Arrays.asList(res);
    }

    // dp 空间浪费，多处0填充；此处只为提供思路
    public static List<List<Integer>> generate2(int numRows) {
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;

        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return Arrays.stream(dp).map(l -> Arrays.stream(l)
                .boxed().collect(Collectors.toList())).collect(Collectors.toList());
    }

}
