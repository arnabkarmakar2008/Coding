package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        String resultString = "";
        int resultLength=Integer.MIN_VALUE;
        for (int i=0; i < s.length(); i++) {

            //For odd length
            int left = i;
            int right = i;
            while (left >=0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
                int currentLength = right-left+1;

                if (currentLength > resultLength) {
                    resultLength = currentLength;
                    resultString = s.substring(left, right+1);
                }

                left--;
                right++;
            }

            //for even length
            left = i;
            right = i+1;
            while (left >=0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
                int currentLength = right-left+1;

                if (currentLength > resultLength) {
                    resultLength = currentLength;
                    resultString = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }

        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
