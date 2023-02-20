package com.arao.challenges.leetcode.easy.arrays;

/**
 * Remove Duplicates from Sorted Array
 *
 * Solution
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element
 * appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in
 * the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k
 * elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class DuplicatesRemover {

    /**
     * This method receives an array and reassign it removing the duplicated elements and counting how many numbers
     * are duplicated from original array
     */
    public int getNonDuplicatesCounter(int[] nums) {
        // result integer with total number of expected elements after remove duplicates
        int k = 1;
        // index for original array
        int oIndex = 0;
        // index for result array
        int rIndex = 0;
        // loop original array to look for duplicates and add non-duplicate numbers into result array
        System.out.print("\nNon-Dups array: [" + nums[0] + ",");
        for (int i=1; i < nums.length; i++) {
            // add to result array when original array previous value is not the same as array current value
            if (nums[oIndex] != nums[i]) {
                rIndex++;
                nums[rIndex] = nums[i];
                k++;
                System.out.print(i != nums.length -1 ? nums[i] + "," : nums[i]);
            }
            oIndex++;
        }
        System.out.println("]");
        return k;
    }

}
