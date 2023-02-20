package com.arao.challenges.topics.strings;

import com.arao.challenges.codility.PyramidBuilder;
import org.junit.jupiter.api.Test;

class PyramidBuilderTest {

    @Test
    void test_build_pyramid_1_level() {
        PyramidBuilder.printPyramid(1);
    }

    @Test
    void test_build_pyramid_2_level() {
        PyramidBuilder.printPyramid(2);
    }

    @Test
    void test_build_pyramid_3_level() {
        PyramidBuilder.printPyramid(3);
    }

    @Test
    void test_build_pyramid_5_level() {
        PyramidBuilder.printPyramid(5);
    }

    @Test
    void test_build_pyramid_10_level() {
        PyramidBuilder.printPyramid(10);
    }
}