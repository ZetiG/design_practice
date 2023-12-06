package com.example.demo.leetcode.iii;

/**
 * Description: 1326. 灌溉花园的最少水龙头数目
 *  在 x 轴上有一个一维的花园。花园长度为n，从点0开始，到点n结束。
 *  花园里总共有n + 1 个水龙头，分别位于[0, 1, ..., n] 。
 *  给你一个整数n和一个长度为n + 1 的整数数组ranges，其中ranges[i] （下标从 0 开始）表示：如果打开点i处的水龙头，
 *  可以灌溉的区域为[i - ranges[i], i + ranges[i]]。
 *  请你返回可以灌溉整个花园的最少水龙头数目。如果花园始终存在无法灌溉到的地方，请你返回-1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden
 *
 * @author Zeti
 * @date 2023/2/21 11:54
 */
public class MinTaps {

    public static void main(String[] args) {
        int n = 5;
        int[] ranges = {3,4,1,2,0,0};
        System.err.println(minTaps2(n, ranges));


    }

    public static int minTapsn(int n, int[] ranges) {

        int[] ints = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {

            // 每个水龙头覆盖的起始点，小于0则取0，大于n则取n
            int l = Math.max(i - ranges[i], 0);
            int r = Math.min(i + ranges[i], n);

            System.err.println(l + " - " + r);

            // 每个水龙头覆盖的最远距离
            ints[i] = Math.max(l, r);


        }

        // [3, 5, 3, 5, 4, 5]


        return 0;
    }



    //                      n = 5
    //                      3,  4,  1,  2,  0,  0
    //          ------------|------------
    //          ------------|---|----------------
    //                      |   |---|----
    //                      |   --------|--------
    //                      |   |   |   |   -
    //                      |   |   |   |   |   -
    // -5  -4  -3  -2  -1   0   1   2   3   4   5
    //                      ---------------------

    public static int minTaps(int n, int[] ranges) {
        int[] rightMost = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            rightMost[i] = i;
        }
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            rightMost[start] = Math.max(rightMost[start], end);
        }
        int last = 0, ret = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            last = Math.max(last, rightMost[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }


    public static int minTaps2(int n, int[] ranges) {
        int[] land = new int[n];
        for (int i = 0; i < ranges.length; i++) {
            int l = Math.max(i - ranges[i], 0);
            int r = Math.max(i + ranges[i], n);

            for (int j = l; j < r; j++) {
                land[j] = Math.max(land[j], r);
            }
        }

        int cnt = 0;
        int cur = 0;
        while (cur < n) {
            if (land[cur] == 0)
                return -1;
            cur = land[cur];
            cnt++;
        }
        return cnt;
    }


    public static int minTaps3(int n, int[] ranges) {
        int[] rightMost = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            int r = ranges[i];
            // 这样写可以在 i>r 时少写一个 max
            // 凭借这个优化，恭喜你超越了 100% 的用户
            // 说「超越」是因为原来的最快是 2ms，现在优化后是 1ms
            if (i > r) rightMost[i - r] = i + r; // 对于 i-r 来说，i+r 必然是它目前的最大值
            else rightMost[0] = Math.max(rightMost[0], i + r);
        }

        int ans = 0;
        int curRight = 0; // 已建造的桥的右端点
        int nextRight = 0; // 下一座桥的右端点的最大值
        for (int i = 0; i < n; ++i) { // 注意这里没有遍历到 n，因为它已经是终点了
            nextRight = Math.max(nextRight, rightMost[i]);
            if (i == curRight) { // 到达已建造的桥的右端点
                if (i == nextRight) return -1; // 无论怎么造桥，都无法从 i 到 i+1
                curRight = nextRight; // 造一座桥
                ++ans;
            }
        }
        return ans;
    }

}
