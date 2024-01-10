package com.example.demo.leetcode.i;

/**
 * Description: 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author Zeti
 * @date 2024/1/10 15:46
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode ln3 = new ListNode(4);
        ListNode ln2 = new ListNode(2, ln3);
        ListNode ln1 = new ListNode(1, ln2);

        ListNode ln_3 = new ListNode(4);
        ListNode ln_2 = new ListNode(3, ln_3);
        ListNode ln_1 = new ListNode(1, ln_2);

        System.err.println(mergeTwoLists(ln1, ln_1)); // [1,1,2,3,4,4]

        ListNode ln21 = new ListNode();
        ListNode ln2_1 = new ListNode();
        System.err.println(mergeTwoLists(ln21, ln2_1)); // []

        ListNode ln31 = new ListNode();
        ListNode ln3_1 = new ListNode(0);
        System.err.println(mergeTwoLists(ln31, ln3_1)); // [0]

    }

    // 递归
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }

    static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


