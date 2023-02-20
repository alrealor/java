package com.arao.challenges.leetcode.medium.linkedlist;

public class LinkedListUtils {

    static void printListNode(ListNode list) {
        System.out.print("[");
        while(true) {
            System.out.print(list.next != null ? list.val + "," : list.val);
            if (list.next == null) {
                break;
            } else {
                list = list.next;
            }
        }
        System.out.print("]");
    }
}
