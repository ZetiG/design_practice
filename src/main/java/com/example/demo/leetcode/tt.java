package com.example.demo.leetcode;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description:
 *
 * @author Zeti
 * @date 2024/4/12 09:38
 */
public class tt {
    public static void main(String[] args) {

    }

    public static int findChampion(int n, int[][] edges) {
        List<Integer> collect = Stream.of(edges).map(k -> k[1]).distinct().collect(Collectors.toList());
        if (n - collect.size() != 1) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (!collect.contains(i)) {
                return i;
            }
        }

        return -1;
    }

}
