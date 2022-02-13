package com.example.coding.dynamicprogramming.leetcode.grid;

public class MaxNonNegativeProductInMatrix {

  public static int maxProductPath(int[][] grid) {
    int rowCount = grid.length;;
    int colCount = grid[0].length;

    int[][] dp = new int[rowCount][colCount];

    dp[0][0] = grid[0][0] > 0 ? grid[0][0] : -1;

    for (int i=1; i<rowCount; i++) {
      dp[i][0] = grid[i][0] * grid[i-1][0] > 0 ? grid[i][0] * grid[i-1][0] : -1;
    }

    for (int j=1; j<colCount; j++) {
      dp[0][j] = grid[0][j] * grid[0][j-1] > 0 ? grid[0][j] * grid[0][j-1] : -1;
    }

    for (int i=1; i<rowCount; i++) {
      for (int j=1; j<colCount; j++) {

        if (i >= rowCount || j >= colCount) {
          continue;
        }

        int topMax = dp[i][j] * dp[i-1][j];
        int bottomMax = dp[i][j] * dp[i][j-1];
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,-2,1},{1,-2,1},{3,-4,1}};

  }
}
