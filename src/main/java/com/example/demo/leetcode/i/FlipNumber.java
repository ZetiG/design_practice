package com.example.demo.leetcode.i;

/**
 * Description: 反转整数
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * ps1: 输入：x = 123  输出：321
 * ps2：输入：x = -123  输出：-321
 * ps3：输入：x = 120   输出：21
 * ps4：输入：x = 0 输出：0
 *
 * @author Zeti
 * @date 2022/1/18 3:04 PM
 */
public class FlipNumber {

    public static void main(String[] args) {
        int a1 = 1039;
        int a2 = -1239;
        int a3 = 999;
        int a4 = 0;
        int a5 = (int) Math.pow(2, 31); // 2147483646

        System.err.println(flip(a1));
        System.err.println(flip(a2));
        System.err.println(flip(a3));
        System.err.println(flip(a4));
        System.err.println(a5);
        System.err.println(flip(a5));

    }


    // d1 取余得出最后一个数字，下次用上次得出的值*10 再加当前得到的最后一个数字，循环如此，
    // 注意需要判断数字溢出，如int范围为，-2^32 < int < 2^32 - 1, 取反会溢出该范围，2147483646 ——> 6463847412(该值不属于int范围)
    public static int flip(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字溢出，直接返回0
            if ((newRes - t) / 10 != res)
                return 0;
            res = newRes;
            x = x / 10;
        }
        return res;
    }


}
