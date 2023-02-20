package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntersectorTest {

    ArrayIntersector intersector;

    @BeforeEach
    public void setup() {
        intersector = new ArrayIntersector();
    }

    @Test
    public void test_insersect_success() {
        int[] array1 = new int[] {4,9,5};
        int[] array2 = new int[] {9,4,9,8,4};

        System.out.print("Original array 1: ");
        ArrayCommons.printArray(array1);

        System.out.print("\nOriginal array 2: ");
        ArrayCommons.printArray(array2);

        int[] output = intersector.intersect(array1 , array2);
        System.out.print("\nIntersect array: ");
        ArrayCommons.printArray(output);

        assertArrayEquals(new int[] {9,4}, output);
    }

    @Test
    public void test_insersect_success2() {
        int[] array1 = new int[] {1,2,2,1};
        int[] array2 = new int[] {2,2};

        System.out.print("Original array 1: ");
        ArrayCommons.printArray(array1);

        System.out.print("\nOriginal array 2: ");
        ArrayCommons.printArray(array2);

        int[] output = intersector.intersect(array1 , array2);
        System.out.print("\nIntersect array: ");
        ArrayCommons.printArray(output);

        assertArrayEquals(new int[] {2,2}, output);
    }

}