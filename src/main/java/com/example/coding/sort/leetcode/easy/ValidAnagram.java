package com.example.coding.sort.leetcode.easy;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidAnagram {

  public static boolean isAnagram(String s, String t) {

    char[] inputArray = new char[26];

    for (int i=0; i< s.length(); i++) {
      char ch = s.charAt(i);
      inputArray[ch - 'a']++;
    }

    for (int i=0; i < t.length(); i++) {
      char ch = t.charAt(i);

      if (inputArray[ch - 'a'] == 0) {
        return false;
      }

    }

    return true;
  }

  public static void main(String[] args) {
    String s = "rat";
    String t = "car";

    System.out.println(isAnagram(s,t));
  }
}
