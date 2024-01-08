package com.example.demo.leetcode.i;

import java.util.*;

/**
 * Description: 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次
 *
 * @author Zeti
 * @date 2024/1/8 15:40
 */
public class CanConstruct {
    public static void main(String[] args) {
        String r1 = "a", m1 = "b";
        System.err.println(canConstruct(r1, m1));   // false

        String r2 = "aa", m2 = "ab";
        System.err.println(canConstruct(r2, m2));   // false

        String r3 = "aa", m3 = "aba";
        System.err.println(canConstruct(r3, m3));   // true

    }

    //
    public static boolean canConstruct(String ransomNote, String magazine) {
        // 记录index字符对应下标位置+1；作为下次indexOf起始点
        int[] count = new int[26];

        for (char r : ransomNote.toCharArray()) {
            int inx = r - 'a';
            int inx_magazine = magazine.indexOf(r, count[inx]);
            if (inx_magazine < 0) {
                return false;
            }
            count[inx] = inx_magazine + 1;
        }
        return true;
    }


    // 笨方法，遍历
    public static boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char charAt = magazine.charAt(i);
            map.put(charAt, map.getOrDefault(charAt, 0)+1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char charAt = ransomNote.charAt(i);
            Integer integer = map.get(charAt);
            if (integer == null) {
                return false;
            }

            integer--;
            if (integer == 0) {
                map.remove(charAt);
            } else {
                map.put(charAt, integer);
            }
        }
        return true;
    }

}
