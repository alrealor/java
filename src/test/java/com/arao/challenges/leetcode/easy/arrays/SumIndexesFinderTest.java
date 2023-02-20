package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumIndexesFinderTest {
    
    SumIndexesFinder finder;
        
    @BeforeEach
    public void setup() {
        finder= new SumIndexesFinder();
    }

    /**
     * this method gets the last indexes of ccurrence in case there could be more than one possible
     * occurrences of solution indexes
     */
    @Test
    void test_findIndexesByMap_success() {
        int[] array = new int[] {1,-2,4,-4,0,4,6,740,4,20,0};
        int target = 744;

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);
        System.out.print("\nTarget: " + target);

        System.out.print("\nResult array: ");
        final var output = finder.findIndexesByMap(array, target);
        ArrayCommons.printArray(output);

        System.out.print("\nExpected output: ");
        ArrayCommons.printArray(output);

        assertArrayEquals(new int[] {5, 7}, output);
    }

    /**
     * this method gets the indexes of first occurrence in case there could be more than one possible
     * occurrences of solution indexes
     */
    @Test
    void test_findIndexesByLoop_success() {
        int[] array = new int[] {1,-2,4,-4,0,4,6,740,4,20,0};
        int target = 744;

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);
        System.out.print("\nTarget: " + target);

        System.out.print("\nResult array: ");
        final var output = finder.findIndexesByLoop(array, target);
        ArrayCommons.printArray(output);

        assertArrayEquals(new int[] {2, 7}, output);
    }
}