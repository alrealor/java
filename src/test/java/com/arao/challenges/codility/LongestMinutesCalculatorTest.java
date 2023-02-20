package com.arao.challenges.codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LongestMinutesCalculatorTest {

    LongestMinutesCalculator minutesToSleep;

    @BeforeEach
    public void setup() {
        minutesToSleep = new LongestMinutesCalculator();
    }

    @Test
    void test_solution_13_elements_success() {
        final var input =
            "Sun 10:00-20:00\n" +
            "Fri 05:00-10:00\n" +
            "Fri 16:30-23:50\n" +
            "Sat 10:00-24:00\n" +
            "Sun 01:00-04:00\n" +
            "Sat 02:00-06:00\n" +
            "Tue 03:30-18:15\n" +
            "Tue 19:00-20:00\n" +
            "Wed 04:25-15:14\n" +
            "Wed 15:14-22:40\n" +
            "Thu 00:00-23:59\n" +
            "Mon 05:00-13:00\n" +
            "Mon 15:00-21:00\n";
        int output = 0;
        try {
            output = minutesToSleep.solution(input);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals(505, output);
    }

    @Test
    void test_solution_7_elements_success() {
        final var input =
            "Mon 01:00-23:00\n" +
            "Tue 01:00-23:00\n" +
            "Wed 01:00-23:00\n" +
            "Thu 01:00-23:00\n" +
            "Fri 01:00-23:00\n" +
            "Sat 01:00-23:00\n" +
            "Sun 01:00-21:00\n";
        int output = 0;
        try {
            output = minutesToSleep.solution(input);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals(180, output);
    }

    @Test
    void test_solution_minutes_from_wed_to_sun_success(){
        final var input =
                "Mon 01:00-23:00\n" +
                "Wed 13:00-13:15\n" +
                "Wed 13:15-14:00\n" +
                "Sun 13:15-14:00\n";
        int output = 0;
        try {
            output = minutesToSleep.solution(input);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals(5715, output);
    }

    @Test
    void test_solution_same_time_same_day_throw_exception(){
        final var input =
                "Mon 01:00-23:00\n" +
                "Wed 13:00-13:15\n" +
                "Wed 13:15-14:00\n" +
                "Wed 13:15-14:00\n" +
                "Sun 13:15-14:00\n";
        final var ex = assertThrows(Exception.class, () -> minutesToSleep.solution(input));
        assertEquals("There are two meetings with the same start time Wed 13:15-14:00", ex.getMessage());
    }

   @Test
    void test_solution_same_init_and_end_time_throw_exception() {
        final var input =
                "Mon 01:00-02:00\n" +
                "Tue 02:00-02:00\n";
        final var ex = assertThrows(Exception.class, () -> minutesToSleep.solution(input));
        assertEquals("start and end time is the same for Tue 02:00-02:00", ex.getMessage());
    }

}
