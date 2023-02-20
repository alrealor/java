package com.arao.challenges.topics.ciq;

import java.util.Scanner;

public class QuestionsMain {


    public static void main(String... args) {

        System.out.print("Menu: \n" +
                " 1. Write a program to swap two numbers using the third variable \n" +
                " 2. Write a program to swap two numbers WITHOUT using the third variable \n" +
                " 3. Reverse String in java \n" +
                " 4. Reverse String in Java 2 \n" +
                " 5. Classic Fibonacci series \n" +
                "Pick up an option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option) {
            case 1 -> swapNumbers();
            case 2 -> swapNumbersNoTemp();
            case 3 -> reverseString();
            case 4 -> reverseString2();
            case 5 -> classicFibonacci();
        }
    }

    // Classic Fibonacci series
    private static void classicFibonacci() {
        Scanner scan = new Scanner(System.in);
        int num, a=0, b=0, c=1;
        System.out.print("Enter number of times: ");
        num = scan.nextInt();
        System.out.println("Fibonacci of number " + num);
        for (int i=0; i<=num; i++) {
            a = b; // 0>1>1>2>3>5
            b = c; // 1>1>2>3>5>8
            c = a+b; // 1>2>3>5>8>13
            System.out.print(a + ", ");
        }
    }

    // Reverse String in Java without using String function
    private static void reverseString2() {
        String original =  "AnitaLavaLaTina";
        StringBuilder builder = new StringBuilder(original);
        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + builder.reverse().toString());
    }

    // Reverse String in java
    private static void reverseString() {
        String original = "Hello World";
        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reverseString(original));
    }

    // function that reverse a string
    public static String reverseString(String input) {
        char[] reversed = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(int i=(reversed.length-1); i>=0; i--) {
            builder.append(reversed[i]);
        }
        return builder.toString();
    }

    //2. Write a program to swap two numbers WITHOUT using the third variable
    private static void swapNumbersNoTemp() {
        int x = 100;
        int y = 200;

        System.out.println("Original values: x=" + x + ", y=" + y);
        x = x + y; // 300
        y = x - y; // 100
        x = x - y; // 200
        System.out.println("Changed values:  x=" + x + ", y=" + y);
    }

    // Write a program to swap two numbers using the third variable
    private static void swapNumbers() {
        int x = 100;
        int y = 200;
        int temp = 0;
        System.out.println("Original values: x=" + x + ", y=" + y);
        temp = x;
        x = y;
        y = temp;
        System.out.println("Changed values: x=" + x + ", y=" + y);
    }
}
