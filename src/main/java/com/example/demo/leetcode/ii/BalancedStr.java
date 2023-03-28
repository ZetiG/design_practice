package com.example.demo.leetcode.ii;

/**
 * Description: 1234. 替换子串得到平衡字符串
 *
 *   有一个只含有'Q', 'W', 'E','R'四种字符，且长度为 n 的字符串。
 * 假如在该字符串中，这四个字符都恰好出现n/4次，那么它就是一个「平衡字符串」。
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * 你可以用和「待替换子串」长度相同的任何 其他字符串来完成替换。
 * 请返回待替换子串的最小可能长度。
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/replace-the-substring-for-balanced-string
 *
 * @author Zeti
 * @date 2023/2/13 10:34
 */
public class BalancedStr {

    public static void main(String[] args) {
                String s1 = "QWER";
                System.err.println(balancedString(s1));

                String s2 = "QQER";
                System.err.println(balancedString(s2));

                String s3 = "QQQR";
                System.err.println(balancedString(s3));

        String s4 = "WWEQERQWQWWRWWERQWEQ";
        System.err.println(balancedString(s4));

    }

    // W W E Q E R Q W Q W  W  R  W  W  E  R  Q  W  E  Q
    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
    public static int balancedString(String s) {
        int sLen = s.length();
        int[] ct = new int[4];
        String str = "QWER";

        // 遍历字符串，统计每个字符出现的次数，将结果存入长度为4的数组
        for (char c : s.toCharArray()) {
            ct[str.indexOf(c)]++;
        }

        // 平衡字符串，每个字符出现的次数相等，即=(s.length/4)
        int frequency = sLen / 4;
        if (ct[0] == frequency && ct[1] == frequency && ct[2] == frequency && ct[3] == frequency) {
            return 0;
        }

        int sonLen = sLen;
        for (int i = 0, j = 0; i < sLen; i++) {
            // 替换某段子串，即可得到平衡字符串，即代表除待替换的该子串之外的字符串中，每个字符出现的次数均不能超过(s.length/4)
            char c = s.charAt(i);
            ct[str.indexOf(c)]--;

            // 判断剩余字符串中每个字符出现的次数均小于(s.length/4)，如果满足条件则尝试左侧缩短字串长度，从而找出满足条件的最短子串
            while (i >= j && ct[0] <= frequency && ct[1] <= frequency && ct[2] <= frequency && ct[3] <= frequency) {
                sonLen = Math.min(sonLen, i - j + 1);
                char c1 = s.charAt(j);
                ct[str.indexOf(c1)]++;
                j++;
            }
        }
        return sonLen;
    }


}