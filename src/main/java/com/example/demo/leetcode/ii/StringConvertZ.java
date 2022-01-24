package com.example.demo.leetcode.ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 字符串Z字形变换
 * <p>将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。</p>
 * <p>
 * ps1: 输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 输出:"PAHN  APLSIIG  YIR"
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * ps2: 输入：s = "PAYPALISHIRING", numRows = 4  输出："PIN ALSIG YAHR PI"
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author Zeti
 * @date 2022/1/24 2:00 PM
 */
public class StringConvertZ {

    public static void main(String[] args) {

        System.err.println(convert("PAYPALISHIRING", 4));

        System.err.println(convert2("PAYPALISHIRING", 4));

    }


    // 首行公式 (n + n - 2)
    // 首行 ()*0，()*1，()*2, ()*3, ...
    // 次行 [()*0 + n, ()*0 + ()- n], [()*1 + n, ()*1 + ()- n], [()*2 + n, ()*2 + ()- n], ...
    // ...
    public static String convert(String s, int n) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (n <= 1) {
            return s;
        }

        // 返回
        StringBuilder res = new StringBuilder();

        // 循环得到每一行
        for (int i = 0; i < n; i++) {

            // 行数据合并
            for (int j = 0; j <= s.length() / (n + (n - 2)); j++) {

                int i1 = (n + (n - 2)) * j;

                if (i1 + i < s.length()) {
                    res.append(s.charAt(i1 + i));
                }

                if (i > 0 && i < n - 1) {
                    int i2 = i1 + (n + (n - 2) - i);
                    if (i2 < s.length()) {
                        res.append(s.charAt(i2));
                    }
                }
            }
        }

        return res.toString();
    }

    // d2
    public static String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

}
