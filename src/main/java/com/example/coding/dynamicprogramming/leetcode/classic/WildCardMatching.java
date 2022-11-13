package com.example.coding.dynamicprogramming.leetcode.classic;


/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 */
public class WildCardMatching {

  public static boolean isMatch(String s, String p) {
    int strLen = s.length();
    int pattLen = p.length();

    boolean[][] dp = new boolean[strLen+1][pattLen+1];

    dp[0][0] = true;

    for (int j=1; j<dp[0].length; j++) {
      if (p.charAt(j-1) == '*'){
        dp[0][j] = dp[0][j-1];
      }
    }

    for (int i=1; i<dp.length; i++) {
      for (int j=1; j<dp[i].length; j++) {

        if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
          dp[i][j] = dp[i-1][j-1];
        } else if (p.charAt(j-1) == '*') {
          //When we consider * as empty string, then exclude * and check if dp[i][j-1]
          dp[i][j] = dp[i-1][j] || dp[i][j-1]; // dp[i][j-1] when * represent empty chars.
        } else {
          dp[i][j] = false;
        }
      }
    }

    return dp[strLen][pattLen];

  }

  public static void main(String[] args) {
    String str = "albmnc";
    String pattern = "a?b*cx";

    System.out.println(isMatch(str, pattern));
  }
}
