package com.example.demo.leetcode.ii;

/**
 * Description: 动态规划-多个数字组合求和，已知[2, 5, 7] 三个数字， 求组成27的最优解，用最少的数字
 *
 * ps1：输入：[2， 5， 7] 27  输出：6 =》 7，7，7，2，2，2（错误，非最优解）❎
 * ps1：输入：[2， 5， 7] 27  输出：5 =》 7，5，5，5，5（最优解） ✔
 *
 * @author Zeti
 * @date 2022/1/26 10:41 AM
 */
public class SumOfNumber {

    public static void main(String[] args) {
        int[] a = {2, 5, 7};
        int s = 27;

//        System.err.println(sum(a, s));
        System.err.println(minCoins1(a, s));

    }

    // f(x) = f(27 - ak) + 1

    /**
     *  动态规划
     *
     *  步骤：
     *  1.确定状态：
     *      1.1 确定最后一步
     *      1.2 拆解子问题
     *
     *  2.转移方程
     *      2.1 f(x) = ....
     *
     *  3.初始化条件、确定边界
     *
     *  4.计算顺序
     */
    public static int[] sum(int[] arr, int m) {
        //
        int[] f = new int[m + 1];

        int n = arr.length;

        f[0] = 0;

        for (int i = 1; i <= m; i++) {
            f[i] = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (i >= arr[j] && f[i - arr[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - arr[j]] + 1, f[i]);
                }
            }
        }

        // TODO: 2022/1/26  



        return null;
    }

    /**
     * 求解得到aim的最小货币数（arr中的值不重复，每个值代表一种货币，但每种可以重复使用）
     * @param arr 输入的货币值数组，每个值都不相等
     * @param ct 需要求解的货币总数
     * @return 刚好生成需要求解的货币总数的最小货币数
     */
    public static int minCoins1(int[] arr, int ct) {
        if (arr == null || arr.length == 0 || ct < 0) {
            return -1; //表示不存在最小货币数满足aim要求
        }
        int m = arr.length; //矩阵的行
        int n = ct + 1; //矩阵的列
        int max = Integer.MAX_VALUE; //不存在最小货币数满足要求，则dp[i][j]=max

        int[][] dp = new int[m][n];
        //对第一行特殊处理，它只能使用arr[0]
        for (int j = 1; j < n; j++) {
            dp[0][j] = max;  //先让所有为max，后面的if再将符合条件的修改
            //如果dp[0][j]前面的dp[0][j-arr[0]]不为max，说明此时又到了arr[0]倍数的地方
            if (j >= arr[0] && dp[0][j-arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //下面这步求解左边的
                int left = max;
                if (j >= arr[i] && dp[i][j-arr[i]] != max) {
                    left = dp[i][j-arr[i]] + 1;
                }
                //将左边的与上边的比较大小
                dp[i][j] = Math.min(left, dp[i-1][j]);
            }
        }
        return dp[m-1][ct] != max ? dp[m-1][ct] : -1; //若最终不存在最少货币数，返回-1；存在的话，则返回最小货币数。
    }




}
