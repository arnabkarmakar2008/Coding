package com.example.coding.string.leetcode.easy;

/**
 * Given two string arrays word1 and word2, return true if the two arrays
 * represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in
 * order forms the string.
 */
public class CheckIfTwoStringArraysAreEquivalent {

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String str : word1) {
            sb1.append(str);
        }

        for (String str : word2) {
            sb2.append(str);
        }


        return sb1.toString().equals(sb2.toString());

    }

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};

        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}
