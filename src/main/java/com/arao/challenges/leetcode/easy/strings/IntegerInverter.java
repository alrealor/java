package com.arao.challenges.leetcode.easy.strings;

/**
 *  Reverse Integer
 *
 * Solution
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 * Input: x = 120
 * Output: 21
 *
 * Constraints:
 * -231 <= x <= 231 - 1
 */
public class IntegerInverter {

    /**
     * Reverse number given an input integer, if input number pass the limits of integer return 0
     * Java reverse an int value - Pseudocode:
     *  1. Extract off the rightmost digit of your input number. (1234 % 10) = 4
     *  2. Take that digit (4) and add it into a new reversedNum.
     *  3. Multiply reversedNum by 10 (4 * 10) = 40, this exposes a zero to the right of your (4).
     *  4. Divide the input by 10, (removing the rightmost digit). (1234 / 10) = 123
     *  5. Repeat at step a with 123
     *
     * @param x - integer number
     * @return reversed integer
     */
    public int reverseInteger(int x) {

        long reversed = 0;
        while (x!=0) {
            // reversed = reversed * 10 + rightmost digit of the input
            reversed = (reversed * 10) + (x % 10);
            // remove the rightmost number from the input
            x = x / 10;
        }
        return reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE ? 0 : (int) reversed;
    }
}
