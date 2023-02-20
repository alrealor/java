package com.arao.challenges.leetcode.medium.arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> triple;
        List<List<Integer>> result = new ArrayList<>();
        int l=0, r=0, sum=0;

        // sort original array so that we can omit duplicates easily
        Arrays.sort(nums);

        // iterate over X element
        for(int i=0; i<=nums.length-3; i++) {
            l = i+1; // index for Y element
            r = nums.length-1; // index for Z element

            // if X element is equals to previous one then jump to the next i element
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            // iterate while Y index is lower than Z index
            while (l < r) {
                // verify that current Y element is not the same as the previous
                // l > i+1 to prevent out of index for 0-1 = -1
                if (l > i+1 && nums[l] == nums[l-1]) {
                    l++;
                    continue;
                }
                // verify that current Z element is not the same as the previous
                // r < nums.length-1 to prevent out of index for Z = nums[length+1]
                if (r < nums.length-1 && nums[r] == nums[r+1]) {
                    r--;
                    continue;
                }

                // sum X + Y + Z
                sum = nums[i] + nums[l] + nums[r];

                // validation to know what index increase or adding the triplet to the list
                if (sum < 0) {
                    l++;
                } else if (sum > 0){
                    r--;
                } else {
                    triple = new ArrayList<>();
                    triple.add(nums[i]);
                    triple.add(nums[l]);
                    triple.add(nums[r]);
                    result.add(triple);
                    l++;
                }
            }

        }
        return result;
    }
}
