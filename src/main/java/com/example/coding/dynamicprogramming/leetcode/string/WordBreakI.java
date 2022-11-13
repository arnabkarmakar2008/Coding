package com.example.coding.dynamicprogramming.leetcode.string;

import java.util.HashSet;
import java.util.List;
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

  public static boolean solveUsingTrie(String str, List<String> wordDict) {
    Trie trie = new Trie();

    for (String word : wordDict) {
      trie.insert(word);
    }

    return wordBreakUtil(str, trie);
  }

  private static boolean wordBreakUtil(String str, Trie trie) {
    int size = str.length();

    if (size == 0) {
      return true;
    }

    for (int ct = 1; ct <= size; ct++ ) {
      if (trie.search(str.substring(0,ct)) && wordBreakUtil(str.substring(ct+1), trie) ) {
        return true;
      }
    }

    return false;
  }



  public static void main(String[] args) {
    String input = "applepenapple";
    Set<String> dictionary = new HashSet<>();
    dictionary.add("apple");
    dictionary.add("pen");

    System.out.println(solve(input, 0, dictionary));

  }
}

class Trie {
  TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;

    for (int ct = 0; ct < word.length(); ct++) {
      if (!node.containsKey(word.charAt(ct))) {
        node.put(word.charAt(ct), new TrieNode());
      }

      node = node.get(word.charAt(ct));
    }

    node.isEnd = true;
  }

  public boolean search(String word) {
    TrieNode node = root;

    for (int ct = 0; ct < word.length(); ct++) {
      if (!node.containsKey(word.charAt(ct))) {
        return false;
      } else {
        node = node.get(word.charAt(ct));
      }
    }

    return node.isEnd;
  }

}

class TrieNode {
  TrieNode[] children = new TrieNode[26];
  boolean isEnd;

  public TrieNode() {
  }

  boolean containsKey(char ch) {
    return children[ch - 'c'] != null;
  }

  TrieNode get(char ch) {
    return children[ch - 'c'];
  }

  void put(char ch, TrieNode node) {
    children[ch - 'c'] = node;
  }

  boolean getEnd() {
    return isEnd;
  }
}
