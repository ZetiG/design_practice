package com.example.demo.leetcode.ii;

/**
 * Description: 1702. 修改后的最大二进制字符串
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 *
 * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 *      比方说， "00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 *      比方说， "00010" -> "00001"
 *
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
 *
 * @author Zeti
 * @date 2024/4/10 10:03
 */
public class MaximumBinaryString {
    public static void main(String[] args) {
        String b1 = "000110";
        System.err.println(maximumBinaryString(b1));    // 111011

        String b2 = "01";
        System.err.println(maximumBinaryString(b2));    // 01

    }

    public static String maximumBinaryString(String binary) {
        // 字符串不包含0，直接返回
        int len = binary.length();
        int idx = binary.indexOf('0');
        if (len <= 0 || idx < 0) {
            return binary;
        }

        int cnt0 = 0;   // 统计0的数量
        char[] s = binary.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                cnt0++;
            }
            s[i] = '1'; // 将所有元素都变为1
        }

        // d由于推导结论得知，字符串最终只会包含1个0，这个0的位置取决于，首次出现0的位置，且每多出现一个0则向后移动一位
        s[idx + cnt0 - 1] = '0';

        return new String(s);
    }

}
