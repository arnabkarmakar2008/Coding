package com.example.coding.slidingwindow.leetcode.medium;

/**
 * You are given two strings s and t of the same length and an integer maxCost.
 *
 * You want to change s to t. Changing the ith character of s to ith character of t
 * costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the
 * characters).
 *
 * Return the maximum length of a substring of s that can be changed to be the same as
 * the corresponding substring of t with a cost less than or equal to maxCost.
 * If there is no substring from s that can be changed to its corresponding substring
 * from t, return 0.
 *
 * Input: s = "abcd", t = "bcdf", maxCost = 3
 * Output: 3
 * Explanation: "abc" of s can change to "bcd".
 * That costs 3, so the maximum length is 3.
 *
 */
public class GetEqualSubstringWithinBudget {

    public static int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int end = 0;
        int windowCost = 0;
        int maxLength = Integer.MIN_VALUE;

        while (end < s.length()) {
            char sChar = s.charAt(end);
            char tChar = t.charAt(end);
            int cost = Math.abs(sChar - tChar);

            windowCost += cost;

            if (windowCost <= maxCost) {
                maxLength = Math.max(maxLength, end-start+1);
            } else {
                while (windowCost > maxCost) {
                    char startSChar = s.charAt(start);
                    char startTChar = t.charAt(start);
                    int startCost = Math.abs(startSChar - startTChar);
                    windowCost -= startCost;
                    start++;
                }
            }

            end++;

        }

        return maxLength;
    }


    public static void main(String[] args) {
        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;

        System.out.println(equalSubstring(s,t,maxCost));
    }
}
