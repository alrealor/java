package com.arao.challenges.leetcode.easy.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This method rotates an array to the right given a "K" rotation times
 * logic: Two loops.
 *  1st controlling K times of rotation saving the last element in a temporal variable to set it as first
 *  element after moving all elements one position to the right,
 *  2nd moves elements to the right starting by the end, setting nums[j] = nums[j-1]
 */
public class ArrayRotator {

    /**
     * Rotate array using collections
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] rotateUsingCollections(int[] nums, int k) {
        // transform int array to collection
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // rotate using collections API
        Collections.rotate(list, k);
        // reset original array with collection values
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Rotate array using math calcs
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] rotateUsingMathCalcs(int[] nums, int k) {
        int[] r = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            r[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = r[i];
        }
        return nums;
    }
}
