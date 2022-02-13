package com.example.coding.dynamicprogramming.leetcode.string;

/**
 *Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions of
 * the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class IsSubSequence {

  public static boolean solveUsingTwoPointer(String s, String t) {
    int sIndex = 0;
    int tIndex = 0;

    while (tIndex < t.length()) {

      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        sIndex++;
        if (sIndex == s.length()) {
          return true;
        }
      }

      tIndex++;
    }

    return false;
  }

  public static boolean solve(String s, String t, int index1, int index2) {

    if (index2 <0 && index1 >= 0) {
      return false;
    }

    if (index1 < 0 && index2 < 0) {
      return true;
    }

    if (s.charAt(index1) == t.charAt(index2)) {
      return true && solve(s, t, index1-1, index2-1);
    } else {
      return solve(s,t,index1, index2-1);
    }
  }

  public static boolean isSubsequence(String s, String t) {
    return solve(s, t, s.length()-1, t.length()-1);
  }

  public static void main(String[] args) {
    String s = "abc";
    String t = "abgdc";

    System.out.println(solveUsingTwoPointer(s,t));
  }

}
