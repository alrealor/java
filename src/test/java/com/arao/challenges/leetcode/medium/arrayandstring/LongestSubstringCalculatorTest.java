package com.arao.challenges.leetcode.medium.arrayandstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringCalculatorTest {

    LongestSubstringCalculator calculator ;

    @BeforeEach
    void setUp() {
        calculator = new LongestSubstringCalculator();
    }

    //TODO - fix test method
    @Test
    void test_methodName_success() {
        String test = "PWWKEW";
        System.out.println("");
        System.out.println("Expected result: 3");
        System.out.println("Output: " + calculator.lengthOfLongestSubstring(test));
    }
}