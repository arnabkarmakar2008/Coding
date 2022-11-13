package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 */
public class PalindromicSubstrings {

    /**
     * https://www.youtube.com/watch?v=4RACzI5-du8
     * We are treating each element as middle element and expanding.
     *
     * String s = "aabc";
     * Odd : a left =0 right = 0;
     * even : aa left=0 right=1;
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            int oddPalindromeCount = extractPalindromeCount(s, i, i);
            int evenPalindromeCount = extractPalindromeCount(s, i, i+1);
            count += oddPalindromeCount+evenPalindromeCount;
        }

        return count;
    }

    private static int extractPalindromeCount(String s, int left, int right) {
        int count = 0;
        while (left>=0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            count++;
            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aabc"));
    }
}
