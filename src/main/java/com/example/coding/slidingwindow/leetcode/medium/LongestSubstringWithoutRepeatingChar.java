package com.example.coding.slidingwindow.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingChar {

    public static int lengthOfLongestSubstring(String s) {

        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;

        while (end < s.length()) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch,0)+1);

            //if map size equal to window size then increase end
            if (map.size() == end-start+1) {
                maxLength = Math.max(maxLength, end-start+1);

            } else {
                while (map.size() < end-start+1) {
                    char startChar = s.charAt(start);
                    int startCharCt = map.get(startChar);

                    if (startCharCt-1 == 0) {
                        map.remove(startCharCt);
                    } else {
                        map.put(startChar, startCharCt-1);
                    }

                    start++;
                }
            }

            end++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(str));
    }
}
