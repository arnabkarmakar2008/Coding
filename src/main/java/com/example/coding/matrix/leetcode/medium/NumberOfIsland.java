package com.example.coding.matrix.leetcode.medium;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIsland {

  public static int[][] dimensions = {{0,1},{0,-1},{1,0},{-1,0}};
  public static int numIslands(char[][] grid) {
    int count = 0;

    for (int i=0; i< grid.length; i++) {
      for (int j=0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          count++;
        }
      }
    }


    return count;
  }

  public static void dfs(char[][] grid, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
      return;
    }

    grid[row][col] = '0';

    for (int i=0; i< dimensions.length; i++) {
      dfs(grid, row + dimensions[i][0], col + dimensions[i][1]);
    }
  }

  public static void main(String[] args) {
    char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'1','0','0','0','0'},{'0','0','0','1','1'}};
    System.out.println(numIslands(grid));
  }
}
