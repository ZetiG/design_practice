package com.example.demo.leetcode.iii;


import java.util.Arrays;

/**
 * Description: 1012. 至少有 1 位重复的数字
 *  给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。
 * @author Zeti
 * @date 2023/3/20 10:25
 */
public class NumDupDigitsAtMostN {

    public static void main(String[] args) {
//        int n1 = 20;
//        System.err.println(1 == numDupDigitsAtMostN(n1));
//
//        int n2 = 100;
//        System.err.println(10 == numDupDigitsAtMostN(n2));
//
//        int n3 = 1000;
//        System.err.println(262 == numDupDigitsAtMostN(n3));

        int n4 = 123;
        System.err.println(numDupDigitsAtMostN(n4));

    }

    // 123
    // 0  0  0
    // 1  1  1
    //    2  2
    //       3
    static char s[];
    static int dp[][];
    public static int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        int nLen = s.length;
        dp = new int[nLen][1 << 10];
        for (int i = 0; i < nLen; i++)
            Arrays.fill(dp[i], -1); // -1 表示没有计算过
        return n - f(0, 0, true, false);

    }

    public static int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length)
            return isNum ? 1 : 0; // isNum 为 true 表示得到了一个合法数字

        if (!isLimit && isNum && dp[i][mask] != -1)
            return dp[i][mask];

        int res = 0;
        if (!isNum) // 可以跳过当前数位
            res = f(i + 1, mask, false, false);
        int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 n 的一样，那么这一位至多填数字 s[i]（否则就超过 n 啦）
        for (int d = isNum ? 0 : 1; d <= up; ++d) // 枚举要填入的数字 d
            if ((mask >> d & 1) == 0) // d 不在 mask 中
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);

        if (!isLimit && isNum)
            dp[i][mask] = res;

        return res;
    }



}
