package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words,
 * it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares
 * while 3 and 11 are not.
 */
public class PerfectSquares {

  /**
   * n = 11
   * 0 1 2 3 4 5 6 7 8 9 10 11
   * 0 1 2 3 1 2 3 4
   *
   * So for position 7, do 7 - 1^2 = 6. For 6 we need 3 square numbers. So for 7 it will be 3+1=4
   * Now 7 - 2^2 = 3. For 3 we need 3. So for 7 it will be 3+1=4;
   *
   */

  public static int numSquares(int n) {
    int[] dp = new int[n+1];

    dp[0] = 0;
    dp[1] = 1;

    for (int i=2; i<=n; i++) {
      int min = Integer.MAX_VALUE;

      for (int j=1; j*j < i; j++) {
        //We have to start deducting from 1^2 and it will continue till 1sq, 2sq, 3sq until it is less than i.
        int reminder = i - j*j;

        min = Math.min(min, (dp[reminder] + 1));
      }

      dp[i] = min;
    }

    return dp[n];
  }

  public static void main(String[] args) {
    int n=11;
    System.out.println(numSquares(n));
  }
}
