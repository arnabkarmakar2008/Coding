package com.example.coding.string.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 *
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 *
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 */
public class BuddyString {


    /**
     * https://leetcode.com/problems/buddy-strings/discuss/891469/C%2B%2BJavaPython-One-pass-Clean-and-Concise-O(N)
     * @param s
     * @param goal
     * @return
     */
    public static boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        int diff1 = -1;
        int diff2 = -1;

        Set<Character> set = new HashSet<>();

        for (int ct = 0; ct < s.length(); ct++) {
            if (s.charAt(ct) != goal.charAt(ct)) {
                if (diff1 == -1) {
                    diff1 = ct;
                } else if (diff2 == -1) {
                    diff2 = ct;
                } else {
                    return false; //more than two different
                }
            }

            set.add(s.charAt(ct)); //just to keep track of duplicates in s
        }

        if (diff1 != -1 && diff2 != -1) {
            if (s.charAt(diff1) == goal.charAt(diff2) && s.charAt(diff2) == goal.charAt(diff1)) {
                return true;
            }
        } else if (diff1 != -1) {
            return false; //just only one difference. So not valid.
        }

        //if s and goal are same , then check if s contains duplicate or not. If yes then we can swap.
        //e.g. aab to goal aab

        return s.length() > set.size();
    }

    public static void main(String[] args) {
        String s = "abcd";
        String goal = "cbad";

        System.out.println(buddyStrings(s, goal));
    }
}
