package com.example.demo.leetcode.ii;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description: 56. 合并区间
 *  以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zeti
 * @date 2023/5/4 16:05
 */
public class MergeArray {
    public static void main(String[] args) {
        int[][] i1 = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.err.println(Arrays.deepToString(merge(i1))); // [[1,6],[8,10],[15,18]]

        int[][] i2 = {{1,4}, {4,5}};
        System.err.println(Arrays.deepToString(merge(i2))); // [[1,5]]

        int[][] i3 = {{1,4}, {2,3}};
        System.err.println(Arrays.deepToString(merge(i3))); // [[1,4]]

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int itsL = intervals[i][0], itsR = intervals[i][1];
            int[] resIts = res.get(res.size() - 1);
            if (itsL <= resIts[1] && itsR >= resIts[1]) {
                resIts[1] = itsR;
            } else if (itsL > resIts[1]) {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[0][]);
    }


}
