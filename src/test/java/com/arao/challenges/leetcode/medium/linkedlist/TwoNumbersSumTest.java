package com.arao.challenges.leetcode.medium.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoNumbersSumTest {

    TwoNumbersSum operator;
    @BeforeEach
    void setUp() {
        operator = new TwoNumbersSum();
    }

    @Test
    void tes_addTwoNumbers_success() {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,  new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.print("L1 = ");
        LinkedListUtils.printListNode(l1);
        System.out.println("");
        System.out.print("L2 = ");
        LinkedListUtils.printListNode(l2);
        System.out.println("");
        final var output = operator.addTwoNumbers(l1, l2);

        System.out.println("Expected output = [8,9,9,9,0,0,0,1]");

        System.out.print("Result output   = ");
        LinkedListUtils.printListNode(output);

        assertEquals(
                new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(1)))))).toString()
                , output.toString());
    }

    @Test
    void tes_addTwoNumbers_success2() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.print("L1 = ");
        LinkedListUtils.printListNode(l1);
        System.out.println("");
        System.out.print("L2 = ");
        LinkedListUtils.printListNode(l2);
        System.out.println("");
        final var output = operator.addTwoNumbers(l1, l2);

        System.out.println("Expected output = [7,0,8]");
        int[] s = new int[] {1,2,3,10,5,2,8,1};
        System.out.println(Arrays.binarySearch(s, 10));

        System.out.print("Result output   = ");
        LinkedListUtils.printListNode(output);

        assertEquals(
                new ListNode(7, new ListNode(0, new ListNode(8))).toString()
                , output.toString());
    }
}