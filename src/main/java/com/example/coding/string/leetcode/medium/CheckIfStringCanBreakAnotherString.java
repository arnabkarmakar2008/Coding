package com.example.coding.string.leetcode.medium;

import java.util.Arrays;

/**
 * Given two strings: s1 and s2 with the same size, check if
 * some permutation of string s1 can break some permutation of string s2 or vice-versa.
 * In other words s2 can break s1 or vice-versa.
 *
 * A string x can break string y (both of size n) if x[i] >= y[i] (in alphabetical order) for
 * all i between 0 and n-1.
 *
 * Input: s1 = "abc", s2 = "xya"
 * Output: true
 * Explanation: "ayx" is a permutation of s2="xya" which can break to string "abc" which is a permutation of s1="abc".
 *
 *
 */
public class CheckIfStringCanBreakAnotherString {

    /**
     * This problem can also be stated as below::
     * Check between two arrays, if all elements of one array is greater than other one.
     * @param s1
     * @param s2
     * @return
     */

    public static boolean checkIfCanBreak(String s1, String s2) {
        char[] ch1Array = s1.toCharArray();
        char[] ch2Array = s2.toCharArray();

        Arrays.sort(ch1Array);
        Arrays.sort(ch2Array);

        int counter1 = 0;
        int counter2 = 0;

        for (int ct = 0; ct< ch1Array.length; ct++) {
            if (ch1Array[ct] >= ch2Array[ct]) {
                counter1++;
            }

            if (ch2Array[ct] >= ch1Array[ct]) {
                counter2++;
            }
        }

        if (counter1 == s1.length() || counter2 == s2.length()) {
            return true;
        }

        return false;

    }


    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "xya";
        System.out.println(checkIfCanBreak(s1, s2));
    }
}
