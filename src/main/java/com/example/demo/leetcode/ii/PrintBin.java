package com.example.demo.leetcode.ii;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 面试题 05.02. 二进制数转字符串
 *  二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 *  如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bianry-number-to-string-lcci
 *
 * @author Zeti
 * @date 2023/3/2 16:55
 */
public class PrintBin {

    public static void main(String[] args) {
        // 输入：0.625
        // 输出："0.101"
        System.err.println(printBin(0.625));

        // 输入：8.625
        // 输出："0.101"
        System.err.println(printBin(8.625));

        // 输入：0.1
        // 输出："ERROR"
        // 提示：0.1无法被二进制准确表示
        System.err.println(printBin(0.1));

    }

    public static String printBin2(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() <= 32 && num != 0) {
            num *= 2;
            int digit = (int) num;
            sb.append(digit);
            num -= digit;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }

    // 整数：十进制 -> 二进制； 除2取余 逆序排序
    // 小数：十进制 -> 二进制； 乘2取整 顺序排序
    public static String printBin(double num) {

        // 625
        // 0000 0000 0000 0110
        // 整数处理
        List<Object> list = new ArrayList<>();
        int ceil = (int) Math.floor(num);
        while (ceil > 0) {
            list.add(ceil % 2);
            ceil = ceil / 2;
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = list.size() - 1; i >= 0; i--) {
            buffer.append(list.get(i));
        }

        if (buffer.length() == 0) {
            buffer.append("0");
        }
        buffer.append(".");

        // 小数处理
        double smileV = num % 1;
        while (smileV > 0) {
            double _2v = smileV * 2;    // 乘2
            int v = (int) _2v;          // 取整
            buffer.append(v);
            smileV = _2v - v;
        }

        return buffer.length() > 32 ? "ERROR" : buffer.toString();
    }


}
