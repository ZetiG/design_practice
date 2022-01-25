package com.example.demo.leetcode.i;

/**
 * Description: 回文数, 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * ps1：输入：x = 121       输出：true
 * ps2: 输入：x = -121     输出：false    解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数
 * ps3: 输入：x = 10       输出：false    解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @author Zeti
 * @date 2022/1/25 2:48 PM
 */
public class PalindromeNumber {

    public static void main(String[] args) {

        System.err.println(isPalindrome(121));
        System.err.println(isPalindrome(-121));
        System.err.println(isPalindrome(10));
        System.err.println(isPalindrome(101));
        System.err.println(isPalindrome(11));
        System.err.println(isPalindrome(21112));

        System.err.println(isPalindrome2(121));
        System.err.println(isPalindrome2(-121));
        System.err.println(isPalindrome2(10));
        System.err.println(isPalindrome2(101));
        System.err.println(isPalindrome2(11));
        System.err.println(isPalindrome2(21112));


    }

    // d2 进阶，反转一半, 如：1221， 取后一半为21，反转得到12， 且等于原数的前一半，则回文数成立
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int tmp = 0;
        while (x > tmp) {

            tmp = tmp * 10 + x % 10;

            x /= 10;
        }

        return x == tmp || x == tmp / 10;
    }


    // d1 反转得到数字 == 原数字
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int ct = x;
        int tmp = 0;

        while (x / 10 > 0 || x % 10 > 0) {
            int i = x % 10;
            tmp = (tmp + i);
            x = x / 10;
            if (x > 0) {
                tmp *= 10;
            }
        }

        return tmp == ct;
    }


}
