package com.arao.challenges.leetcode.medium.arrayandstring;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//import java.util.Set;
//import com.google.common.collect;

/**
 * @author Alan Altamirano
 *
 * Restore IP Address
 *
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 *
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 *
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 *
 * Example 3:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * Constraints:
 * 1 <= s.length <= 20
 * s consists of digits only. *
 */
public class IpAddressRestorer {

    /**
     * Brute force approach
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    //System.out.println(s1 + "." + s2 + "." + s3 + "." + s4);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    /**
     * Calculate positions first the get substring and validate force approach
     */
    public List<String> restoreIpAddresses2(String s) {
        List<String> ips = new ArrayList<>();
        for(int a=3; a>=1; a--) {
            for(int b=3; b>=1; b--) {
                for(int c=3; c>=1; c--) {
                    for(int d=3; d>=1; d--) {
                        if(a+b+c+d == s.length()
                                && (isValid(s.substring(0,a))
                                    && isValid(s.substring(a,(a+b)))
                                    && isValid(s.substring((a+b),(a+b+c)))
                                    && isValid(s.substring((a+b+c),(a+b+c+d))))) {

                                ips.add(s.substring(0,a) + "."
                                        +s.substring(a,(a+b)) + "."
                                        +s.substring((a+b),(a+b+c)) + "."
                                        +s.substring((a+b+c),(a+b+c+d)));

                        }
                    }
                }
            }
        }
        return ips;
    }

    /**
     * Verify each slot of the IP
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() > 4 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
            return false;
        return true;
    }
}


//        List<List<Integer>> combinations = new ArrayList<>();
//        List<Integer> combination;
//        int nextSlot, slotLength = 0;
//        for (int i=3; i>0; i--) {
//            combination = new ArrayList<>();
//            combination.add(i);
//            nextSlot = i;
//            for (int j=3; j>0; j--) {
//                slotLength = (int) Math.ceil((s.length() - nextSlot) / j);
//                combination.add(slotLength);
//                nextSlot += slotLength;
//            }
//            combinations.add(combination);
//        }

// show permutations
//        combinations.forEach(System.out::println);
// System.out.println("no duplicate permutations:");

// Get all non duplicate permutations
//        Set<List<Integer>> permutations = new HashSet<>();
//        combinations.forEach(e-> this.getPermutations(permutations, e.stream().mapToInt(Integer::intValue).toArray(), 0));

// get non duplicated permutations and evaluate among the IP rules
//        for(List<Integer> slots: permutations) {
//             if (isValid(s.substring(0, a))
//                     && isValid(s.substring(a, (a + b)))
//                     && isValid(s.substring((a+b), (a+b+c)))
//                     && isValid(s.substring((a+b+c), (a+b+c+d)))) {
//
//                 ips.add(s.substring(0, a)+ "."
//                         + s.substring(a, (a + b)) + "."
//                         + s.substring((a+b), (a+b+c))+"."
//                         + s.substring((a+b+c), (a+b+c+d)));
//             }
//        }
