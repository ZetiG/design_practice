package com.example.demo.leetcode.iii;

import java.util.PriorityQueue;
import java.util.Queue;

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

    public static void main(String[] args) {
        // ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
        //[[], [1], [2], [], [3], []]
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.err.println(obj.findMedian());   // 1

        obj.addNum(2);
        System.err.println(obj.findMedian());   // 1.5

        obj.addNum(3);
        System.err.println(obj.findMedian());   // 2

    }

    // a:小根堆，存储大于中间值的后一半；b:大根堆，存储小于等于中间值前一半；
    private Queue<Integer> a, b;

    public MedianFinder() {
        a = new PriorityQueue<>(); // 小根堆，存储大于中间值的后一半
        b = new PriorityQueue<>((x, y) -> (y - x));  // 大根堆，保存较小的一半
    }

    public void addNum(int num) {
        if (a.size() != b.size()) {
            a.add(num);
            b.add(a.poll());
        } else {
            b.add(num);
            a.add(b.poll());
        }
    }

    public double findMedian() {
        return a.size() != b.size() ? a.peek() : (a.peek() + b.peek()) / 2.0;
    }


}
