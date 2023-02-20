package com.arao.challenges.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestPositiveIntCalculatorTest {

    SmallestPositiveIntCalculator arrays;

    @BeforeEach
    public void setup() {
        arrays = new SmallestPositiveIntCalculator();
    }

    @Test
    void test_solution() {
        final var input = new int[] {1, 3, 6, 4, 1, 2};
        assertEquals(5, arrays.solution(input));
    }

    @Test
    void test_solution2() {
        final var input = new int[] {1,2,3};
        assertEquals(4, arrays.solution(input));
    }

    @Test
    void test_solution3() {
        final var input = new int[] {-1, -3};
        assertEquals(1, arrays.solution(input));
    }

    @Test
    void test_solution4() {
        final var input = new int[] {1,2,3,4,5,6};
        assertEquals(7, arrays.solution(input));
    }
}