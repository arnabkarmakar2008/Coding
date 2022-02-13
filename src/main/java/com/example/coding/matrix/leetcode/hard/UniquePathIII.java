package com.example.coding.matrix.leetcode.hard;

/**
 * You are given an m x n integer array grid where grid[i][j] could be:
 *
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square,
 * that walk over every non-obstacle square exactly once.
 */
public class UniquePathIII {

  /**
   * We have to travel all 0 cells to reach end cell.
   * So we have to count total number of 0s. And when we reach destination cell we have to see if we have
   * visited all 0's or not. If yes then return 1.
   *
   * Also as we have to return all possible paths, we have to backtrack. So make visited cell as unvisited
   * for backtrack.
   * @param grid
   * @return
   */

  public static int numberOfZeros = 0;
  public static int result = 0;

  public static int uniquePathsIII(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    int startX = -1;
    int startY = -1;

    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        if (grid[i][j] == 1) {
          startX = i;
          startY = j;
        }

        if (grid[i][j] == 0) {
          numberOfZeros++;
        }
      }
    }

    dfs(grid, startX, startY);
    return result;

  }

  public static void dfs(int[][] grid, int startX, int startY) {
    //base condition
    if (startX < 0 || startY < 0 || startX >= grid.length || startY >= grid[0].length) {
      return;
    }

    if (grid[startX][startY] == -1) {
      return;
    }

    if (grid[startX][startY] == 2) {
      if (numberOfZeros == -1) { //As we are changing cell 1 to -1 so counting extra zero.
        result++;
      }
      return;
    }

    grid[startX][startY] = -1;
    numberOfZeros--;

    dfs(grid, startX+1, startY);
    dfs(grid, startX-1, startY);
    dfs(grid, startX, startY+1);
    dfs(grid, startX, startY-1);

    grid[startX][startY] = 0; //backtracking tricks
    numberOfZeros++;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
    int paths = uniquePathsIII(grid);
    System.out.printf("paths = " + paths);
  }
}
