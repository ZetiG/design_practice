package com.example.demo.leetcode.i;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description: 234. 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @author Zeti
 * @date 2024/3/23 11:02
 */
public class IsPalindrome {
    public static void main(String[] args) {

        ListNode l4 = new ListNode(1);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        System.err.println(isPalindrome(l1));

        ListNode l_7 = new ListNode(1);
        ListNode l_6 = new ListNode(2, l_7);
        ListNode l_5 = new ListNode(3, l_6);
        ListNode l_4 = new ListNode(4, l_5);
        ListNode l_3 = new ListNode(3, l_4);
        ListNode l_2 = new ListNode(2, l_3);
        ListNode l_1 = new ListNode(1, l_2);
        System.err.println(isPalindrome(l_1));


    }

    // LC.官方解答，处理完不恢复原链表
    // TC=O(n) SC=O(1)
    public static boolean isPalindrome(ListNode head) {
        // 利用快慢指针，找出中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转后半部分的节点
        ListNode backPre = null;
        ListNode curr = slow.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = backPre;
            backPre = curr;
            curr = next;
        }

        // 利用头结点和后半部分节点的头节点遍历对比
        ListNode l1 = head;
        ListNode l2 = backPre;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    // LC.官方解答，处理完恢复原链表
    // TC=O(n) SC=O(1)
    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }



    // 将节点存入队列，再用队列的后进先出对比原数据
    // TC=O(n) SC=O(n)
    public static boolean isPalindrome3(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();

        ListNode root = head;
        while (root != null) {
            deque.push(root.val);
            root = root.next;
        }

        for (Integer integer : deque) {
           if (head == null || head.val != integer) {
               return false;
           }
           head = head.next;
        }
        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
