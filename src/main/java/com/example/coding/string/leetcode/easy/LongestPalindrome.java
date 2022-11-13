package com.example.coding.string.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length
 * of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {

        Set<Character> set = new HashSet<>();
        int counter = 0;

        for (int ct = 0; ct < s.length(); ct++) {
            char ch = s.charAt(ct);

            if (set.contains(ch)) {
                set.remove(ch);
                counter++; // will keep count of even number of chars
            } else {
                set.add(ch);
            }
        }

        // Only odd number of chars will be left in set.
        //So if set is not empty then max length will be 2 * counter + 1. Else 2 * counter
        if (set.isEmpty()) {
            return 2 * counter;
        } else {
            return 2 * counter +1;
        }
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
