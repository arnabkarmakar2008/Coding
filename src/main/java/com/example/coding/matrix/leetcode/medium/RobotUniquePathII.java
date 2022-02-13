package com.example.coding.matrix.leetcode.medium;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to
 * reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 */
public class RobotUniquePathII {

  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int rows = obstacleGrid.length;
    int cols = obstacleGrid[0].length;

    int[][] grid = new int[rows][cols];

    for (int i=0; i< rows; i++) {
      for (int j=0; j< cols; j++) {
        if (i==0) {
          grid[i][j] = 1;
        }

        if (j==0) {
          grid[i][j] = 1;
        }
      }
    }

    for (int i=1; i< rows; i++) {
      for (int j=1; j<cols; j++) {
        if (obstacleGrid[i][j] == 1) continue;
        int leftCell = obstacleGrid[i][j-1] == 1 ? 0 : grid[i][j-1];
        int upCell = obstacleGrid[i-1][j] == 1 ? 0 : grid[i-1][j];
        grid[i][j] = leftCell + upCell;
      }
    }

    return grid[rows-1][cols-1];
  }

  public static void main(String[] args) {
    //int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
    int[][] obstacleGrid = {{0,1},{0,0}};
    System.out.println(uniquePathsWithObstacles(obstacleGrid));

  }
}
