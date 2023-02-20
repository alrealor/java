package com.arao.challenges.topics.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionOperations {

    /**
     * Ascending sort given an Integer collection using Comparator.naturalOrder() for specific Integer type
     * @param intList - Integer collection
     */
    public static List<Integer> sortAscendingInt(List<Integer> intList) {
        return intList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    /**
     * Ascending sort given a generic collection using Comparator.comparing method
     * @param objList - generic object collection
     */
    public static <T> List<T> sortAscendingGeneric(List<T> objList) {
        return objList.stream().sorted(Comparator.comparing(Object::toString)).collect(Collectors.toList());
    }


    /**
     * Descending sort given an Integer collection using Comparator.reverseOrder()for specific Integer type
     * @param intList - Integer collection
     */
    public static List<Integer> sortDescendingInt(List<Integer> intList) {
        return intList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    /**
     * Descending sort given a generic collection using Comparator.comparing().reversed() method
     * @param objList - generic object collection
     */
    public static <T> List<T> sortDescendingGeneric(List<T> objList) {
        return objList.stream().sorted(Comparator.comparing(Object::toString).reversed()).collect(Collectors.toList());
    }


    /**
     * Find minimum value given an Integer collection
     * @param list - integer collection
     * @return minimum integer value
     */
    public static Integer findMinimumInt(List<Integer> list) {
        return Collections.min(list);
    }

    /**
     * Find minimum value given a generic collection
     * @param list - generic object collection
     * @param <T> - generic collection type
     * @return minimum integer value
     */
    public static <T> String findMinimumGeneric(List<T> list) {
        List<T> sortList =  list.stream().sorted(Comparator.comparing(Object::toString)).toList();
        return sortList.get(0).toString();
    }


    /**
     * Find maximum value given an Integer collection
     * @param list - integer collection
     * @return maximum integer value
     */
    public static Integer findMaximumInt(List<Integer> list) {return Collections.max(list); }

    /**
     * Find maximum value given an generic collection
     * @param list - generic collection
     * @return maximum object value
     */
    public static <T> String findMaximumGeneric(List<T> list) {
       List<T> sortList = list.stream().sorted(Comparator.comparing(Object::toString)).toList();
       return sortList.get(sortList.size()-1).toString();
    }


    /**
     * find the duplicates given a collection of Integers
     * @param list - Integer list
     * @return map of value and duplicate elements
     */
    public static <T> Map<String, Integer> findDuplicatesGeneric(List<T> list) {
        // Create map for grouping array data and filter to get only duplicates
        // the following flow is for List -> Stream -> Map -> Stream -> Filter -> Map
        return list.stream()
                // Create map for grouping array data from list {1, 1, 1, 2} it creates map {1->3, 2->1}
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                // filter by duplicated map values
                .entrySet().stream().filter(m -> m.getValue() > 1)
                // collect as map
                .collect(Collectors.toMap(m -> m.getKey().toString()
                                        , m -> Integer.valueOf(m.getValue().toString())));
    }


    public static <T> List<T> removeDuplicatesGeneric(List<T> list) {
        List<T> sorted = list.stream()
                .sorted(Comparator.comparing(Object::toString))
                .toList();
        return sorted.stream().distinct().toList();
    }


}
