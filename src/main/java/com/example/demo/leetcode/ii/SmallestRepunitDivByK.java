package com.example.demo.leetcode.ii;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1015. 可被 K 整除的最小整数 
 * 给定正整数 k，你需要找出可以被 k整除的、仅包含数字 1 的最 小 正整数 n的长度。
 * 返回 n的长度。如果不存在这样的 n，就返回-1。
 * 注意： n不符合 64 位带符号整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/smallest-integer-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/5/10 10:56
 */
public class SmallestRepunitDivByK {
    public static void main(String[] args) {
        int k1 = 1;
        System.err.println(smallestRepunitDivByK(k1)); // 1

        int k2 = 2;
        System.err.println(smallestRepunitDivByK(k2)); // -1

        int k3 = 3;
        System.err.println(smallestRepunitDivByK(k3)); // 3

        int k4 = 17;
        System.err.println(smallestRepunitDivByK(k4)); // 16

    }

    // ((a%m)+(b%m))%m = (a+b)%m
    // ((a%m)*(b%m))%m = (a*b)%m
    // 模运算
    public static int smallestRepunitDivByK(int k) {
        // 如果k能被2/5整除，则一定不能被n整除
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int n = 1 % k, len = 1;
        while (n != 0) {
            n = (n * 10 + 1) % k;
            len++;
        }
        return len;
    }


    // hash表缓存余数，当余数已经存在时，代表进入循环，则不可能被整除
    public static int smallestRepunitDivByK2(int k) {
        int n = 1 % k;
        int len = 1;
        Set<Integer> set = new HashSet<>();
        while (n != 0) {
            // 余数重复出现代表不可能被整除
            if (set.contains(n)) {
                return -1;
            }
            set.add(n % k);
            n = (n * 10 + 1) % k;
            len++;
        }
        return len;
    }

}
