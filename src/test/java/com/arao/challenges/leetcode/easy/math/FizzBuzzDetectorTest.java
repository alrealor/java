package com.arao.challenges.leetcode.easy.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzDetectorTest {

    FizzBuzzDetector fizzBuzzDetector;

    @BeforeEach
    void setUp() {
        fizzBuzzDetector = new FizzBuzzDetector();
    }

    @Test
    void test_detectFizzBuzz_success() {
        List<String> expected = asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        assertEquals(expected, fizzBuzzDetector.detectFizzBuzz(15));
    }
}