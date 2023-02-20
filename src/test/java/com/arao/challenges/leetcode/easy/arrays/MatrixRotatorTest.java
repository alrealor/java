package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixRotatorTest {

    MatrixRotator rotator;

    @BeforeEach
    void setUp() {
        rotator = new MatrixRotator();
    }

    @Test
    void test_rotateMatrix_success() {
        int[][] input = new int[][] {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};

        System.out.print("Original matrix: ");
        ArrayCommons.printMatrix(input);

        System.out.print("\nMatrix rotated at right: ");
        final var output = rotator.rotateMatrix(input);
        ArrayCommons.printMatrix(output);

        assertTrue(Arrays.deepEquals(new int[][] {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}}, output));
    }
}