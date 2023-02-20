package com.arao.challenges.topics.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrimitiveArrayOperation {

    /**
     * Display the content of int array
     */
    public static void display(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(i != (intArray.length-1) ? intArray[i] + ", " : intArray[i]);
        }
    }

    /**
     * Sort and return a given int array in ascending order
     * @param intArray - int array
     */
    public static int[] sortAscending(int[] intArray) {
        Arrays.sort(intArray);
        return intArray;
    }

    /**
     * Sort and return a given int array in descending order
     * @param intArray - int array
     */
    public static int[] sortDescending(int[] intArray) {
        Arrays.sort(intArray);
        int[] reverseArray = new int[intArray.length];
        int index = 0;
        for (int i=(intArray.length-1); i>=0; i--) {
            reverseArray[index] = intArray[i];
            index++;
        }
        return reverseArray;
    }

    /**
     * Find the minimum number from a given int array
     * @param intArray
     */
    public static int findMinElement(int[] intArray) {
        // sort array and get first value
        Arrays.sort(intArray);
        return intArray[0];
    }

    /**
     * Find the maximum number from a given int array
     * @param intArray
     */
    public static int findMaxElement(int[] intArray) {
        // sort array and get last value
        Arrays.sort(intArray);
        return intArray[intArray.length-1];
    }


    /**
     * Find how many duplicates of each number from a given int array and return duplicate in a map structure
     * @param intArray - int array
     * @return result of duplicates of type key - value
     */
    public static Map<String, Integer> findDuplicates(int[] intArray) {
        Map<String, Integer> result = new HashMap<>();
        int prevIteration = intArray[0];
        int counter = 1;
        for (int i = 1; i < intArray.length; i++) {
            if (prevIteration == intArray[i]) {
                // verify if result has already the duplicate value, if so just sum counter, otherwise, reset counter
                counter = result.get(intArray[i]) != null ? (counter + 1) : 1;
                result.put(String.valueOf(intArray[i]), counter);
            }
            prevIteration = intArray[i];
        }
        return result;
    }

    /**
     * Remove duplicates from a given int array and return the result array
     * @param intArray - int arrays
     * @return int array sorted ascending without duplicate values
     */
    public static int[] removeDuplicates(int[] intArray) {
        // Sort array ascending
        Arrays.sort(intArray);
        // Creates a Set to insert given array values without duplicates
        Set<Integer> nonDupList = new HashSet<Integer>();
        // Loop given array to remove duplicates into the set
        for (int i = 1; i < intArray.length; i++) {
            nonDupList.add(intArray[i]);
        }
        return nonDupList.stream().mapToInt(Integer::intValue).toArray();
    }

}
