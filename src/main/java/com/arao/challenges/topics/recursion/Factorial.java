package com.arao.challenges.topics.recursion;

public class Factorial {

    public int calculateFactorial(int number) {
        return number == 1 ? 1 : number * calculateFactorial(number - 1);
//        if (number == 1) {
//            return 1;
//        } else {
//            return number * calculateFactorial(number - 1);
//        }
    }
}
