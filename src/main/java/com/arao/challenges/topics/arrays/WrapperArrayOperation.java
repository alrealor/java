package com.arao.challenges.topics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WrapperArrayOperation {

    /**
     * Display the content of array in regular or inverted order
     * @param objectArray - Array of any Object type
     */
    public static <T> void display(T[] objectArray) {
        // display regular order
        for (int i = 0; i < objectArray.length; i++) {
            System.out.print(i != (objectArray.length-1) ? objectArray[i] + ", " : objectArray[i]);
        }
    }

    /**
     * Sort and display an object array in ascending order
     * @param objectArray - Generic object array
     */
    public static <T> T[] sortAscending(T[] objectArray) {
        Arrays.sort(objectArray);
        return objectArray;
    }


    /**
     * Sort and display an object array in ascending order
     * @param objectArray - Generic object array
     */
    public static <T> T[] sortDescending(T[] objectArray) {
        Arrays.sort(objectArray, Collections.reverseOrder());
        return objectArray;
    }

    /**
     * Find the minimum number in an unsorted array.
     * @param objArray object array
     */
    public static <T> String findMinElement(T[] objArray) {
        // sort array and get first value
        Arrays.sort(objArray);
        return objArray[0].toString();
    }

    /**
     * Find the minimum number in an unsorted array.
     * @param objArray object array
     */
    public static <T> String findMaxElement(T[] objArray) {
        // sort array and get last value
        Arrays.sort(objArray);
        return objArray[objArray.length-1].toString();
    }


    /**
     * Find how many duplicates of each number in given array exists and return result in a key-value structure
     * @param objArray - Generic input array
     * @return result of duplicates of type key - value
     */
    public static <T> Map<String, Integer> findDuplicates(T[] objArray) {
        Map<String, Integer> result = new HashMap<>();
        String prevIteration = objArray[0].toString();
        int counter = 1;
        for (int i = 1; i < objArray.length; i++) {
            if (prevIteration.equals(objArray[i].toString())) {
                // verify if result has already the duplicate value, if so just sum counter, otherwise, reset counter
                counter = result.get(objArray[i].toString()) != null ? (counter + 1) : 1;
                result.put(objArray[i].toString(), counter);
            }
            prevIteration = objArray[i].toString();
        }
        return result;
    }

    /**
     * Remove duplicates from a generic array given
     * @param objArray - Integer arrays
     * @return String array without duplicates
     */
    public static <T> String[] removeDuplicates(T[] objArray) {
        // Convert array to list and use stream.distinct to create a new list without duplicates
        List<String> strList = convertGenericArrayToStringList(objArray).stream().distinct().toList();
        // convert list to array and return
        return strList.toArray(new String[0]);
    }


    /**
     * Convert generic array given to a list of String
     * @param objArray - generic array
     * @param <T> - generic type
     * @return list of string
     */
    private static <T> List<String> convertGenericArrayToStringList(T[] objArray) {
        List<String> strList = new ArrayList<>();
        for (T t : objArray) {
            strList.add(t.toString());
        }
        return strList;
    }

}
