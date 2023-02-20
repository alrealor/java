package com.arao.challenges.topics.recursion;

import java.util.Scanner;

public class RecursionTester {

    public static void main(String... args) {

        Scanner menu = new Scanner(System.in);
        System.out.println("Choose from menu: \n1. Calculate factorial \n2. Show Fibonacci sequence");
        System.out.print("Type your option number: ");
        int select = menu.nextInt();

        switch(select) {
            case 1: calculateFactorial(); break;
            case 2: showFibonacciSequence(); break;
            default: System.out.println("Error: Invalid menu selection");
        }
    }

    /**
     * Show Fibonacci sequence until a given level
     */
    private static void showFibonacciSequence() {
        // Calculate Fibonacci sequence of a given number
        FibonacciSequence sequence = new FibonacciSequence();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter number level for seeing its Fibonacci sequence: ");
        int n = scanner.nextInt();
        try {
            if (n < 0) {
                throw new Exception("Error: Invalid number to show Fibonacci sequence");
            }
            for (int i=0; i<=n; i++) {
                System.out.print(sequence.calcFibonacciSequence(i) + ", ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Calculate factorial given a number
     */
    private static void calculateFactorial() {
        // Calculate the factorial of a given number
        Factorial numFactorial = new Factorial();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter integer number for seeing its factorial: ");
        int n= scanner.nextInt();
        System.out.println("Factorial of " + n + " = " + numFactorial.calculateFactorial(n));
    }
}
