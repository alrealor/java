package com.arao.challenges.leetcode.medium.arrayandstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    ThreeSum sum ;

    @BeforeEach
    void setUp() {
        sum = new ThreeSum();
    }

    //TODO - fix test method
    @Test
    void test_threeSum_success() {
        int[] array = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println("Expected result: [-1, 0, 1][-1, -1, 2]");
        System.out.print("Output: ");
        sum.threeSum(array).forEach(System.out::print);
    }
}