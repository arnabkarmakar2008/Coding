package com.example.coding.matrix.leetcode.medium;

/**
 * You are given an m x n integer matrix grid, and three integers row, col, and color.
 * Each value in the grid represents the color of the grid square at that location.
 *
 * Two squares belong to the same connected component if they have the same color and are next to
 * each other in any of the 4 directions.
 *
 * The border of a connected component is all the squares in the connected component that are either
 * 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
 *
 * You should color the border of the connected component that contains the square grid[row][col]
 * with color.
 *
 * Return the final grid.
 */
public class ColoringBorder {

  /**
   * https://www.youtube.com/watch?v=R3AJoOBVAlg&t=737s
   */

  public static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
    dfs(grid, row, col, grid[row][col]);

    for (int i=0; i< grid.length; i++) {
      for (int j=0; j< grid[0].length; j++) {
        if (grid[i][j] < 0) {
          grid[i][j] = color;
        }
      }
    }

    return grid;
  }

  //Note: We have to color all connected cells. But if in the connected component there are cells which has
  // same neighbour on all 4 sides we have to exclude
  public static void dfs(int[][] grid, int row, int col, int color) {
    grid[row][col] = -color; // color cell with negative color value :: just to count visited one
    int count = 0; // Count the neighbour with same color

    for (int i=0; i<4; i++) {
      int newR = row + dir[i][0];
      int newC = col + dir[i][1];

      if (newR < 0 || newC < 0 || newR >= grid.length || newC >= grid[0].length
              || Math.abs(grid[newR][newC]) != color) {

        // here neighbour cell can be -ve color value. That is why taking abs value.
        continue;
      }

      // This neighbour cell is either +ve color or +ve color value. If -ve then just increase count but do not call dfs.

      count++;
      // During dfs color can be -ve but that is visited. So increase count but do not call dfs.

      if (grid[newR][newC] == color) {
        // As positive color cell, call dfs.
        dfs (grid, newR, newC, color);
      }


      //During backtrack check count. If all neighbours are same color then change it back to +ve so that
      // we can color only border
      if (count == 4) {
        // This will eliminate cell with all four sides of same color. If count==4 the change it back to original.
        grid[row][col] = color;
      }
    }


  }

  public static void main(String[] args) {
    int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
    colorBorder(grid, 1, 1, 2);
  }

}
