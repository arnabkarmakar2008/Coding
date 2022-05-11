package com.example.coding.dynamicprogramming.leetcode.classic;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty
 * substrings such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 */
public class InterleavingString {

  public static boolean recursionSolution(String s1, int index1, String s2, int index2, String s3, int index3) {

    if (index1 == s1.length()) {
      return s2.substring(index2).equals(s3.substring(index3));
    }

    if (index2 == s2.length()) {
      return s1.substring(index1).equals(s3.substring(index3));
    }

    /*if ((s1.charAt(index1) == s3.charAt(index3) && recursionSolution(s1, index1+1, s2, index2, s3, index3+1))
    || (s2.charAt(index2) == s3.charAt(index3) && recursionSolution(s1, index1, s2, index2+1, s3, index3+1))) {
      return true;
    }*/

    if (s1.charAt(index1) == s3.charAt(index3)){
      return recursionSolution(s1, index1+1, s2, index2, s3, index3+1);
    }
    if (s2.charAt(index2) == s3.charAt(index3)) {
      return recursionSolution(s1, index1, s2, index2+1, s3, index3+1);
    }

    return false;
  }

  public static boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }

    return recursionSolution(s1,0,s2,0,s3,0);
  }

  public static void main(String[] args) {
    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbcbcac";
    System.out.println(isInterleave(s1,s2,s3));
  }
}
