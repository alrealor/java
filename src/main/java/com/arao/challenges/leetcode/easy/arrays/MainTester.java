package com.arao.challenges.leetcode.easy.arrays;

import java.io.Serializable;
import java.util.Scanner;

public class MainTester implements Serializable {

    public static void main(String... args) {

        System.out.print("\nArray Menu Options" +
                "\n 1 - Remove duplicates from sorted array (Excercise1)" +
                "\n 2 - Best time to buy and sell [Excercise2]" +
                "\n 3 - Rotate array [Excercise3]" +
                "\n 4 - Contain duplicate [Excercise4]" +
                "\n 5 - Single number [Excercise5]" +
                "\n 6 - Intersection of two arrays [Excercise6]" +
                "\n 7 - Plus one [Excercise7]" +
                "\n 8 - Move Zeroes [Excercise8]" +
                "\n 9 - Two Sum [Excercise9]" +
                "\n 10 - Valid Sudoku [Excercise10]" +
                "\n 11 - Rotate image [Excercise11]" +
                "\n\nChoose your menu option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch(option) {

            default -> System.out.println("Invalid option, exit");
        }
    }




}
