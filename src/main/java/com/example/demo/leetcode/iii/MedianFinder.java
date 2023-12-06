package com.example.demo.leetcode.iii;

/**
 * Description: 295. 数据流的中位数
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 *
 * 例如 arr = [2,3,4]的中位数是 3。
 * 例如arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * MedianFinder() 初始化 MedianFinder对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差10-5以内的答案将被接受。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-median-from-data-stream
 *
 * @author Zeti
 * @date 2023/6/17 10:19
 */
public class MedianFinder {

    public MedianFinder() {

    }

    public void addNum(int num) {

    }

    public double findMedian() {
        return 0L;
    }


    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(0);
        double param_2 = obj.findMedian();
    }

}
