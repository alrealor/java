package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeBuySell2Test {

    BestTimeBuySell2 buyAndSeller;

    @BeforeEach
    public void setup() {
        buyAndSeller = new BestTimeBuySell2();
    }

    @Test
    public void test_maxProfit_success() {
        int[] array = new int[] {7,1,5,4,3,5,8,2,2,7,7,1};
        System.out.print("\nOriginal array: ");
        ArrayCommons.printArray(array);
        // calc maximum profit
        var maxProfit = buyAndSeller.maxProfit(array);
        System.out.println("\nMaximum profit: " + maxProfit);
        assertEquals(14, maxProfit);
    }

    @Test
    public void test_maxProfit_success2() {
        int[] array = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        System.out.print("\nOriginal array: ");
        ArrayCommons.printArray(array);
        // calc maximum profit
        var maxProfit = buyAndSeller.maxProfit(array);
        System.out.println("\nMaximum profit: " + maxProfit);
        assertEquals(29, maxProfit);
    }
}