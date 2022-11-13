package com.example.coding.string.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, return the maximum number of ocurrences of any substring
 * under the following rules:
 *
 * The number of unique characters in the substring must be less than or equal to maxLetters.
 * The substring size must be between minSize and maxSize inclusive.
 *
 * Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * Output: 2
 * Explanation: Substring "aab" has 2 ocurrences in the original string.
 * It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
 *
 */
public class MaxNumberOfOccurrencesOfSubstr {

    /**
     * https://www.youtube.com/watch?v=TVG3BcOOCyM
     *
     *
     * Sliding window technique
     * @param s
     * @param maxLetters
     * @param minSize
     * @param maxSize
     * @return
     */
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int numberOfOccu = Integer.MIN_VALUE;
        int[] freqArray = new int[26];
        int letters = 0;

        int start = 0, end = 0;

        while (end < s.length()) {
            char ch = s.charAt(end);

            freqArray[ch - 'a']++;

            if (freqArray[ch - 'a'] == 1) {
                letters++; //unique letter. increment the count
            }

            while (letters > maxLetters || end-start+1 > maxSize) {
                //move start pointer
                char startChar = s.charAt(start);
                freqArray[startChar - 'a']--;

                if (freqArray[startChar - 'a'] == 0) {
                    letters--;
                }

                start++;
            }

            while (end-start+1 >= minSize) {
                String substr = s.substring(start, end+1);
                map.put(substr, map.getOrDefault(substr,0)+1);
                numberOfOccu = Math.max(numberOfOccu, map.get(substr));

                char startChar = s.charAt(start);
                freqArray[startChar - 'a']--;

                if (freqArray[startChar - 'a'] == 0) {
                    letters--;
                }

                start++;

            }


        }

        return numberOfOccu;
    }

    public static void main(String[] args) {
        String s = "aababcaab";
        int maxLetters = 2, minSize = 3, maxSize = 4;

        System.out.println(maxFreq(s, maxLetters, minSize, maxSize));
    }
}
