package com.arao.challenges.topics.arrays;

import java.util.Scanner;

public class ArrayOperatorMain {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Menu Options " +
                "\n 1. Primitive array operations " +
                "\n 2. Wrapper array operations " +
                "\n 3. 2D array (Matrix) operations" +
                "\n");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1: // Operations over primitive arrays
                operatePrimitiveArrays();
                break;
            case 2: // Operations over wrapper arrays
                operateWrapperArrays();
                break;
            case 3: // Operations over wrapper arrays
                operateMatrix();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    /**
     * Method encharged of matrix operations
     */
    private static void operateMatrix() {
        try {
            // Create 2D array
            System.out.println("\n# Create 2D array");
            int[][] matrix = MatrixOperation.createMatrix();

            // Populate 2D array
            System.out.println("\n# Populate 2D array");
            MatrixOperation.populateMatrix(matrix);

            // Print given 2D array
            System.out.println("\n# Print given 2D array:");
            MatrixOperation.printMatrix(matrix);

            // Convert 2D array into 1D array given 1D array length
            System.out.println("\n# Convert current 2D array to a new one");
            MatrixOperation.printMatrix(MatrixOperation.convertMatrix(matrix));

        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    /**
     * Operations over primitive arrays
     */
    private static void operatePrimitiveArrays() {
        System.out.println("\n----------------------------------- PRIMITIVE ARRAY OPERATIONS -----------------------------------");

        // Integer Original wrapper array
        int[] intArray = new int[] {1,2,3,4,5,1,2,3,4,5,10};

        // ----------------------------------------- INTEGER ARRAY -----------------------------------------
        // Display original Integer array
        System.out.println("Original int array: ");
        PrimitiveArrayOperation.display(intArray);

        // Display Integer array in ascending order
        System.out.println("\nAscending sort: ");
        PrimitiveArrayOperation.display(PrimitiveArrayOperation.sortAscending(intArray));

        // Display arrays in descending order
        System.out.println("\nDescending sort: ");
        PrimitiveArrayOperation.display(PrimitiveArrayOperation.sortDescending(intArray));

        // Display min and max values of Integer array
        System.out.println("\nMin - Max: ");
        System.out.print(PrimitiveArrayOperation.findMinElement(intArray) + " - " + PrimitiveArrayOperation.findMaxElement(intArray));

        // Show duplicates for Integer array if exists
        System.out.println("\nDuplicates: ");
        PrimitiveArrayOperation.findDuplicates(intArray).entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        // Remove duplicates for Integer array
        System.out.println("Remove duplicates: ");
        PrimitiveArrayOperation.display(PrimitiveArrayOperation.removeDuplicates(intArray));
    }



    /**
     * Operations over wrapper arrays
     */
    private static void operateWrapperArrays() {
        System.out.println("\n----------------------------------- WRAPPER ARRAY OPERATIONS -----------------------------------");

        // Integer Original wrapper array
        Integer[] integerArray = new Integer[] {3, 12, 8, 67, 4, 3, 8, 8, 8, 3, 67};
        String[] stringArray = new String[] {"wake", "me", "up", "before", "you", "go", "go"};
        Character[] characterArray = new Character[] {'a', 'x', 'f', 'z', 'm', 'f', 'a'};

        // ----------------------------------------- INTEGER ARRAY -----------------------------------------
        // Display original Integer array
        System.out.println("Original Integer array: ");
        WrapperArrayOperation.display(integerArray);

        // Display Integer array in ascending order
        System.out.println("\nAscending sort: ");
        WrapperArrayOperation.display(WrapperArrayOperation.sortAscending(integerArray));

        // Display arrays in descending order
        System.out.println("\nDescending sort: ");
        WrapperArrayOperation.display(WrapperArrayOperation.sortDescending(integerArray));

        // Display min and max values of Integer array
        System.out.println("\nMin - Max: ");
        System.out.print(WrapperArrayOperation.findMinElement(integerArray) + " - " + WrapperArrayOperation.findMaxElement(integerArray));

        // Show duplicates for Integer array if exists
        System.out.println("\nDuplicates: ");
        WrapperArrayOperation.findDuplicates(integerArray).entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        // Remove duplicates for Integer array
        System.out.println("Remove duplicates: ");
        WrapperArrayOperation.display(WrapperArrayOperation.removeDuplicates(integerArray));

        System.out.println("\n");

        // ----------------------------------------- STRING ARRAY -----------------------------------------

        // Display original String array
        System.out.println("Original String array: ");
        WrapperArrayOperation.display(stringArray);

        // Display String array in ascending order
        System.out.println("\nAscending sort: ");
        WrapperArrayOperation.display(WrapperArrayOperation.sortAscending(stringArray));

        // Display arrays in descending order
        System.out.println("\nDescending sort: ");
        WrapperArrayOperation.display(WrapperArrayOperation.sortDescending(stringArray));

        // Display min and max values of Integer array
        System.out.println("\nMin - Max: ");
        System.out.print(WrapperArrayOperation.findMinElement(stringArray) + " - " + WrapperArrayOperation.findMaxElement(stringArray));

        // Show duplicates for Integer array if exists
        System.out.println("\nDuplicates: ");
        WrapperArrayOperation.findDuplicates(stringArray).entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        // Remove duplicates for Integer array
        System.out.println("Remove duplicates: ");
        WrapperArrayOperation.display(WrapperArrayOperation.removeDuplicates(stringArray));

        System.out.println("\n");

        // ----------------------------------------- CHARACTER ARRAY -----------------------------------------

        // Display original String array
        System.out.println("Original Character array: ");
        WrapperArrayOperation.display(characterArray);

        // Display String array in ascending order
        System.out.println("\nAscending sort: ");
        WrapperArrayOperation.display(WrapperArrayOperation.sortAscending(characterArray));

        // Display arrays in descending order
        System.out.println("\nDescending sort: ");
        WrapperArrayOperation.display(WrapperArrayOperation.sortDescending(characterArray));

        // Display min and max values of Integer array
        System.out.println("\nMin - Max: ");
        System.out.print(WrapperArrayOperation.findMinElement(characterArray) + " - " + WrapperArrayOperation.findMaxElement(characterArray));

        // Show duplicates for Integer array if exists
        System.out.println("\nDuplicates: ");
        WrapperArrayOperation.findDuplicates(characterArray).entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        // Remove duplicates for Integer array
        System.out.println("Remove duplicates: ");
        WrapperArrayOperation.display(WrapperArrayOperation.removeDuplicates(characterArray));
    }
}
