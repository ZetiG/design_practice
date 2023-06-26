package com.example.demo.leetcode.i;

/**
 * Description: 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author Zeti
 * @date 2023/6/26 10:59
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode h1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.err.println(reverseList2(h1));
    }

    // 输入：head = [1,2,3,4,5]  输出：[5,4,3,2,1]
    // 遍历；开辟新链表对象，遍历原链表，依次将原链表元素放入新链表对象内
    public static ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = res;
            res = curr;
            curr = next;
        }
        return res;
    }

    // 递归
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return listNode;
    }

    static class ListNode {
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
