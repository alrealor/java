package com.arao.challenges.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordParserTest {

    WordParser wordParser;

    @BeforeEach
    public void setup() {
        wordParser = new WordParser();
    }

    @Test
    void test_parse_string_simple_word() {
        assertEquals("S3h", wordParser.parse("Smooth"));
    }

    @Test
    void test_parse_string_complex_text_success() {
        assertEquals("C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!"
                , wordParser.parse("Creativity is thinking-up new things. Innovation is doing new things!"));
    }

    @Test
    void test_parseFunctional_string_simple_word() {
        assertEquals("S3h",
                wordParser.parseFunctional("Smooth"));
    }

    @Test
    void test_parseFunctional_string_with_plenty_dashes_success() {
        assertEquals("C6y is t4g-up-up-u23-up n1w t4s. I6n is d3g n1w t4s!"
                , wordParser.parseFunctional("Creativity is thinking-up-up-uuuup3-up new things. Innovation is doing new things!"));
    }
}