package com.example.demo.leetcode.ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description: 93. 复原 IP 地址
 *
 *  有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *  例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *  给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。
 *  你不能重新排序或删除 s 中的任何数字。你可以按任何顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 *
 * @author Zeti
 * @date 2023/3/23 10:17
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        String s1 = "25525511135";  // ["255.255.11.135","255.255.111.35"]
        System.err.println(restoreIpAddresses2(s1));

        String s2 = "0000";  // ["0.0.0.0"]
        System.err.println(restoreIpAddresses2(s2));

        String s3 = "101023";  // ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
        System.err.println(restoreIpAddresses2(s3));

    }


// --------------------------------------- <回溯剪枝> ----------------------------------------------------------------

    //画图理解
    public static List<String> restoreIpAddresses2(String s) {
        //定义表示一个字符长度的变量
        int len = s.length();
        //定义一个返回结果的集合
        List<String> res = new ArrayList<>();
        //如果当前字符长度大于12或者小于4都不满足
        if(len > 12 || len <4){
            return res;
        }
        //定义一个保存路径上的变量
        Deque<String> path = new ArrayDeque<>();
        //深度优先搜索
        dfs(s,0, 4, path, res);
        //返回结果
        return res;
    }

    public static void dfs(String s, int begin, int residue, Deque<String> path, List<String> res){
        //如果字符串已经遍历到最后了，并且已经切分为4段了，
        //就把当前路径上的元素加入到返回的结果集中
        if(begin == s.length()) {
            if(residue == 0){
                res.add(String.join(".", path));
            }
            return;
        }
        //begin表示遍历字符串从哪里开始
        for(int i = begin; i < begin+3; i++){
            //如果超出字符串的长度，就直接退出
            //begin，每次选择都是从之前选择的元素的下一个元素开始，
            if(i >= s.length()){
                return;
            }
            //如果剩余元素大于ip最多能容纳的个数，就剪枝。 25 525 511 135
            int i2 = (residue - 1) * 3;
            int i1 = (s.length() - 1) - i;
            if(i2 < i1){
                continue;
            }
            //判断当前截取字符是否是小于0或者大于255
            //这里的begin和i，代表的是，这时候截取了几个字符
            //begin从哪里开始，i到哪里结束
            if(judgeIpSegment(s, begin, i)){
                //保留当前截取字符
                String currentIpSegment = s.substring(begin, i+1);
                //将当前路径上的元素加入到路径队列中
                path.addLast(currentIpSegment);
                //递归下一层
                dfs(s, i+1,residue-1, path, res);
                //剪枝
                path.removeLast();
            }
        }
    }
    private static boolean judgeIpSegment(String s, int left, int right){
        //如果截取的大于等于2的字符的开头为0，就直接false
        if((right - left + 1) > 1 && s.charAt(left) == '0'){
            return false;
        }
        //定义返回结果的集合
        int res = 0;
        //拼接字符
        while(left <= right){
            //res*10 是为了将先加的字符默认比后面的字符大10倍，也就是位数是从小到大
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }


// --------------------------------------- <官解，回溯> ----------------------------------------------------------------

    static final int SEG_COUNT = 4;
    static List<String> ans = new ArrayList<>();
    static int[] segments = new int[SEG_COUNT];

    public static List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public static void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {    // 0xff = 255
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

}
