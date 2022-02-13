package com.example.coding.dynamicprogramming.leetcode.grid;

/**
 * You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.
 *
 * Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.
 *
 * A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
 * A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
 * We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.
 *
 * Return an array answer of size n where answer[i] is the column that the ball falls out of at
 * the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck
 * in the box.
 */
public class WhereWillTheBallFall {

  public static int dfs(int row, int col, int[][] grid) {
    //Base cases
    if (row >= grid.length) {
      return col;
    }

    if (col < 0 || col >= grid[0].length) {
      return -1;
    }

    // If cell value is 1, then next column value on the same row should be 1. Then check for next row and nextt col,
    //diagonal cell
    if (grid[row][col] == 1 && col+1 <= grid[0].length && grid[row][col+1] == 1) {
      return dfs(row+1, col+1, grid);
    }

    // If cell value is -1, then pre column value on the same row should be 1. Then check for next row and prev col,
    //diagonal cell
    if (grid[row][col] == -1 && col-1 >= 0 && grid[row][col-1] == -1) {
      return dfs(row+1, col-1, grid);
    }

    return -1;
  }

  public static int[] findBall(int[][] grid) {
    //Have to call dfs fro each column
    int columnCount = grid[0].length;
    int[] answer = new int[columnCount];

    for (int j=0; j<columnCount; j++) {
      answer[j] = dfs(0, j, grid);
    }

    return answer;

  }

  public static void main(String[] args) {
    int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};

    int[] ans = findBall(grid);

    for (int columnVal : ans) {
      System.out.print(" " + columnVal +" ");
    }
  }
}
