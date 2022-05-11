package com.example.coding.sort.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 */
public class GroupAnagrams {

  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length ==0) {
      return new ArrayList<>();
    }

    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      char[] charArray = str.toCharArray();
      char[] frequencyArray = new char[26];

      for (char c : charArray) {
        frequencyArray[c - 'a']++;
      }

      // for abc this frequencyArray array will contain 1110000000....till 26th

      String keyStr = String.valueOf(frequencyArray);

      if (!map.containsKey(keyStr)) {
        map.put(keyStr, new ArrayList<>());
      }

      map.get(keyStr).add(str);

    }

    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    List<List<String>> lists = groupAnagrams(strs);
    System.out.println(lists);
  }
}
