package com.example.coding.dynamicprogramming.leetcode.knapsack;

/**
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at
 * most m 0's and n 1's in the subset.
 *
 * A set x is a subset of a set y if all elements of x are also elements of y.
 */
public class ZerosAndOnes {

  /**
   * https://www.youtube.com/watch?v=qkUZ87NCYSw
   * @param strs
   * @param m
   * @param n
   * @return
   */
  public static int findMaxForm(String[] strs, int m, int n) {
    int[][][] dp = new int[m+1][n+1][strs.length];
    return solve(strs, m, n, 0, dp);
  }

  private static int solve (String[] strs, int countZero, int countOne, int index, int[][][] dp) {
    if (index == strs.length || (countZero == 0 && countOne == 0)) {
      return 0;
    }

    if (dp[countZero][countOne][index] > 0 ) {
      return dp[countZero][countOne][index];
    }

    String str = strs[index];

    int[] countArray = countZerosAndOnes(str);
    int include = 0;
    int exclude = 0;

    //We can consider only if countZero and countOne are greater or equal to number of zeros and ones in string
    if (countZero >= countArray[0] && countOne >= countArray[1]) {
      include = 1 + solve(strs, countZero - countArray[0], countOne - countArray[1], index+1, dp);
    }

    exclude = solve(strs, countZero, countOne, index+1, dp);


    return dp[countZero][countOne][index] = Math.max(include, exclude);
  }

  private static int[] countZerosAndOnes(String str) {
    int[] arr = new int[2];

    int index = 0;

    while (index < str.length()) {
      if (str.charAt(index) == '0') {
        arr[0]++;
      } else {
        arr[1]++;
      }

      index++;
    }

    return arr;
  }

  public static int solveUsingTopDown(String[] strs, int countZero, int countOne) {
    int len = strs.length;

    int[][][] dp = new int[len+1][countZero+1][countOne+1];

    for (int i=0; i<len+1; i++) {
      //For each string, we have 2 choices, either we can include or exclude.
      // We can include, if only we have number of zeros in str >=  countZero and number of ones in str > = countOne
      int[] nums = new int[2];

      if (i > 0) {
        nums = countZerosAndOnes(strs[i-1]);
      }

      for (int j=0; j < countZero+1; j++) {
        for (int k=0; k < countOne+1; k++) {
          if (i == 0) {
            dp[i][j][k] = 0; // If there is no string in strs, we will have 0 subset
          } else if (j >= nums[0] && k >= nums[1]) {
            //then only we can include this ith string
            dp[i][j][k] = Math.max(1 + dp[i-1][j - nums[0]][k - nums[1]], dp[i-1][j][k]);
          } else {
            // we cannot include
            dp[i][j][k] = dp[i-1][j][k];
          }
        }
      }

    }

    return dp[len][countZero][countOne];
  }

  public static void main(String[] args) {
    String[] strs = {"10","0001","111001","1","0"};
    int m = 5, n = 3;

    System.out.println(findMaxForm(strs, m, n));
  }
}
