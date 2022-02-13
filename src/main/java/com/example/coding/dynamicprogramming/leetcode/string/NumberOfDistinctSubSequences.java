package com.example.coding.dynamicprogramming.leetcode.string;

/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting
 * some (can be none) of the characters without disturbing the remaining characters' relative positions.
 * (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 */
public class NumberOfDistinctSubSequences {

  /**
   * Note :: https://www.youtube.com/watch?v=9yV6Elqvblw
   * If last char of both the strings are not matching, then number of distinct subsequences
   * if s[i] != t[j]
   * dp[i+1][j+1] = dp[i][j+1]
   *
   * if s[i] = t[j]
   * then we can include or not include
   * If we include then dp[i][j] + dp[i][j+1]
   * @param s
   * @param t
   * @return
   */
  public static int numDistinct2(String s, String t) {
    int[][] dp = new int[t.length()+1][s.length()+1];

    //filling first row with 1. As with empty string, subsequence will be 1.
    for (int i=0; i<t.length(); i++) {
      for (int j=0; j<s.length(); j++) {
        if (j==0) {
          dp[i][j] = 0;
        }

        if (i==0) {
          dp[i][j] = 1;
        }
      }
    }

    for (int i=1; i<=t.length(); i++) {
      for (int j=1; j<=s.length(); j++) {
        if (t.charAt(i-1) == s.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
        } else {
          dp[i][j] = dp[i][j-1];
        }
      }
    }

    return dp[t.length()][s.length()];
  }

  public static int recursionVersion(String s, String t, int sIndex, int tIndex, int[][] dp) {

    if (tIndex == t.length()) {
      return 1;
    }

    if (sIndex == s.length()) {
      return 0;
    }

    if (dp[tIndex][sIndex] != -1) {
      return dp[tIndex][sIndex];
    }

    if (s.charAt(sIndex) == t.charAt(tIndex)) {
      dp[tIndex][sIndex] = recursionVersion(s, t, sIndex+1, tIndex+1, dp)
              + recursionVersion(s, t, sIndex+1, tIndex, dp);
    } else {
      dp[tIndex][sIndex] = recursionVersion(s, t, sIndex+1, tIndex, dp);
    }

    return dp[tIndex][sIndex];

  }

  public static void main(String[] args) {
    String s = "rabbbit";
    String t = "rabbit";

    int[][] dp = new int[t.length()+1][s.length()+1];

    for (int i=0; i<t.length()+1; i++) {
      for (int j=0; j<s.length()+1; j++ ) {
        dp[i][j] = -1;
      }
    }
    //System.out.println(numDistinct2(s,t));

    System.out.println(recursionVersion(s,t, 0, 0, dp));
  }


}
