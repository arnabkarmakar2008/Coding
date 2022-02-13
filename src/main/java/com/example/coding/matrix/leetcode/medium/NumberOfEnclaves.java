package com.example.coding.matrix.leetcode.medium;

/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 *
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell
 * or walking off the boundary of the grid.
 *
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 */
public class NumberOfEnclaves {
  //Note : DFS Problem. Start DFS from boundary cells value 1. Change those to 0. Then count number of
  //remaining 1's in the grid.

  public static int numEnclaves(int[][] grid) {
    int count = 0;

    int rows = grid.length;;
    int cols = grid[0].length;

    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        if (i == 0 || i == rows-1 || j ==0 || j == cols-1) {
          if (grid[i][j] == 1) {
            dfs (grid, i, j);
          }
        }
      }
    }

    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        if (grid[i][j] == 1) {
          count++;
        }
      }
    }

    return count;
  }

  public static void dfs (int[][] grid, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
      return;
    }

    grid[row][col] = 0;
    dfs (grid, row+1, col);
    dfs (grid, row-1, col);
    dfs (grid, row, col+1);
    dfs (grid, row, col-1);
  }

  public static void main(String[] args) {
    int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
    System.out.println(numEnclaves(grid));
  }
}
