package com.example.coding.matrix.leetcode.hard;

/**
 * You are given an n x n grid representing a field of cherries, each cell is one of
 * three possible integers.
 *
 * 0 means the cell is empty, so you can pass through,
 * 1 means the cell contains a cherry that you can pick up and pass through, or
 * -1 means the cell contains a thorn that blocks your way.
 * Return the maximum number of cherries you can collect by following the rules below:
 *
 * Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through
 * valid path cells (cells with value 0 or 1).
 * After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
 * When passing through a path cell containing a cherry, you pick it up, and the cell becomes an
 * empty cell 0.
 * If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
 */
public class CherryPick {

  /**
   *
   * https://www.youtube.com/watch?v=ZV0sUzfA7Eg&t=2089s
   *
   *
   * Rules :: 1. Move right or down from (0,0) to (n-1, n-1) 2. Move left or up from (n-1,n-1) to (0,0)
   * Moving (n-1,n-1) to (0,0) using left and up is equivalent to move right or down from (0,0) to (n-1, n-1).
   * So moving from (0,0) from (n-1,n-1) 2 times.
   * But we cannot pick cherry twice.
   * So assuming 2 people starting from 0,0 and need to reach n-1,n-1.
   * Unique DP state [r1,c1,r2,c2]
   * But any time r1+c1 = r2+c2
   * So we can make DP state as r1,c1,c2. We can derive r2 if we know all 3 values.
   *
   * Transitions : current [r1,c1,c2]
   * r2 = r1+c1-c2
   * if (grid[r1][c1] == 1, pick the cherry ans += grid[r1][c1].
   * Now if (r1!=r2) pick the other cherry as well ans+=grid[r2][c2].
   *
   * Four Move possibilities:
   * 1. right right
   * 2. right down
   * 3. down right
   * 4. down down
   *
   * We have to calculate max from above all and return
   * @param grid
   * @return
   */

  public static int dpHelperFunction(int[][] grid, int[][][][] dp, int r1, int c1, int r2, int c2) {
    if (r1 >= grid.length || r2 >= grid.length || c1 >= grid.length || c2 >= grid.length
    || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
      return Integer.MIN_VALUE;
    }

    if (dp[r1][c1][r2][c2] != 0) return dp[r1][c1][r2][c2]; //memoize

    if (r1 == grid.length-1 && c1 == grid.length-1) {
      return grid[r1][c1]; //Reached bottom-right corner. Max cherry can be collected  = grid[r1][c1]
    }

    int cherries = 0;
    if (r1 == r2 && c1 == c2) {
      cherries = grid[r1][c1];
    } else {
      cherries = grid[r1][c1] + grid[r2][c2];
    }

    int f1 = dpHelperFunction(grid, dp, r1, c1+1, r2,c2+1); // horizontal - horizontal
    int f2 = dpHelperFunction(grid, dp, r1, c1+1, r2+1,c2); // horizontal - vertical
    int f3 = dpHelperFunction(grid, dp, r1+1, c1, r2, c2+1); // vertical - horizontal
    int f4 = dpHelperFunction(grid, dp, r1+1, c1, r2+1, c2); // ver - ver

    cherries += Math.max(f1, Math.max( Math.max(f2,f3),f4));

    return dp[r1][c1][r2][c2] = cherries;
  }

  public static int cherryPickup(int[][] grid) {
    int rows = grid.length;;
    int cols = grid[0].length;

    return dpHelperFunction(grid, new int[rows][cols][rows][cols], 0,0,0,0);
  }

  /**
   * Backtracking solutions
   * @param args
   */

  public static int maxCherryCollected = Integer.MIN_VALUE;
  public static void cpTopLeftToBottomRight(int row, int col, int[][] arr, int ccsp) {

    //Base case
    if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] == -1) {
      return;
    }

    if (row == arr.length-1 && col == arr[0].length-1) {
      // We have reached bottom right corner. Now we have to go back to 0,0 cell. So calling another
      //function which will perform same operation but from bottom right to top left.
      cpBottomRightToTopLeft(row, col, arr, ccsp);
    }

    int cherries = arr[row][col];
    arr[row][col] = 0; //As collected the cheery, change cell to 0;
    cpTopLeftToBottomRight(row+1, col, arr, ccsp+cherries); // As we can go down
    cpTopLeftToBottomRight(row, col+1, arr, ccsp+cherries); // As we can go right

    arr[row][col] = cherries; // As we have to backtrack, setting it back to prev value.

  }

  private static void cpBottomRightToTopLeft(int row, int col, int[][] arr, int ccsp) {

    //Base case
    if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] == -1) {
      return;
    }

    if (row == 0 && col == 0) {
      //We have reached cell 0,0 from bottom-right corner
      maxCherryCollected = Math.max(maxCherryCollected, ccsp);
      return;
    }

    int cherries = arr[row][col];
    arr[row][col] = 0; //As collected the cheery, change cell to 0;
    cpBottomRightToTopLeft(row-1, col, arr, ccsp+cherries); // As we can go up
    cpBottomRightToTopLeft(row, col-1, arr, ccsp+cherries); // As we can go left

    arr[row][col] = cherries; // As we have to backtrack, setting it back to prev value.

  }


  public static void main(String[] args) {
    int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
    System.out.println(cherryPickup(grid));
    //cpTopLeftToBottomRight(0,0, grid, 0);
    //System.out.println(maxCherryCollected);
  }
}
