package com.arao.challenges.leetcode.easy.arrays;

/**
 * Best Time to Buy and Sell Stock II
 *
 * Solution
 * You are given an integer array prices where prices[i] is the price of a given stock on the i-th day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock
 * at any time.
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */

public class BestTimeBuySell2 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // since you can buy and sell same day, the comparison will be if next day price is greater than last day
        for(int i=1; i<prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
