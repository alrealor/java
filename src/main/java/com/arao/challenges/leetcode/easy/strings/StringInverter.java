package com.arao.challenges.leetcode.easy.strings;

/**
 * Reverse String
 *
 * Solution
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
public class StringInverter {

    /**
     * Reverse array of characters
     * @param s - array of characters
     */
    public char[] reverseString(char[] s) {
        int start=0, last=s.length-1;
        char temp;
        // loop while last position is greater than start position
        while(last > start) {
            // store the element in start position them interchange elements from start positions to last position and vice-versa
            temp = s[start];
            s[start] = s[last];
            s[last] = temp;
            // update index counters for next set of positions
            start++;
            last--;
        }
        return s;
    }
}
