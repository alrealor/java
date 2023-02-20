package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicatesRemoverTest {

    DuplicatesRemover remover;

    @BeforeEach
    public void setup() {
        remover = new DuplicatesRemover();
    }

    @Test
    public void test_removeDuplicates_success() {
        // array in non-decreasing order
        int[] orderedArray = new int[] {1,1,1,3,4,5,5,6,7,7,8,9,10};
        System.out.print("\nOriginal array: ");
        ArrayCommons.printArray(orderedArray);

        var output = remover.getNonDuplicatesCounter(orderedArray);
        System.out.println("Count non-duplicate elements: " + output);
        // return count of elements after remove duplicates
        assertEquals(9, output);
    }

    @Test
    public void test_removeDuplicates_using_negative_numbers_success() {
        // array in non-decreasing order
        int[] orderedArray = new int[] {-100, -1, -1, 4, 4, 4, 4, 4, 4, 10, 80, 100};
        System.out.print("\nOriginal array: ");
        ArrayCommons.printArray(orderedArray);

        var output = remover.getNonDuplicatesCounter(orderedArray);
        System.out.println("Count non-duplicate elements: " + output);
        // return count of elements after remove duplicates
        assertEquals(6, output);
    }
}