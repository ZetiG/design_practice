package com.example.demo.leetcode.i;

import java.util.Arrays;

/**
 * Description: 整数元素数组中所有数字组合代表一个非负整数，求这个整数加1 后的数组
 * ps1: 输入：[1,2,3] 代表：123 + 1 = 124   输出：[1,2,4]
 * ps2: 输入：[1,0,9] 代表：109 + 1 = 110   输出：[1,1,0]
 * ps3: 输入：[9,9,9] 代表：999 + 1 = 1000  输出：[1,0,0,0]
 *
 * @author Zeti
 * @date 2022/1/14 4:58 PM
 */
public class ArrayNumAddOne {

    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        int[] a2 = {1,0,9};
        int[] a3 = {9,9,9};

        System.err.println(Arrays.toString(plusOne(a1)));
        System.err.println(Arrays.toString(plusOne(a2)));
        System.err.println(Arrays.toString(plusOne(a3)));

    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                //如果数组当前元素不等于9，直接加1
                //然后直接返回
                digits[i]++;
                return digits;
            } else {
                //如果数组当前元素等于9，那么加1之后
                //肯定会变为0，我们先让他变为0
                digits[i] = 0;
            }
        }
        //除非数组中的元素都是9，否则不会走到这一步，
        //如果数组的元素都是9，我们只需要把数组的长度
        //增加1，并且把数组的第一个元素置为1即可
        int temp[] = new int[length + 1];
        temp[0] = 1;
        return temp;
    }


}
