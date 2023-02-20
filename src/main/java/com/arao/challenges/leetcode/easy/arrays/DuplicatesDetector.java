package com.arao.challenges.leetcode.easy.arrays;

import java.util.Arrays;

public class DuplicatesDetector {

    /**
     * Returns true if array contains at least one duplicate element
     * @param nums - array of int
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
