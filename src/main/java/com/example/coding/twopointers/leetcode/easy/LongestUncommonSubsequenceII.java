package com.example.coding.twopointers.leetcode.easy;

/**
 * Given two strings a and b, return the length of the longest uncommon subsequence between a and b.
 * If the longest uncommon subsequence does not exist, return -1.
 */
public class LongestUncommonSubsequenceII {

  public static int findLUSlength(String a, String b) {
    return 0;
  }

  /**
   * Determine if String a is subsequence of String b or not
   * @param a
   * @param b
   * @return
   */
  public static boolean isSubsequence(String a, String b) {
    int firstCounter = 0;
    int secondCounter = 0;

    while (firstCounter < a.length() && secondCounter < b.length()) {
      if (a.charAt(firstCounter) == b.charAt(secondCounter)) {
        firstCounter++;
      }

      secondCounter++;
    }

    return firstCounter == a.length();
  }


  public static void main(String[] args) {
    String a = "abc";
    String b = "cdc";

    System.out.println(findLUSlength(a, b));

  }
}
