package com.example.coding.matrix.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an m x n grid. Each cell of grid represents a street. The street of grid[i][j] can be:
 *
 * 1 which means a street connecting the left cell and the right cell.
 * 2 which means a street connecting the upper cell and the lower cell.
 * 3 which means a street connecting the left cell and the lower cell.
 * 4 which means a street connecting the right cell and the lower cell.
 * 5 which means a street connecting the left cell and the upper cell.
 * 6 which means a street connecting the right cell and the upper cell.
 */
public class CheckIfValidPathInGrid {

  public static int[][][] direction = new int[][][]{
          {{0, -1}, {0, 1}},
          {{-1, 0}, {1, 0}},
          {{0, -1}, {1, 0}},
          {{0, 1}, {1, 0}},
          {{0, -1}, {-1, 0}},
          {{-1, 0}, {0, 1}}
  };
  public static boolean hasValidPath(int[][] grid) {

    int rows = grid.length;;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];

    return dfs(grid, rows, cols, 0,0,visited);
  }

  public static boolean dfs (int[][] grid,int rows, int cols, int row, int col, boolean[][] visited) {
    if (row == rows-1 && col == cols-1) {
      return true;
    }

    visited[row][col] = true;

    for (int[] dir : direction[grid[row][col]-1]) {
      int newR = row + dir[0];
      int newC = col + dir[1];

      if (newR <0 || newC < 0 || newR >= rows || newC >= cols || visited[newR][newC] == true)
        continue;
      // Main logic is here. We need to move to cell from which we can come back. Then only cells are connected.
      // With 6, we can move from UP->Right. Then in the Right cell should have value to move left and up cell has value to
      //move down

      for (int[] newdir : direction[grid[newR][newC]-1]) {
        if (newR + newdir[0] == row && newC + newdir[1] == col) {
          if (dfs(grid, rows,cols, newR, newC, visited)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] grid = {{2,4,3},{6,5,6}};
    System.out.println(hasValidPath(grid));

  }
}
