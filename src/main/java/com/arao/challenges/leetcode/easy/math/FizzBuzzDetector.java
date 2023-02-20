package com.arao.challenges.leetcode.easy.math;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 *
 *
 * Example 1:
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 *
 * Example 2:
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 *
 * Example 3:
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 * Constraints:
 * 1 <= n <= 104
 */

public class FizzBuzzDetector {

    public List<String> detectFizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i % 3 == 0 && i % 5 == 0 ?
                    "FizzBuzz" :  i % 3 == 0 ?
                        "Fizz" : i % 5 == 0 ?
                            "Buzz" : String.valueOf(i));
        }

        return list;
    }
}
