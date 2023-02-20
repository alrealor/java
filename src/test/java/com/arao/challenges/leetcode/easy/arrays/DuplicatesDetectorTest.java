package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicatesDetectorTest {

    DuplicatesDetector duplicateDetector;

    @BeforeEach
    public void setup() {
        duplicateDetector = new DuplicatesDetector();
    }

    @Test
    public void test_containsDuplicate_nondups_array_success() {
        int[] array = new int[] {1,2,3};

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);

        var output = duplicateDetector.containsDuplicate(array);
        System.out.print("\nContain duplicate: " + output);

        assertEquals(false, output);
    }

    @Test
    public void test_containsDuplicate_dups_array_success() {
        int[] array = new int[] {1,2,3,4,5,6,0,1};

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);

        var output = duplicateDetector.containsDuplicate(array);
        System.out.print("\nContain duplicate: " + output);

        assertEquals(true, output);
    }
}