package com.example.coding.matrix.leetcode.medium;

/**
 * You are given two m x n binary matrices grid1 and grid2 containing
 * only 0's (representing water) and 1's (representing land). An island is a group of 1's
 * connected 4-directionally (horizontal or vertical). Any cells outside of the grid are
 * considered water cells.
 *
 * An island in grid2 is considered a sub-island if there is an island in grid1 that
 * contains all the cells that make up this island in grid2.
 *
 * Return the number of islands in grid2 that are considered sub-islands.
 */
public class NumberOfSubIsland {
  public static int countSubIslands(int[][] grid1, int[][] grid2) {
    int rows = grid2.length;;
    int cols = grid2[0].length;
    int count = 0;

    for (int i=0; i< rows; i++) {
      for (int j=0; j < cols; j++) {
        if (grid2[rows][cols] == 1 && isSubIsland(grid1, grid2, i, j)) {
          count++;
        }
      }
    }

    return count;
  }

  public static boolean isSubIsland(int[][] grid1, int[][] grid2, int row, int col) {
    boolean result = true;

    if (row >=0 && row < grid2.length && col >=0 && col < grid2[0].length && grid2[row][col] ==1) {
      if (grid1[row][col] != 1) {
        return false; // This is checking the subisland
      }

      grid2[row][col] = -1; // just to keep track of visited one
      boolean left = isSubIsland(grid1, grid2, row, col-1);
      boolean right = isSubIsland(grid1, grid2, row, col+1);
      boolean up = isSubIsland(grid1, grid2, row-1, col);
      boolean down = isSubIsland(grid1, grid2, row+1, col);

      if (!left || !right || !up || !down) {
        return false;
      }
    }

    return result;
  }
}
