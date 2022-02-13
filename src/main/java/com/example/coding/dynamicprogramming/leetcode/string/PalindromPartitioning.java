package com.example.coding.dynamicprogramming.leetcode.string;

import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 */
public class PalindromPartitioning {

  public static int min = Integer.MAX_VALUE;
  public static void main(String[] args) {
    /**
     * Min number of partition to make a string palindrome
     * IP str = "nitik"
     * OP = 2 n iti k
     */
    String str = "aabb";
    partition(str, "");
  }

  public static void partition(String s, String answerSoFar) {
    if (s.length() == 0) {
      System.out.println(answerSoFar);
      return;
    }

    for (int i=0; i<s.length(); i++) {
      String prefix = s.substring(0, i+1); // doing i+1 as substr will give string till i
      String restOfTheString = s.substring(i+1);

      //If prefix is palindrom then only recurse, else ignore
      if (isPalindrome(prefix)) {
        partition(restOfTheString, answerSoFar + "(" + prefix + ")");
      }
    }
  }

  public static boolean isPalindrome(String str) {

    int start = 0;
    int end = str.length()-1;

    if (start == end) {
      return true;
    }

    if (start > end ) {
      return true;
    }

    while (start < end) {
      if (str.charAt(start) != str.charAt(end)) {
        return false;
      } else {
        start++;
        end--;
      }
    }

    return true;
  }
}
