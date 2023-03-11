package com.example.demo.leetcode.ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 面试题 17.05.  字母与数字
 *  给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 *  返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-longest-subarray-lcci
 *
 * @author Zeti
 * @date 2023/3/11 11:24
 */
public class FindLongestSubarray {

    public static void main(String[] args) {
        String[] s1 = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        // ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
        System.err.println(Arrays.toString(Arrays.stream(findLongestSubarray(s1)).toArray()));

        String[] s2 = {"A","A"};
        // []
        System.err.println(Arrays.toString(Arrays.stream(findLongestSubarray(s2)).toArray()));

        String[] s3 = {"42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5","S","Z","D","2","A","W","k","84","44","96","96","y","M"};
        System.err.println(Arrays.toString(Arrays.stream(findLongestSubarray(s3)).toArray()));

        String[] s4 = {"A","1"};
        // ["A","1"]
        System.err.println(Arrays.toString(Arrays.stream(findLongestSubarray(s4)).toArray()));

        String[] s5 = {"C","u","49","29","o","68","k","r","E","26","24","W","F","w","13","53","C","H","V","s","13","S","l","z","U","a","50","25","f","E","7","25","o","50","e","R","36","93","77","47","M","36","84","46","82","w","L","46","54","58","73","85","18","D","m","c","46","j","U","i","P","49","49","i","N","P","h","40","o","54","47","24","7","H","100","92","6","10","66","74","47","35","O","41","Z","9","37","S","A","g","78","C","X","1","28","B","s","R","81","q"};
        // ["C","u","49","29","o","68","k","r","E","26","24","W","F","w","13","53","C","H","V","s","13","S","l","z","U","a","50","25","f","E","7","25","o","50","e","R","36","93","77","47","M","36","84","46","82","w","L","46","54","58","73","85","18","D","m","c","46","j","U","i","P","49","49","i","N","P","h","40","o","54","47","24","7","H","100","92","6","10","66","74","47","35","O","41","Z","9","37","S","A","g","78","C","X","1","28","B","s","R","81","q"]
        System.err.println(Arrays.toString(Arrays.stream(findLongestSubarray(s5)).toArray()));

        String[] s6 = {"36","86","w","17","81","W","64","97","S","s","32","61","W","I","99","X","W","l","33","L","17","G","27","70","37","5","62","W","x","39","58","16","Z","46","X","o","45","G","63","q","16","C","E","n","w","93","35","J","L","62","11","95","11","7","89","c","0","41","J","X","w","41","d","62","8","65","m","K","85","A","V","16","92","48","35","91","18","F","13","18","p","0","88","8","5","75","62","83","34","27","15","79","52","r","t","49","w","G","S","18"};
        // ["86","w","17","81","W","64","97","S","s","32","61","W","I","99","X","W","l","33","L","17","G","27","70","37","5","62","W","x","39","58","16","Z","46","X","o","45","G","63","q","16","C","E","n","w","93","35","J","L"]
        System.err.println(Arrays.toString(Arrays.stream(findLongestSubarray(s6)).toArray()));

    }

    public static String[] findLongestSubarray(String[] arr) {
        // 存储前缀和中相同值及下标
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int sum = 0;    // 前缀和临时存储值
        int left = -1;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int i1 = (byte) arr[i].charAt(0) >= 65 ? 1 : -1;
            sum += i1;  // 前缀和

            Integer firstIdx = map.putIfAbsent(sum, i);// 存储前缀和+对应下标
            if (firstIdx == null) {
                continue;
            }
            if ((i - firstIdx) > maxLen) {
                left = firstIdx + 1;
                maxLen = i - firstIdx;
            }
        }

        if (maxLen == 0) {
            return new String[0];
        }

        return Arrays.copyOfRange(arr, left, left+maxLen);
    }


}
