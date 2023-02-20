package com.arao.challenges.leetcode.easy.arrays;

import java.util.Arrays;

/**
 *  Intersection of Two Arrays II
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
 * appear as many times as it shows in both arrays and you may return the result in any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 */
public class ArrayIntersector {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);

        int iVal = -1;
        int idx = 0;
        int resultSize = nums1.length;

        // loop nums1 array
        for(int i=0; i<nums1.length; i++) {

            // verify if previous 'i' value was found to continue iterating nums2 or not
            if (iVal != nums1[i]) {

                // if 'i' value could be for intersaction. then loop nums2 array in order to verify if nums1
                // value intersect with nums2 calue and reset nums2 value to -1 for last value intercepted
                for(int j=0; j<nums2.length; j++) {

                    if (nums1[i] == nums2[j]) {
                        nums2[j] = -1;
                        idx++;
                        break;
                    }

                    // validation in order to set that 'i' value is not present in 2nd array
                    if (j == nums2.length-1) {
                        iVal = nums1[i];
                        nums1[i] = -1;
                        resultSize--;
                    }
                }

            }  else {
                // set array value to -1 for values not found for intersection in order to at the end
                // nums1 array contains only the values required out of invalid(-1) values
                nums1[i] = -1;
                resultSize--;
            }
        }

        int[] result = new int[resultSize];
        Arrays.sort(nums1);
        int loop = (nums1.length-1);
        for(int x=0; x<resultSize; x++) {
            result[x] = nums1[loop];
            loop--;
        }

        return result;
    }
}
