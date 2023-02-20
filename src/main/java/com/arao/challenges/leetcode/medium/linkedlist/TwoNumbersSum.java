package com.arao.challenges.leetcode.medium.linkedlist;

/**
 * Add Two Numbers
 *
 * Solution
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return
 * the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */

public class TwoNumbersSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0, carry=0;
        ListNode root = new ListNode();
        ListNode temp = root;

        while(true) {
            // assign the value to the current Node
            sum = l1.val + l2.val + carry;
            if(sum > 9){
                temp.val = sum % 10;
                carry = 1;
            } else {
                temp.val = sum;
                carry = 0;
            }
            // verify if any of the two nodes has next to continue
            if (l1.next != null || l2.next != null) {
                // create new node and point out temp to this
                temp.next = new ListNode();
                temp = temp.next;
                // verify L1 node to set next or zero its value
                if (l1.next != null) {
                    l1 = l1.next;
                } else {
                    l1.val = 0;
                }
                // verify L2 node to set next or zero its value
                if (l2.next != null) {
                    l2 = l2.next;
                } else {
                    l2.val = 0;
                }

            } else {
                // no more elements in L1 or L2
                break;
            }
        }
        // add the last carried number if exists
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return root;
    }
}
