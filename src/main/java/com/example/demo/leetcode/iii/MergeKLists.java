package com.example.demo.leetcode.iii;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: 23. 合并 K 个升序链表
 *  给你一个链表数组，每个链表都已经按升序排列。
 *  请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @author Zeti
 * @date 2024/10/21 14:39
 */
public class MergeKLists {
    public static void main(String[] args) {
        // lists = [[1,4,5],[1,3,4],[2,6]]
        // [1,1,2,3,4,4,5,6]
        ListNode ls1_5 = new ListNode(5);
        ListNode ls1_4 = new ListNode(4, ls1_5);
        ListNode ls1_1 = new ListNode(1, ls1_4);

        ListNode ls2_4 = new ListNode(4);
        ListNode ls2_3 = new ListNode(3, ls2_4);
        ListNode ls2_1 = new ListNode(1, ls2_3);

        ListNode ls3_6 = new ListNode(6);
        ListNode ls3_2 = new ListNode(2, ls3_6);

        ListNode[] l1 = {ls1_1, ls2_1, ls3_2};
        mergeKLists(l1);
        System.err.println("");

        // lists = []
        // []
        ListNode[] l2 = {};
        mergeKLists(l2);
        System.err.println("");

        // lists = [[]]
        // []
        ListNode ls1_0 = null;
        ListNode[] l3 = {ls1_0};
        mergeKLists(l3);
        System.err.println("");

        // [[-2,-1,-1,-1],[]]
        // [-2,-1,-1,-1]
        ListNode ls4_1_4 = new ListNode(-2);
        ListNode ls4_1_3 = new ListNode(-1, ls4_1_4);
        ListNode ls4_1_2 = new ListNode(-1, ls4_1_3);
        ListNode ls4_1_1 = new ListNode(-1, ls4_1_2);
        ListNode ls4_2_0 = null;
        ListNode[] l4 = {ls4_1_1, ls4_2_0};
        mergeKLists(l4);
        System.err.println("");

    }

    // 小根堆(优先级队列)
    // [[1,4,5],[1,3,4],[2,6]]
    // [1,1,2,3,4,4,5,6]
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        // 加入整个链表，因为每个链表本身就是有序的，取出节点处理后，再将该节点的下个节点列表存入队列
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode res = new ListNode();
        ListNode curr = res;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            System.err.print(node.val + " ");

            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return res.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}