package com.example.coding.dynamicprogramming.leetcode.classic;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support
 * for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {

  /**
   * t[i][j] = true till ith position of string it matching till jth position of pattern
   * @param s
   * @param p
   * @return
   *
   * t[i][j] = t[i-1][j-1] if str[i] == pattern[j] || pattern[j] = '.' Here i and j are matching. So we ca remove those
   * and check the pattern for rest of the strings. That is why taking value from t[i-1][j-1]
   *
   * if (str[i] != pattern[j]) t[i][j] = false
   *
   * if (pattern[j] == *) We can assume 0 occurrence of pattern[j-1]. Lets say pattern = xa* String =x .
   * We can assume 0 occurrence of a. So x will match to x. t[i][j] = t[i][j-2] If it is false then pattern[j-1]
   * is there in the string. So in the example we can remove a from the string and x will match with xa*.
   * so t[i][j] = t[i-1][j]
   *
   *
   */
  public static boolean isMatch(String s, String p) {
    int strLen = s.length();
    int pattLen = p.length();

    boolean[][] dp = new boolean[strLen+1][pattLen+1];
    dp[0][0] = true;

    /**
     * What about the first row? In other words which pattern p matches empty string s=""?
     * The answer is either an empty pattern p="" or a pattern that can represent an empty string such
     * as p="a*", p="z*" or more interestingly a combiation of them as in p="a*b*c*".
     * Below for loop is used to populate dp[0][j]. Note how it uses previous states by checking dp[0][j-2]
     */
    for (int j=2; j<dp[0].length; j++) {
        dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2];
    }

    for (int i=1; i<dp.length; i++) {
      for (int j=1; j<dp[0].length; j++) {
        if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
          dp[i][j] = dp[i-1][j-1];
        } else if (p.charAt(j-1) == '*') {

          dp[i][j] = dp[i][j-2]; // As * can represent empty, so we are ignoring j and j-1 from pattern

          if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
            dp[i][j] = dp[i-1][j];
          }
        } else {
          dp[i][j] = false;
        }
      }
    }

    return dp[strLen][pattLen];
  }

  public static void main(String[] args) {
    String str = "aa";
    String pattern = "a*";

    System.out.println(isMatch(str,pattern));
  }
}
