package com.example.coding.matrix.leetcode.medium;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {

  //Note : Dynamic Programming
  public static int minPathSum(int[][] grid) {
    int result = -1;
    int rows = grid.length;;
    int cols = grid[0].length;

    for (int i=0; i < rows; i++) {
      for (int j=0; j < cols; j++) {
        if (i == 0 && j == 0) {
          grid[i][j] = grid[i][j];
        } else if (i == 0 && j != 0) {
          grid[i][j] = grid[i][j] + grid[i][j-1];
        } else if (i != 0 && j == 0) {
          grid[i][j] = grid[i][j] + grid[i-1][j];
        } else {
          grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
        }
      }
    }

    return result = grid[rows-1][cols-1];
  }

  public static void main(String[] args) {
    int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
    System.out.println(minPathSum(grid));
  }
}
