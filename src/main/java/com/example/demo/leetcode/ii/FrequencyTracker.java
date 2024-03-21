package com.example.demo.leetcode.ii;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 2671. 频率跟踪器
 * 请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。
 *
 * 实现 FrequencyTracker 类：
 *      FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。
 *      void add(int number)：添加一个 number 到数据结构中。
 *      void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内容。
 *      bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 false。
 *
 * @author Zeti
 * @date 2024/3/21 09:16
 */
public class FrequencyTracker {
    // 主要考察性能问题，使用双哈希表优化查询性能
    public static void main(String[] args) {
        FrequencyTracker ft = new FrequencyTracker();
        ft.hasFrequency(1);
        ft.add(3);
        ft.add(1);
        ft.hasFrequency(1);
        ft.add(3);
        ft.hasFrequency(2);
        ft.add(1);
        ft.hasFrequency(2);
        ft.deleteOne(10);
        ft.hasFrequency(2);
        ft.deleteOne(6);
        ft.add(7);
        ft.deleteOne(10);
        ft.hasFrequency(2);
        ft.hasFrequency(1);
        ft.add(1);
        ft.add(2);
        ft.add(3);
        ft.hasFrequency(1);
        ft.deleteOne(3);
        System.err.println(ft.hasFrequency(2));
        System.err.println(ft.hasFrequency(3));

        FrequencyTracker ft2 = new FrequencyTracker();
        ft2.add(1);
        ft2.deleteOne(1);
        ft2.hasFrequency(1);

    }

        private Map<Integer, Integer> map;
        private Map<Integer, Integer> cnt;

        public FrequencyTracker() {
            map = new HashMap<>();
            cnt = new HashMap<>();
        }

        public void add(int number) {
            int i = map.getOrDefault(number, 0) + 1;
            map.put(number, i);
            cnt.put(i, cnt.getOrDefault(i,0)+1);
            if (i-1>0 && cnt.get(i-1) > 0) {
                if (cnt.get(i-1)-1 <= 0) {
                    cnt.remove(i-1);
                } else {
                    cnt.put(i-1, cnt.getOrDefault(i-1,0)-1);
                }
            }
        }

        public void deleteOne(int number) {
            Integer orDefault = map.getOrDefault(number, 0)-1;
            if (orDefault <= 0) {
                map.remove(number);
            } else {
                map.put(number, orDefault);
            }

            if (orDefault >= 0) {
                if (orDefault > 0) {
                    cnt.put(orDefault, cnt.getOrDefault(orDefault, 0)+1);
                }

                if (cnt.get(orDefault+1) <= 1) {
                    cnt.remove(orDefault+1);
                } else {
                    cnt.put(orDefault+1, cnt.getOrDefault(orDefault+1,0)-1);
                }
            }

        }

        public boolean hasFrequency(int frequency) {
            return cnt.containsKey(frequency);
        }


}
