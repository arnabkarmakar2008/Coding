package com.example.coding.dynamicprogramming.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreakI {

  public static boolean solve(String input, int index, Set<String> dictionary) {
    //Base case
    if (index >= input.length()) {
      return true; // We have reached till end so earlier string segments are present in dict
    }

    for (int i = index; i < input.length(); ++i) {
      // Check if any valid substring is present in dict, then partition

      String substr = input.substring(index, i+1);

      if (dictionary.contains(substr) && solve(input, i+1, dictionary)) {
        //If substr is present in dict, then call solve again with rest of the substr.
        // If both return true, then entire string is present in dict.

        return true;
      }

    }

    return false;
  }

  public static void main(String[] args) {
    String input = "applepenappleg";
    Set<String> dictionary = new HashSet<>();
    dictionary.add("apple");
    dictionary.add("pen");

    System.out.println(solve(input, 0, dictionary));

  }
}
