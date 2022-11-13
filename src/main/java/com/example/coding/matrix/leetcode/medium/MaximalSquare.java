package com.example.coding.matrix.leetcode.medium;

/**
 * Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {

  /**
   * Note : Dynamic Programming. Leave 1 row and 1 column from calculation. Now we have to count the number of square for each cell.
   * For each cell, it can be a part of bigger square and itself is a square.
   * 1 1
   * 1 1 -> Will result in total 5 squares. So for bottom right cell it will be 1 + 1 (1 for bigger square and one for itself)
   *
   * So for each cell calculation is min(cell[i-1][j, cell[i][j-1], cell[i-1][j-1]]) + 1
   *
   * After getting the max count, just have to square it to get the max area.
   *
   * Note : dp[i][j] represents the length of the square which lower right corner is located at (i, j).
   * If the value of this cell is also 1, then the length of the square is the minimum of: the one above,
   * its left, and diagonal up-left value +1. Because if one side is short or missing, it will not form a square.
   *
   * @param matrix
   * @return
   */

  public static int maximalSquare(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;

    int maxSqr = 0;

    for (int i=0; i < row; i++) {
      for (int j=0; j < col; j++) {
        if (matrix[i][j] == 1) {
          if (i!=0 && j!=0) {
            int res = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + matrix[i][j];
            maxSqr = Math.max(res, maxSqr);
            matrix[i][j] = res;
          }
        }
      }
    }

    return maxSqr*maxSqr;
  }

  public static void main(String[] args) {
    int[][] mat = {{1,1,1},{1,1,1},{1,1,1}};
    System.out.println(maximalSquare(mat));
  }

}
