package com.arao.challenges.leetcode.easy.strings;

import com.arao.challenges.leetcode.easy.arrays.ArrayCommons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringInverterTest {

    StringInverter inverter;
    @BeforeEach
    void setUp() {
        inverter = new StringInverter();
    }

    @Test
    void test_reverseString_success() {
        char[] array = new char[] {'H','e','l','l','o'};
        char[] expected = new char[] {'o','l','l','e','H'};

        System.out.print("\nOriginal array: ");
        ArrayCommons.printArray(array);

        final var output = inverter.reverseString(array);
        System.out.print("\nReversed array: ");
        ArrayCommons.printArray(output);

        System.out.print("\nExpected output: ");
        ArrayCommons.printArray(expected);

        assertArrayEquals(expected, output);
    }
}