package com.example.coding.twopointers.leetcode.easy;

/**
 * Given two strings a and b, return the length of the longest uncommon subsequence between a and b.
 * If the longest uncommon subsequence does not exist, return -1.
 *
 * An uncommon subsequence between an array of strings is a string that is a subsequence of one string
 * but not the others.
 *
 * A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.
 *
 * For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters
 * in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
 */
public class LongestUncommonSubsequenceII {

  public static int findLUSlength(String a, String b) {
    return 0;
  }

  /**
   * https://leetcode.com/problems/longest-uncommon-subsequence-i/discuss/99434/Read-and-think-before-coding-Clean-and-clear-Java-solution
   * @param b
   * @return
   */
  public static int isSubsequence(String a, String b) {
    //Length of the longest string will be max uncommon subsequence
    int aLength = a.length();
    int bLength = b.length();

    if (a.equals(b)) {
      return -1;
    } else {
      return Math.max(aLength, bLength);
    }
  }


  public static void main(String[] args) {
    String a = "abc";
    String b = "cdc";

    System.out.println(findLUSlength(a, b));

  }
}
