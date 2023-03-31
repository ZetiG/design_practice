package com.example.demo.leetcode.ii;

/**
 * Description: 2. 两数相加
 *  给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *  请你将两个数相加，并以相同形式返回一个表示和的链表。
 *  你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 *
 * @author Zeti
 * @date 2023/3/31 14:41
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode ln11 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode ln12 = new ListNode(5, new ListNode(6, new ListNode(4)));
        // [7,0,8]
        ListNode listNode1 = addTwoNumbers(ln11, ln12);
        System.err.println(listNode1);

        ListNode ln13 = new ListNode(0);
        ListNode ln14 = new ListNode(0);
        // [0]
        ListNode listNode2 = addTwoNumbers(ln13, ln14);
        System.err.println(listNode2);

        ListNode ln15 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode ln16 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        // [8,9,9,9,0,0,0,1]
        ListNode listNode3 = addTwoNumbers(ln15, ln16);
        System.err.println(listNode3);


    }

    // 暴力循环，缓存进位
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cache = (l1.val + l2.val) / 10;
        ListNode minNode = new ListNode((l1.val + l2.val) % 10);
        if (l1.next == null && l2.next == null) {
            if (cache > 0) {
                minNode.next = new ListNode(cache);
            }
            return minNode;
        }
        l1 = l1.next;
        l2 = l2.next;

        ListNode ln = minNode;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            ListNode listNode = new ListNode((v1 + v2 + cache) % 10);
            ln.next = listNode;
            ln = listNode;

            cache = (v1 + v2 + cache) / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (l1 == null && l2 == null && cache > 0) {
                ln.next = new ListNode(cache);
                return minNode;
            }
        }
        return minNode;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
