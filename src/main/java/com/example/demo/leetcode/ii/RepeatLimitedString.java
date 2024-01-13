package com.example.demo.leetcode.ii;

/**
 * Description: 2182. 构造限制重复的字符串
 *  给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
 *
 *  返回 字典序最大的 repeatLimitedString 。
 *
 *  如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length)
 *  个字符都相同，那么较长的字符串字典序更大。
 *
 * @author Zeti
 * @date 2024/1/13 14:08
 */
public class RepeatLimitedString {
    public static void main(String[] args) {
        String s1 = "cczazcc";
        int r1 = 3;
        System.err.println(repeatLimitedString(s1, r1));    // zzcccac

        String s2 = "aababab";
        int r2 = 2;
        System.err.println(repeatLimitedString(s2, r2));    // bbabaa

        String s3 = "bplpcfifosybmjxphbxdltxtfrjspgixoxzbpwrtkopepjxfooazjyosengdlvyfchqhqxznnhuuxhtbrojyhxwlsrklsryvmufoibgfyxgjw";
        int r3 = 1;
        System.err.println(repeatLimitedString(s3, r3));    //

    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] arrCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arrCount[s.charAt(i)-'a']++;
        }

        int n = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 25; i >= 0;) {
            if (arrCount[i] > 0 && n < repeatLimit) {
                builder.append((char)('a' + i));
                n++;
                arrCount[i]--;
            } else if (i > 0 && arrCount[i] > 0 && n == repeatLimit) {
                for (int j = i-1; j >= 0; j--) {
                    if (arrCount[j] > 0) {
                        builder.append((char)('a' + j));
                        n=0;
                        arrCount[j]--;
                        break;
                    }

                    if (j == 0 && arrCount[j] == 0) {
                        return builder.toString();
                    }
                }
            } else {
                i--;
                n=0;
            }
        }
        return builder.toString();
    }

}
