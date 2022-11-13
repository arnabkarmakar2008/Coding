package com.example.coding.string.leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagrams {

    /**
     * https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();


        for (String str : strs) {
            char[] currentCharArray = str.toCharArray();
            Arrays.sort(currentCharArray);
            String currentKey = String.valueOf(currentCharArray);

            if (!map.containsKey(currentKey)) {
                map.put(currentKey, new ArrayList<>());
            }

            map.get(currentKey).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> resultList = groupAnagrams(strs);

        System.out.println(resultList);
    }
}
