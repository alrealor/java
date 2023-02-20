package com.arao.challenges.leetcode.medium.arrayandstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsBuilder {


    public List<String> getPermutations(String word) {
        char[] letters = word.toCharArray();
        return this.getPermutations(new ArrayList<String>(), letters, 0);
    }

    public List<String> getNoDuplicatedPermutations(String word) {
        char[] letters = word.toCharArray();
        return this.getNoDuplicatedPermutations(new ArrayList<String>(), letters, 0);
    }


    /**
     * Recursive function to get all permutations available
     *
     * @param array
     * @param pos
     * @return
     */
    private List<String> getPermutations(List<String> permutations, char[] array, int pos) {

        if (pos == array.length-1) {
            permutations.add(String.valueOf(array));

        } else {
            for (int i=pos; i<array.length; i++) {
                swap(array, i, pos);
                getPermutations(permutations, array, pos+1);
                swap(array, i, pos);
            }
        }
        return permutations;
    }

    /**
     * Recursive function to get all permutations available without duplicates
     *
     * @param array
     * @param pos
     * @return
     */
    private List<String> getNoDuplicatedPermutations(List<String> permutations, char[] array, int pos) {

        if (pos == array.length-1) {
            permutations.add(String.valueOf(array));

        } else {
            Set<Character> processed = new HashSet<>();
            for (int i=pos; i<array.length; i++) {
                if (processed.contains(array[i])) {
                    continue;
                }
                processed.add(array[i]);
                swap(array, i, pos);
                getNoDuplicatedPermutations(permutations, array, pos+1);
                swap(array, i, pos);
            }
        }
        return permutations;
    }

    /**
     * Swapping the array elements
     */
    private void swap(char[] a, int i, int pos) {
        char temp = a[i];
        a[i] = a[pos];
        a[pos] = temp;
    }
}
