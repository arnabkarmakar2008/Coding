package com.example.coding.dynamicprogramming.leetcode.grid;

/**
 * You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0),
 * and in each step, you can only move right or down in the matrix.
 *
 * Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right
 * corner (m - 1, n - 1), find the path with the maximum non-negative product. The product of a path
 * is the product of all integers in the grid cells visited along the path.
 *
 * Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative, return -1.
 *
 * Notice that the modulo is performed after getting the maximum product.
 */
public class MaxNonNegativeProductInMatrix {

  public static int maxProduct = -1;

  public static void recursionSolution(int row, int col, int[][] grid, int productSoFar) {

    //Base Cases
    if (row == grid.length-1 && col == grid[0].length-1) {
      //Reached bottom-right cell
      maxProduct = Math.max(maxProduct, productSoFar);
      return;
    }

    if (grid[row][col] == 0) {
      maxProduct = Math.max(maxProduct, 0);
      return;
    }

    if (row + 1 < grid.length) {
      recursionSolution(row+1, col, grid, grid[row+1][col] * productSoFar);
    }

    if (col + 1 < grid[0].length) {
      recursionSolution(row, col+1, grid, grid[row][col+1] * productSoFar);
    }
  }

  /**
   * DP Solution. We have to store max and min product for each cell.
   * Refer to Max Sunarray problem. Using the same concept here.
   * https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/discuss/855166/Java-DFS(Easy-to-understand)-and-DP(Best-time-complexity)
   * @param grid
   * @return
   */
  public static int maxProductPath(int[][] grid) {
    int rowCount = grid.length;;
    int colCount = grid[0].length;

    Pair[][] dp = new Pair[rowCount][colCount];

    dp[0][0] = new Pair(grid[0][0], grid[0][0]);

    //Initialize 1st column
    for (int i=1; i<rowCount; i++) {
      dp[i][0] = new Pair(grid[i][0] * dp[i-1][0].min, grid[i][0] * dp[i-1][0].max);
    }

    //Initialize 1st row
    for (int j=1; j<colCount; j++) {
      dp[0][j] = new Pair(grid[0][j] * dp[0][j-1].min, grid[0][j] * dp[0][j-1].max);
    }

    for (int i=1; i<rowCount; i++) {
      for (int j=1; j<colCount; j++) {

        int minProduct = grid[i][j] * Math.min(dp[i-1][j].min, dp[i][j-1].min);
        int maxProduct = grid[i][j] * Math.max(dp[i-1][j].max, dp[i][j-1].max);

        dp[i][j] = new Pair(Math.min(minProduct, maxProduct), Math.max(minProduct, maxProduct));
      }
    }

    return dp[rowCount-1][colCount-1].max < 0 ? -1 : dp[rowCount-1][colCount-1].max;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,-2,1},{1,-2,1},{3,-4,1}};
    //recursionSolution(0,0, grid, 1);
    //System.out.println(maxProduct);
    System.out.println(maxProductPath(grid));
  }


}

class Pair {
  int min;
  int max;

  public Pair(int min, int max) {
    this.min = min;
    this.max = max;
  }
}

