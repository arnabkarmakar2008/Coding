package com.example.coding.slidingwindow.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 *
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc",
 * "cab", "cabc" and "abc" (again).
 */
public class CountOfSubstringsContainingAll3Chars {

    /**
     * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/723408/Sliding-Window-with-explanation-and-very-readable-with-comments
     * @param s
     * @return
     */
    public static int numberOfSubstrings(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int numSubstrings = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0)+1);

            while (freqMap.size() >= 3) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar)-1);

                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }

                left++;
            }

            numSubstrings += left;

            right++;
        }
        return numSubstrings;
    }


    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}
