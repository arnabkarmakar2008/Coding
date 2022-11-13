package com.example.coding.matrix.leetcode.medium;

/**
 * In a gold mine grid of size m x n, each cell in this mine has an integer representing
 * the amount of gold in that cell, 0 if it is empty.
 *
 * Return the maximum amount of gold you can collect under the conditions:
 *
 * Every time you are located in a cell you will collect all the gold in that cell.
 * From your position, you can walk one step to the left, right, up, or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that has some gold.
 */
public class PathWithMaxGold {
  private static int result = Integer.MIN_VALUE;
  public static int getMaximumGold(int[][] grid) {
    int maxPath = Integer.MIN_VALUE;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i=0; i<grid.length;i++) {
      for (int j=0; j<grid[0].length;j++) {
        maxPath(grid, i, j, 0);
      }
    }//
    return result;
  }

  public static void maxPath(int[][] grid, int row, int col, int sum) {

    if (row <0 || col < 0 || row >= grid.length || col >= grid[0].length ||
    grid[row][col] == 0) {
      result = Math.max(result, sum);
      return;
    }

    int cellVal = grid[row][col];
    grid[row][col] = 0; //to mark visited

    maxPath(grid, row+1, col, sum + cellVal);
    maxPath(grid, row-1, col, sum + cellVal);
    maxPath(grid, row, col+1, sum + cellVal);
    maxPath(grid, row, col-1, sum + cellVal);

    grid[row][col] = cellVal; //backtracking

  }

  public static void main(String[] args) {
    int[][] grid = {{0,6,0},{5,8,7},{0,10,0}};
    System.out.println(getMaximumGold(grid));
  }
}
