package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroRelocatorTest {

    ZeroRelocator relocator;

    @BeforeEach
    public void setup() {
        relocator = new ZeroRelocator();
    }

    @Test
    public void test_relocateZeroes_success() {
        int[] array = new int[] {0,4,0,1,12,3,0};

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);

        int[] output = relocator.relocateZeroes(array);
        System.out.print("\nMove zeroes result: ");
        ArrayCommons.printArray(output);

        assertArrayEquals(new int[] {4,1,12,3,0,0,0}, output);
    }
}