package com.example.coding.matrix.leetcode.hard;

/**
 * You are given an m x n binary grid grid where 1 represents land and 0
 * represents water. An island is a maximal 4-directionally (horizontal or vertical)
 * connected group of 1's.
 *
 * The grid is said to be connected if we have exactly one island, otherwise is said disconnected.
 *
 * In one day, we are allowed to change any single land cell (1) into a water cell (0).
 *
 * Return the minimum number of days to disconnect the grid.
 */
public class MinDaysToDisconnectIsland {

  /**
   * Island can be disconnected in max 2 days. Idea is change each cell to 0 and see the number of island. If more than
   * 2 then in a single day it can be disconnected. Else return 2.
   * @param grid
   * @return
   */
  public static int minDays(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    if (numberOfIsland(grid) != 1) {
      return 0;
    }

    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        grid[i][j] = 0; // change cell to 0. Then count number of island. If there are more than one island then max 1 day required.

        if (numberOfIsland(grid) != 1) {
          return 1;
        }

        grid[i][j] = 1; // change it back to 1.
      }
    }

    return 2;

  }

  private static int numberOfIsland(int[][] grid) {
    int answer = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];

    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        if (visited[i][j] == false && grid[i][j] == 1) {
          answer++;
          dfs(grid, i, j, visited);
        }
      }
    }

    return answer;
  }

  private static void dfs(int[][] grid, int i, int j, boolean[][] visited) {
    if (i <0 || j<0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
      return;
    }

    visited[i][j] = true;

    dfs(grid, i+1, j, visited);
    dfs(grid, i-1, j, visited);
    dfs(grid, i, j+1, visited);
    dfs(grid, i, j-1, visited);
  }

  public static void main(String[] args) {
    int[][] grid = {{0,1,1,0},{0,1,1,0},{0,0,0,0}};
    System.out.println(minDays(grid));
  }
}
