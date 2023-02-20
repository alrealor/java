package com.arao.challenges.leetcode.medium.arrayandstring;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringCalculator {

    public int lengthOfLongestSubstring(String s) {
        //P W W K E W
        Set<Character> set = new LinkedHashSet<>();
        int i1=0, i2=0, max=0;

        while(i1 < s.length()) {
            if(set.contains(s.charAt(i1))) {
                set.remove(s.charAt(i2)); // -> W -> set=empty
                i2++; //1,2
            } else {
                set.add(s.charAt(i1)); //P -> PW -> W -> K
                max = Math.max((i1-i2)+1, max); //1,2,2
                i1++; //1,2,3
            }
        }
        return max;
    }
}
