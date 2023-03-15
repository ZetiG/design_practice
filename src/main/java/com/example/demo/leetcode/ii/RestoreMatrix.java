package com.example.demo.leetcode.ii;

/**
 * Description: 1605. 给定行和列的和求可行矩阵
 *
 * 给你两个非负整数数组rowSum 和colSum，其中rowSum[i]是二维矩阵中第 i行元素的和， colSum[j]是第 j列元素的和。换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 * 请找到大小为rowSum.length x colSum.length的任意 非负整数矩阵，且该矩阵满足rowSum 和colSum的要求。
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个可行矩阵。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums
 * 
 * @author Zeti
 * @date 2023/3/14 19:10
 */
public class RestoreMatrix {

    public static void main(String[] args) {
        int[] r1 = {3,8}, c1 = {4,7};
        System.err.println(restoreMatrix(r1, c1));

        // 输入：rowSum = [5,7,10],
        //      colSum = [8,6,8]
        //输出：[[0,5,0],
        //      [6,1,0],
        //      [2,0,8]]
        int[] r2 = {5,7,10}, c2 = {8,6,8};
        System.err.println(restoreMatrix(r2, c2));

        int[] r3 = {14,9}, c3 = {6,9,8};
        System.err.println(restoreMatrix(r3, c3));

    }

    // 输入：rowSum = [3,8],
    //      colSum = [4,7]
    //输出：[[3,0],
    //      [1,7]]
    //另一个可行的矩阵为：[[3,0],
    //                   [1,7]]
    //
    // 思路：贪心思想，每次都尽量给最大值，且将给定的数组减去已经给出去的最大值，以便下次循环时方便判断当前剩余的值和需要给的最大值
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];

        for (int i = 0; i < res.length; i++) {
            int[] re = res[i];

            for (int j = 0; j < re.length; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                res[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        return res;
    }


    public static int[][] restoreMatrix2(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[][] matrix = new int[n][m];
        int i = 0, j = 0;
        while (i < n && j < m) {
            int v = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = v;
            rowSum[i] -= v;
            colSum[j] -= v;
            if (rowSum[i] == 0) {
                ++i;
            }
            if (colSum[j] == 0) {
                ++j;
            }
        }
        return matrix;
    }



}
