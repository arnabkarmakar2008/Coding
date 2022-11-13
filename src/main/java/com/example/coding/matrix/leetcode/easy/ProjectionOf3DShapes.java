package com.example.coding.matrix.leetcode.easy;

/**
 * You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y,
 * and z axes.
 *
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j).
 *
 * We view the projection of these cubes onto the xy, yz, and zx planes.
 *
 * A projection is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane.
 * We are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 *
 * Return the total area of all three projections.
 */
public class  ProjectionOf3DShapes {

  /**
   * Note : Top = If cell value if not zero then area is 1.
   *  Front : Take max value of each column
   *  Side : Take max value of each row
   * @param grid
   * @return
   */

  public static int projectionArea(int[][] grid) {
    int front = 0;
    int side = 0;
    int top = 0;

    for (int i=0; i< grid.length; i++) {
      int rowMax = 0;
      int colMax = 0;
      for (int j=0; j<grid[i].length; j++) {
        if (grid[i][j] != 0) {
          top++;
        }

        rowMax = Math.max(rowMax, grid[i][j]);
        colMax = Math.max(colMax, grid[j][i]);

      }

      side = side + rowMax;
      front = front + colMax;
    }

    return top+front+side;

  }

  public static void main(String[] args) {
    int[][] grid = {{1,2},{3,4}};
    System.out.println(projectionArea(grid));
  }
}
