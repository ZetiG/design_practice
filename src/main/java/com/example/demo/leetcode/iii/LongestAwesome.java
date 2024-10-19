package com.example.demo.leetcode.iii;


import com.example.demo.leetcode.i.IsPalindrome;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description: 1542. 找出最长的超赞子字符串
 *
 * 给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
 * 「超赞子字符串」需满足满足下述两个条件：
 * 该字符串是 s 的一个非空子字符串
 * 进行任意次数的字符交换后，该字符串可以变成一个回文字符串
 *
 * @author Zeti
 * @date 2024/5/20 09:21
 */
public class LongestAwesome {
    public static void main(String[] args) {
        System.err.println(longestAwesome("3242415"));   // 5
//        System.err.println(longestAwesome("12345678"));   // 1
//        System.err.println(longestAwesome("213123"));   // 6
//        System.err.println(longestAwesome("00"));   // 2
//        System.err.println(longestAwesome("234121442"));   // 7

    }

    public static int longestAwesome(String s) {
        HashMap<Integer,Integer> map=new HashMap<>();
        // 状态
        int cur=0;
        // 记录答案
        int ans=1;
        map.put(cur,-1);
        for(int c=0;c<s.length();c++){
            int ch=s.charAt(c)-'0';
            int i1 = 1 << ch;
            // 计数
            cur=cur^i1;
            // 一个数字出现奇数次，其余出现偶数次
            for(int i=0;i<10;i++){
                int i2 = 1 << i;
                int next=cur^i2;
                if(map.containsKey(next)){
                    ans=Math.max(ans,c-map.get(next));
                }
            }
            // 所有都出现了偶数次
            if(!map.containsKey(cur)){
                map.put(cur,c);
            }else{
                ans=Math.max(ans,c-map.get(cur));
            }
        }
        return ans;
    }


    /**
     * 超时方法，暴力遍历所有可能的子字符串
     */
    public static int longestAwesome2(String s) {
        int len = s.length();
        int res = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                res = Math.max(res, isPalindrome(s.substring(i,j)));
            }
        }
        return res;
    }

    private static int isPalindrome(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }

        List<Integer> count = map.values().stream().filter(ct -> ct%2!=0).collect(Collectors.toList());
        if (count.size() <= 1) {
            return str.length();
        }
        return 0;
    }

}
