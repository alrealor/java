package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayRotatorTest {

    ArrayRotator arrayRotator;

    @BeforeEach
    public void setup() {
        arrayRotator = new ArrayRotator();
    }

    @Test
    public void test_rotateUsingCollections_success() {
        int[] array = new int[] {1,2,3,4,5,6,7};
        int k = 3; //number of array rotations

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);

        System.out.print("\nArray rotated " + k + " times at right: ");
        int[] output = arrayRotator.rotateUsingCollections(array, k);
        ArrayCommons.printArray(output);

        assertArrayEquals(new int[] {5,6,7,1,2,3,4}, output);
    }

    @Test
    public void test_rotateUsingMathCalcs_success() {
        int[] array = new int[] {8,9,10,11,12,13,14,15};
        int k = 3; //number of array rotations

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);

        System.out.print("\nArray rotated " + k + " times at right: ");
        int[] output = arrayRotator.rotateUsingMathCalcs(array, k);
        ArrayCommons.printArray(output);

        assertArrayEquals(new int[] {13,14,15,8,9,10,11,12}, output);
    }
}
