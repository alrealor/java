package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberDetectorTest {

    SingleNumberDetector detector;

    @BeforeEach
    public void setup() {
        detector = new SingleNumberDetector();
    }

    @Test
    public void test_getSingleNumber_success() {
        int[] array = new int[] {2,2,1};

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);

        var output = detector.getSingleNumber2(array);
        System.out.println("\nSingle number: " + output);

        assertEquals(1, output);
    }

    @Test
    public void test_getSingleNumber_success2() {
        int[] array = new int[] {5,4,3,2,10,2,3,4,5};

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);

        var output = detector.getSingleNumber2(array);
        System.out.println("\nSingle number: " + output);

        assertEquals(10, output);
    }

    @Test
    public void test_getSingleNumber_success1() {
        int[] array = new int[] {1};

        System.out.print("Original array: ");
        ArrayCommons.printArray(array);

        var output = detector.getSingleNumber2(array);
        System.out.println("\nSingle number: " + output);

        assertEquals(1, output);
    }
}