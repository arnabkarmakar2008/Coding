package com.example.coding.dynamicprogramming.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of words where each word consists of lowercase English letters.
 *
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere
 * in wordA without changing the order of the other characters to make it equal to wordB.
 *
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a
 * predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a
 * word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 */
public class LongestStringChain {

  /**
   * https://www.youtube.com/watch?v=4kbSc3nECH8
   * @param words
   * @return
   */
  public static int longestStrChain(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(string -> string.length()));

    Map<String, Integer> map = new HashMap<>();
    int maxChainSize = Integer.MIN_VALUE;

    for (int count=0; count < words.length; count++) {
      String word = words[count];
      int length = word.length();

      int max = 0;

      for (int i = 0; i < length; i++) {
        //Delete char for ith position from the word. And check if it is present in the map or not.
        //e.g. If current word size is 3, then its predecessor will be of size 2. So delete
        // one char ad check if substring is present in the map. If yes, then predecessor exists for this word.
        String tempString = word.substring(0,i) + word.substring(i+1);
        max = Math.max(max, map.getOrDefault(tempString, 0) + 1);
      }

      maxChainSize = Math.max(max, maxChainSize);
      map.put(word, max);

    }

    return maxChainSize;
  }

  public static void main(String[] args) {
    String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
    System.out.println(longestStrChain(words));
  }
}
