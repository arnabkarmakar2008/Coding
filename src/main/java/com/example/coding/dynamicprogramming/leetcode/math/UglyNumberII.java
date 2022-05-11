package com.example.coding.dynamicprogramming.leetcode.math;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 */
public class UglyNumberII {

  /**
   * https://www.youtube.com/watch?v=Lj68VJ1wu84
   *
   * @param n
   * @return
   */
  public static int dpSolution(int n) {
    int[] dp = new int[n];

    dp[0] = 1;
    int twoPointer = 0;
    int threePointer = 0;
    int fivePointer = 0;

    int min = 0;

    for (int i=1; i<n; i++) {
      min = Math.min((Math.min(2*dp[twoPointer], 3*dp[threePointer])), 5*dp[fivePointer]);
      dp[i] = min;
      if (2*dp[twoPointer] == min) {
        twoPointer++;
      }

      if (3*dp[threePointer] == min) {
        threePointer++;
      }

      if (5*dp[fivePointer] == min) {
        fivePointer++;
      }

    }

    return dp[n-1];
  }

  //Brute force
  public static int nthUglyNumber(int n) {
    int[] arr = new int[n];

    int j = 1;
    for (int i = 0; i < n; i++) {
      while (isUgly(j) == false) {
        j++;
      }

      arr[i] = j;
      j++;
    }

    return arr[n-1];
  }

  public static boolean isUgly(int num) {
    while (num % 2 == 0) num = num/2;
    while (num % 3 == 0) num = num/3;
    while (num % 5 == 0) num = num/5;

    return num == 1;

  }

  public static void main(String[] args) {
    int num = 12;
    System.out.println(dpSolution(num));
  }
}
