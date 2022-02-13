package com.example.coding.matrix.leetcode.medium;

public class DetectCyclesIn2DGrid {
  public static int[][] dimension = {{0,1},{0,-1},{1,0},{-1,0}};

  public static boolean containsCycle(char[][] grid) {
    int rows = grid.length;;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    boolean flag = false;
    for (int i=0; i<rows; i++) {
      if (flag) break;
      for (int j=0; j< cols; j++) {
        if (grid[i][j] != 'x') {
          flag = dfs(grid, i, j, -1, -1, visited, grid[i][j]);
          if (flag) break;
        }
      }
    }

    if (flag) {
      System.out.println("Cycle detected");
    }

    return flag;

  }

  public static boolean dfs (char[][] grid, int row, int col, int parentRow, int parentCol, boolean[][] visited, char startChar) {

    boolean hasCycle = false;
    visited[row][col] = true;

    for (int i=0; i<4; i++) {
      int newR = row + dimension[i][0];
      int newC = col + dimension[i][1];

      if (newR < 0 || newC <0 || newR >= grid.length || newC >= grid[0].length) {
        continue;
      }

      //Do not visit parent cell again
      if (!(newR == parentRow && newC == parentCol)) {
        if (grid[newR][newC] == startChar) {
          if (visited[newR][newC]) {
            return true;
          } else {
            hasCycle = hasCycle | dfs (grid, newR, newC, row, col, visited, startChar);
          }
        }
      }

    }

    return hasCycle;
  }

  public static void main(String[] args) {
    char[][] grid = {{'a','a','a','a'},{'c','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
    containsCycle(grid);
  }
}
