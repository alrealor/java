package com.arao.challenges.topics.recursion;

public class FibonacciSequence {

    public int calcFibonacciSequence(int n) throws Exception {
        if (n >= 2) {
            return calcFibonacciSequence(n - 1) + calcFibonacciSequence(n - 2);
        } else {
            return n;
        }
    }
}
