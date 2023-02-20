package com.arao.challenges.leetcode.medium.arrayandstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsBuilderTest {

    PermutationsBuilder permutationBuilder;

    @BeforeEach
    void setUp() {
        permutationBuilder = new PermutationsBuilder();
    }

    @Test
    void test_getPermutations_3LengthWord_success() {
        String input = "ABC";
        List<String> output = permutationBuilder.getPermutations(input);
        List<String> expected = Arrays.asList("ABC", "ACB", "BAC", "BCA", "CBA", "CAB");
        assertEquals(expected, output);
    }

    @Test
    void test_getNoDuplicatedPermutations_4LengthWord_1DuplicatedLetter_success() {
        String input = "ABCA";
        List<String> output = permutationBuilder.getNoDuplicatedPermutations(input);
        List<String> expected = Arrays.asList("ABCA", "ABAC", "ACBA", "ACAB", "AACB", "AABC", "BACA", "BAAC", "BCAA"
                , "CBAA", "CABA", "CAAB");
        assertEquals(expected, output);
    }
}