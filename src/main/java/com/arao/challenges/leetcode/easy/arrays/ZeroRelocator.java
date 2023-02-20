package com.arao.challenges.leetcode.easy.arrays;

/**
 * Move Zeroes
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: nums = [0,1,0,14,2]
 * Output: [1,14,2,0,0]
 */
public class ZeroRelocator {

    public int[] relocateZeroes(int[] nums) {
        int iIdx=-1;
        // look for the first zero in array and its position
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0){
                iIdx = i; // first zero position
                break;
            }
        }
        // if exists at least one zero then relocate array numbers moving non zero ones to the beginning of the array
        // after first zero found
        if (iIdx != -1) {
            for(int i=iIdx+1; i<nums.length; i++) {
                if(nums[i] != 0) {
                    nums[iIdx] = nums[i];
                    nums[i] = 0;
                    iIdx = iIdx + 1;
                }
            }
        }
        return nums;
    }
}
