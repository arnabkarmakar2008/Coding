package com.example.coding.slidingwindow.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, find the count of substring
 * that contains at most k distinct characters.
 *
 * Input: S = "eceba" and k = 3
 * Output: 4
 * Explanation: T = "eceb"
 *
 * Input: S = "WORLD" and k = 4
 * Output: 4
 * Explanation: T = "WORL" or "ORLD"
 */
public class CountSubArraysWithAtmostKDistinctChar {

    public static int countOfSubstringWithArMostKDistinct(String s, int k) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        while (end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);

            if (map.size() <= k) {
                count = count + (end-start+1);
                end++;
            } else {
                while (map.size() > k) {
                    int ct = map.get(s.charAt(start));

                    if (ct-1 == 0) {
                        map.remove(s.charAt(start));
                    } else {
                        map.put(s.charAt(start), map.getOrDefault(s.charAt(start),0)-1);
                    }

                    start++;
                }
                count = count + (end-start+1);
                end++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "world";
        System.out.println(countOfSubstringWithArMostKDistinct(str, 4) - countOfSubstringWithArMostKDistinct(str, 3));
    }
}
