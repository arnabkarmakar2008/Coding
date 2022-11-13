package com.example.coding.priorityqueue.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 *
 * Return any possible rearrangement of s or return "" if not possible.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: s = "aaab"
 * Output: ""
 */
public class ReorganizeString {

    /**
     * https://leetcode.com/problems/reorganize-string/discuss/113440/Java-solution-PriorityQueue
     * @param s
     * @return
     */
    public static String reorganizeString(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxPQ =
                new PriorityQueue<>((a,b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxPQ.offer(entry);
        }

        StringBuilder sb = new StringBuilder();

        while (!maxPQ.isEmpty()) {
            Map.Entry<Character, Integer> cache = maxPQ.poll();

            // if character in cache is different with tail character in current string
            if (sb.length() == 0 || cache.getKey() != sb.charAt(sb.length()-1)) {
                sb.append(cache.getKey());
                cache.setValue(cache.getValue()-1);

                if (cache.getValue() != 0) {
                    maxPQ.offer(cache);
                }
            } else {
                // if character in cache is same as tail character in current string
                // we need to try the character with second highest frequency
                Map.Entry<Character, Integer> cache2 = maxPQ.poll();

                // corner case: if no more elements in queue, the input string should be invalid
                // because we do not have any other characters that different with current string tail
                if (cache2 == null) {
                    return "";
                }

                sb.append(cache2.getKey());

                cache2.setValue(cache2.getValue()-1);

                if (cache2.getValue() != 0) {
                    maxPQ.offer(cache2);
                }

                maxPQ.offer(cache);

            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "aaabc";
        System.out.println(reorganizeString(s));
    }
}
