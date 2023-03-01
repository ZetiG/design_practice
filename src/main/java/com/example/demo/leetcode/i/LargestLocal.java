package com.example.demo.leetcode.i;

/**
 * Description: 2373. 矩阵中的局部最大值
 * 
 *  给你一个大小为 n x n 的整数矩阵 grid 。
 *  生成一个大小为(n - 2) x (n - 2) 的整数矩阵 maxLocal ，并满足：
 *  maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 *  换句话说，我们希望找出 grid 中每个3 x 3 矩阵中的最大值。
 *  返回生成的矩阵。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-local-values-in-a-matrix
 *
 * @author Zeti
 * @date 2023/3/1 10:09
 */
public class LargestLocal {

    public static void main(String[] args) {

        // 输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
        // 输出：[[9,9],[8,6]]
        // 解释：原矩阵和生成的矩阵如上图所示。 注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。

//        int[][] grid = {{9,9,8,1}, {5,6,2,6}, {8,2,6,4}, {6,2,2,2}};
//        System.err.println(largestLocal(grid));

        int[][] grid2 = {{9,9,8,1,7}, {5,6,2,6,3}, {8,2,6,4,4}, {6,2,2,2,6}, {5,8,2,0,5}};
        System.err.println(largestLocal(grid2));

    }

    //  9   9   8   1
    //  5   6   2   6
    //  8   2   6   4
    //  6   2   2   2

    //  9   9
    //  8   6

// -------------------------------

    //  9   9   8   1   7
    //  5   6   2   6   3
    //  8   2   6   4   4
    //  6   2   2   2   6
    //  5   8   2   0   5

    //  9   9   8
    //  8   6   6
    //  8   8   6
    public static int[][] largestLocal(int[][] grid) {

        // 结果数组
        int[][] temp = new int[grid.length-2][grid.length-2];
        for (int i = 0; i < grid.length; i++) {

            // 第一次处理，遍历一维数组取每个3*3的最大值
            for (int j = 0; j < grid[i].length - 2; j++) {
                int max1 = Math.max(grid[i][j], grid[i][j + 1]);
                int rowMax = Math.max(max1, grid[i][j + 2]);

                // 前n-2个数组一定是所有3*3的第一列，暂时存入数组，后续用最大值覆盖
                if (i < grid.length - 2) {
                    temp[i][j] = rowMax;
                }

                // 非首行数组，每次比较覆盖当前3*3中前两行数据
                if (i > 0) {
                    // 数组最后一行数据，不需要和前一行比较，因为结果数组只存了该3*3的首行
                    if (i > grid.length-2) {
                        temp[i-2][j] = Math.max(rowMax, temp[i-2][j]);
                        continue;
                    }

                    temp[i-1][j] = Math.max(rowMax, temp[i-1][j]);
                    if (i - 1 > 0) {
                        temp[i-2][j] = Math.max(rowMax, temp[i-2][j]);
                    }
                }
            }
        }
        return temp;
    }




}
