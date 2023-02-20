package com.arao.challenges.leetcode.easy.strings;

import com.arao.challenges.leetcode.easy.arrays.ArrayCommons;

import java.util.Scanner;

public class StringsMainExecutor extends ArrayCommons
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Strings Menu Options" +
                "\n 1 - Reverse String [Excercise1]" +
                "\n 2 - Reverse Integer [Excercise2]" +
                "\nChoose your menu number option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1 -> reverseString();
            case 2 -> reverseInteger();
            default -> System.out.println("Invalid option, exit");
        }
    }

    /* Reverse integer method */
    private static void reverseInteger() {
        IntegerInverter ex2 = new IntegerInverter();
        int number = -123;
        System.out.print("\nOriginal number: " + number);
        System.out.print("\nReversed number: " + ex2.reverseInteger(number));
        System.out.print("\nExpected output: " + -321);
    }

    /* Reverse string method */
    private static void reverseString() {
        StringInverter ex1 = new StringInverter();
        char[] array = new char[] {'H','e','l','l','o'};
        char[] expected = new char[] {'o','l','l','e','H'};

        System.out.print("\nOriginal array: ");
        ArrayCommons.printArray(array);

        System.out.print("\nReversed array: ");
        ArrayCommons.printArray(ex1.reverseString(array));

        System.out.print("\nExpected output: ");
        ArrayCommons.printArray(expected);
    }
}
