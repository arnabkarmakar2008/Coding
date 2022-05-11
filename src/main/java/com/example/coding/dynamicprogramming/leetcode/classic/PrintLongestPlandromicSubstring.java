package com.example.coding.dynamicprogramming.leetcode.classic;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 */
public class PrintLongestPlandromicSubstring {

  public static String longestPalindrome(String s) {
    int strLen = s.length();
    int maxPalindromeLen = 0;
    int startIndex = 0;
    int endIndex = 0;

    //dp array
    int[][] dp = new int[strLen][strLen];

    for (int i=0; i<strLen; i++) {
      dp[i][i] = 1; //a is a palindrome, b is a palindrome
    }

    //prefill dp array for 2 char
    for (int i=0; i<strLen-1; i++) {
      if (s.charAt(i) == s.charAt(i+1)) {
        dp[i][i+1] = 1;
        maxPalindromeLen = 2;
        startIndex = i;
        endIndex = i+1;
      }
    }

    //Now start filling from size 3 to str length. So check if size=3 substrings are palindrome or not. And fill
    //dp array. Next do it for size=4 and so on.

    for (int k=3; k<=strLen; k++) { // K will go till str length
      for (int i=0; i < strLen-k+1; i++) { // We are starting from str size=3; So have to adjust i as strLen-k+1
        int j = i + k - 1;

        //aabaa is palindrome. First and Last chars are matching. And from dp table we will get aba is palindrome.
        if (s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] == 1)) {
          dp[i][j] = 1;

          if (j-i+1 > maxPalindromeLen) {
            maxPalindromeLen = j-i+1;
            startIndex = i;
            endIndex = j;

          }
        }
      }

    }

    return s.substring(startIndex, endIndex+1);
  }

  public static void main(String[] args) {
    String str = "aaaabbaa";
    System.out.println(longestPalindrome(str));
  }
}

