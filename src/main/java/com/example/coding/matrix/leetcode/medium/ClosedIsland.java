package com.example.coding.matrix.leetcode.medium;

/**
 * Given a 2D grid consists of 0s (land) and 1s (water).
 * An island is a maximal 4-directionally connected group of 0s and a closed island
 * is an island totally (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 */
public class ClosedIsland {

  public static int[][] dimension = {{0,1},{0,-1},{1,0},{-1,0}};

  public static int closedIsland(int[][] grid) {
    int count = 0;
    for(int i=0; i< grid.length; i++) {
      for (int j=0; j<grid[0].length; j++) {
        if (grid[i][j] == 0) {
          if (dfs(grid, i, j))
          {
            count++;
          }
        }
      }
    }

    return count;
  }

  public static boolean dfs(int[][] grid, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
      return false;
    }

    if (grid[row][col] == 1) {
      return true;
    }

    grid[row][col] = 1; // visited
    boolean result = true;
    for (int i=0; i<dimension.length; i++) {
      result = result & dfs(grid, row+dimension[i][0], col+dimension[i][1]);
    }

    return result;

  }

  public static void main(String[] args) {
    int[][] grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
    System.out.println(closedIsland(grid));
  }


}
