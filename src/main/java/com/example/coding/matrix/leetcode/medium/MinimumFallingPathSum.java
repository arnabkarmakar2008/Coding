package com.example.coding.matrix.leetcode.medium;

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in
 * the next row that is either directly below or diagonally left/right. Specifically, the next element from position
 * (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class MinimumFallingPathSum {
  /**
   * Note : Dynamic Programming : The minimum path to get to element A[i][j] is the minimum of A[i - 1][j - 1], A[i - 1][j] and A[i - 1][j + 1].
   * Starting from row 1, we add the minumum path to each element. The smallest number in the last row is the miminum path sum.
   * Example:
   * [1, 2, 3]
   * [4, 5, 6] => [5, 6, 8]
   * [7, 8, 9] => [7, 8, 9] => [12, 13, 15]
   *
   *  1  2   3
   *  \  |   / (min of above all)
   *     5
   */


  public static int minFallingPathSum(int[][] A) {
    int rows = A.length;
    int cols = A[0].length;
    int minSum = Integer.MAX_VALUE;

    int[][] dp = new int[rows][cols+2]; // As we have to deal with j-1 and j+1

    //Initialize first and last column with Interger.mAX
    for (int i=0; i<rows; i++) {
      dp[i][0] = Integer.MAX_VALUE;
      dp[i][cols+1] = Integer.MAX_VALUE;
    }

    // Copy first row from orig matrix to DP matrix

    for (int j=0; j<cols; j++) {
      dp[0][j+1] = A[0][j];
    }

    //Now traverse DP matrix. Starting from frist row, store min for each cell.
    for (int i=1; i<rows; i++) {
      for(int j=1; j<=cols; j++) {
        int minNeigh = Math.min(dp[i-1][j], dp[i-1][j-1]);
        minNeigh = Math.min(minNeigh, dp[i-1][j+1]);
        dp[i][j] = A[i][j-1] + minNeigh; // As matrix DP has 1 extra column added at front
      }
    }

    // Find min sum from last row of DP matrix
    for (int j=1; j<=cols; j++) {
      minSum = Math.min(minSum, dp[rows-1][j]);
    }

    return minSum;

  }
}
