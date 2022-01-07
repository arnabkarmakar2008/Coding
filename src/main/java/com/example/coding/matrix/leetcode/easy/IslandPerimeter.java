package com.example.coding.matrix.leetcode.easy;

public class IslandPerimeter {

  public static int islandPerimeter(int[][] grid) {
    int peri = 0;

    for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid[i].length; j++) {
        if (grid[i][j] != 0) {

          if (invalidCell(i - 1, j, grid.length, grid[i].length)) {
            peri = peri + 1;
          } else {
            if (grid[i - 1][j] == 0) peri = peri + 1;
          }

          if (invalidCell(i + 1, j, grid.length, grid[i].length)) {
            peri = peri + 1;
          } else {
            if (grid[i + 1][j] == 0) peri = peri + 1;
          }

          if (invalidCell(i, j - 1, grid.length, grid[i].length)) {
            peri = peri + 1;
          } else {
            if (grid[i][j - 1] == 0) peri = peri + 1;
          }

          if (invalidCell(i, j + 1, grid.length, grid[i].length)) {
            peri = peri + 1;
          } else {
            if (grid[i][j + 1] == 0) peri = peri + 1;
          }
        }
      }
    }

    return peri;
  }

  public static boolean invalidCell(int i, int j, int row, int column) {
    if (i < 0 || i > row-1 || j < 0 || j > column-1) return true;
    return false;
  }

  public static void main(String[] args) {
    //int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    int[][] grid = {{1,0}};
    System.out.println(islandPerimeter(grid));
  }
}
