package com.example.demo.leetcode.iii;

/**
 * Description: 1092. 最短公共超序列
 *  给出两个字符串str1 和str2，返回同时以str1和str2作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
 * （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的任意位置），可以得到字符串 S，那么S 就是T 的子序列）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shortest-common-supersequence
 * 
 * @author Zeti
 * @date 2023/3/30 15:20
 */
public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String s1 = "abac", s2 = "cab";
        System.err.println(shortestCommonSupersequence(s1, s2));

    }

    // 输入：str1 = "abac", str2 = "cab"
    // 输出："cabac"
    // 解释：
    // str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
    // str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
    // 最终我们给出的答案是满足上述属性的最短字符串。
    // 说白了就是求两个子串合并后的最短字符串T；s1 和 s2 子序列存在于T中，子序列可不连续；
    public static String shortestCommonSupersequence(String str1, String str2) {
        // f[i+1][j+1] 表示 s 的前 i 个字母和 t 的前 j 个字母的最短公共超序列的长度
        char[] s = str1.toCharArray(), t = str2.toCharArray();
        int n = s.length, m = t.length;
        var f = new int[n + 1][m + 1];

        for (int j = 1; j < m; ++j) {
            f[0][j] = j; // 递归边界
        }

        for (int i = 1; i < n; ++i) {
            f[i][0] = i; // 递归边界
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (s[i] == t[j]) { // 最短公共超序列一定包含 s[i]
                    f[i + 1][j + 1] = f[i][j] + 1;
                } else {    // 取更短的组成答案
                    f[i + 1][j + 1] = Math.min(f[i][j + 1], f[i + 1][j]) + 1;
                }
            }
        }

        int na = f[n][m];
        var ans = new char[na];
        for (int i = n - 1, j = m - 1, k = na - 1; ; ) {
            if (i < 0) { // s 是空串，剩余的 t 就是最短公共超序列
                System.arraycopy(t, 0, ans, 0, j + 1);
                break; // 相当于递归边界
            }
            if (j < 0) { // t 是空串，剩余的 s 就是最短公共超序列
                System.arraycopy(s, 0, ans, 0, i + 1);
                break; // 相当于递归边界
            }
            if (s[i] == t[j]) { // 公共超序列一定包含 s[i]
                ans[k--] = s[i--]; // 倒着填 ans
                --j; // 相当于继续递归 makeAns(i - 1, j - 1)
            } else if (f[i + 1][j + 1] == f[i][j + 1] + 1)
                ans[k--] += s[i--]; // 相当于继续递归 makeAns(i - 1, j)
            else
                ans[k--] += t[j--]; // 相当于继续递归 makeAns(i, j - 1)
        }
        return new String(ans);
    }


}
