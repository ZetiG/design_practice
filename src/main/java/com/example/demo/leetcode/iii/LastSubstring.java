package com.example.demo.leetcode.iii;


/**
 * Description: 1163. 按字典序排在最后的子串
 * 给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/last-substring-in-lexicographical-order
 *
 * @author Zeti
 * @date 2023/4/24 10:57
 */
public class LastSubstring {

    public static void main(String[] args) {
        String s1 = "abab";
        System.err.println(lastSubstring(s1)); // "bab"

        String s2 = "leetcode";
        System.err.println(lastSubstring(s2)); // "tcode"

        String s3 = "cacacb";
        System.err.println(lastSubstring(s3)); // "cb"

        String s4 = "zzzzz";
        System.err.println(lastSubstring(s4)); // "zzzzz"

        String s5 = "cacacbacab";
        System.err.println(lastSubstring(s5)); // "cbacab"

    }

    public static String lastSubstring(String s) {
        int n = s.length();
        int i = 0;

        for (int j = 1, k = 0; j + k < n;) {
            // 比较下标 0 和 1的大小
            int d = s.charAt(i + k) - s.charAt(j + k);

            // 如果d=0，代表s[i~i+k] == s[j~j+k]; k++比较下一位字符
            if (d == 0) {
                k++;
            } else if (d > 0) {
                // d>0, 代表s[i~i+k] > s[j~j+k]; 移动j, 且重置k, 重复该比较动作
                j = j + k + 1;
                k = 0;
            } else {
                // d<0, 代表s[i~i+k] < s[j~j+k]; 移动i，且重置k, 重复该比较动作
                i = i + k + 1;
                k = 0;

                // 如果i移动到的下标大于等于j； 则同时移动j的位置; 跳过[i~i+k]为起始位置，因为无论如何[i~i+k]为起始的字符串都小于[j~j+k]
                if (i >= j) {
                    j = i + 1;
                }
            }
        }
        return s.substring(i);
    }

    // cacacb
    public static String lastSubstring2(String s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }

}
