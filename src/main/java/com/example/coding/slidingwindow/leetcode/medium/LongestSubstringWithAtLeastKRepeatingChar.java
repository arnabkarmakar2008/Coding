package com.example.coding.slidingwindow.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and an integer k, return the length of the
 * longest substring of s such that the frequency of each character
 * in this substring is greater than or equal to k.
 *
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 *
 * Input: s = "ababbc", k = 2
 * Output: 5
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringWithAtLeastKRepeatingChar {


    /**
     * We have to count the frequency of each char. If any char frequency is less than K,
     * then it is not possible to include that char in any substring.
     *
     * So idea is, to split then array when that char occurs.
     * https://www.youtube.com/watch?v=bHZkCAcj3dc
     *
     * @param s
     * @param k
     * @return
     */

    public static int longestSubstring(String s, int k) {

        int n = s.length();

        if (n == 0 || n < k) {
            return 0;
        }

        if (k <= 1) {
            return n;
        }

        int[] frequencyArray = new int[26]; //as all lower case char
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            frequencyArray[c - 'a']++;
        }

        int end = 0;

        while (end < s.length() && frequencyArray[charArray[end] - 'a'] > 0 && frequencyArray[charArray[end] - 'a'] >= k ) {
            end++;
        }

        if (end >= s.length()-1) {
            return end;
        }

        int subStrLen1 = longestSubstring(s.substring(0,end), k);

        while (end < s.length() && frequencyArray[charArray[end] - 'a'] < k ) {
            end++;
        }

        int subStrLen2 = end < s.length() ? longestSubstring(s.substring(end+1), k) : 0;

        return Math.max(subStrLen1, subStrLen2);
    }


    public static void main(String[] args) {
        String str = "eceba";
        System.out.println(longestSubstring(str, 3));
    }
}
