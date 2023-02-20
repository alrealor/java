package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumupConverterTest {

    SumupConverter converter;

    @BeforeEach
    public void setup() {
        converter = new SumupConverter();
    }

    @Test
    public void test_plusOne_success() {
        int[] array = new int[] {9,9,9};

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);

        var output = converter.plusOne(array);
        System.out.print("\nArray plus one: " + output);
        ArrayCommons.printArray(output);

        assertArrayEquals(new int[] {1,0,0,0}, output);
    }

}