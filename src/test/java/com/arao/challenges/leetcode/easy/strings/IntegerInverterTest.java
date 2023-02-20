package com.arao.challenges.leetcode.easy.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerInverterTest {

    IntegerInverter integerInverter;
    @BeforeEach
    void setUp() {
        integerInverter = new IntegerInverter();
    }

    @Test
    void test_integerInverter_success() {
        final var number = -123;
        final var expected = -321;
        System.out.print("\nOriginal number: " + number);

        final var output = integerInverter.reverseInteger(number);
        System.out.print("\nReversed number: " + output);
        System.out.print("\nExpected output: " + expected);

        assertEquals(expected, output);
    }
}