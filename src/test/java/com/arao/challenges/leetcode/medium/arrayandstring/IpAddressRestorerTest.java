package com.arao.challenges.leetcode.medium.arrayandstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IpAddressRestorerTest {

    IpAddressRestorer restorer ;

    @BeforeEach
    void setUp() {
        restorer = new IpAddressRestorer();
    }

    @Test
    void test_restoreIpAddresses_success() {
        final String input = "101023";

        final var output = restorer.restoreIpAddresses(input);
        List<String> expected = Arrays.asList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3");

        assertEquals(expected, output);
    }

    @Test
    void test_restoreIpAddresses2_success() {
        final String input = "19216811";

        final var output = restorer.restoreIpAddresses2(input);
        List<String> expected = Arrays.asList("192.168.1.1", "192.16.81.1", "192.16.8.11", "192.1.68.11", "19.216.81.1"
                , "19.216.8.11", "19.21.68.11", "19.2.168.11", "1.92.168.11");

        assertEquals(expected, output);
    }
}