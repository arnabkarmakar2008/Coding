package com.example.coding.slidingwindow.leetcode.medium;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to
 * any other uppercase English character. You can perform this operation at
 * most k times.
 *
 * Return the length of the longest substring containing the same letter
 * you can get after performing the above operations.
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 */
public class LongestRepeatingCharReplacement {

    /**
     * https://www.youtube.com/watch?v=gqXU1UyA8pk - Neetcode
     *
     * Note : In a substr, we have to find the count of max occurrence of a char. Then substrsize - max count <= k
     * as only k replacements are allowed.
     *
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int maxLength = Integer.MIN_VALUE;
        int[] feq = new int[26];

        int maxCount = Integer.MIN_VALUE;

        while (end < s.length()) {
            char ch = s.charAt(end);
            int index = ch - 'A';
            feq[index]++;

            maxCount = Math.max(maxCount, feq[index]);

            // if max character frequency + distance between start and end is greater than k
            // this means we have considered changing more than k charactres. So time to shrink window

            if ((end-start+1) - maxCount <= k) {
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else {
                while ( (end-start+1) - maxCount > k) {
                    feq[s.charAt(start) - 'A']--;
                    start++;
                }

                end++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str = "ABAB";
        System.out.println(characterReplacement(str, 2));
    }
}
