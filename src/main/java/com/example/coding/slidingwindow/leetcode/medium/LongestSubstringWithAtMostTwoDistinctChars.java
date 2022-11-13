package com.example.coding.slidingwindow.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that
 * contains at most 2 distinct characters.
 */
public class LongestSubstringWithAtMostTwoDistinctChars {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;

        while (end < s.length()) {
            char endChar = s.charAt(end);

            map.put(endChar, map.getOrDefault(endChar, 0)+1);

            if (map.size() <= 2) {
                maxLength = Math.max(maxLength, end-start+1);
            } else {

                while (map.size() > 2) {
                    char startChar = s.charAt(start);
                    int startCharCt = map.get(startChar);

                    if (startCharCt - 1 == 0) {
                        map.remove(startChar);
                    } else {
                        map.put(startChar, startCharCt - 1);
                    }
                    start++;
                }
            }

            end++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(str));
    }
}
