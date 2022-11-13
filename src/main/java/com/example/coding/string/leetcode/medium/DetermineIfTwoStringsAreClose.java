package com.example.coding.string.leetcode.medium;

import java.util.Arrays;

/**
 * Two strings are considered close if you can attain one from the other using the
 * following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another
 * existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and
 * false otherwise.
 */
public class DetermineIfTwoStringsAreClose {

    /**
     * 1. Two strings should have same chars
     * 2. The freq of any char in first word should match with freq of any other char in second word
     * @param word1
     * @param word2
     * @return
     */

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int ct = 0; ct < word1.length(); ct++) {
            freq1[word1.charAt(ct) - 'a']++;
        }

        for (int ct = 0; ct < word2.length(); ct++) {
            freq2[word2.charAt(ct) - 'a']++;
        }

        //Two strings should have same unique chars
        for (int ct=0; ct < freq1.length; ct++) {
            if ( (freq1[ct] != 0 && freq2[ct] == 0) || (freq1[ct] == 0 && freq2[ct] != 0)) {
                return false;
            }
        }

        //Freq of chars should match
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int ct=0; ct < freq1.length; ct++) {
            if ( freq1[ct] != freq2[ct]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "bca";

        System.out.println(closeStrings(word1, word2));
    }
}
