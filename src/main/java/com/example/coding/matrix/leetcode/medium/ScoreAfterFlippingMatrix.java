package com.example.coding.matrix.leetcode.medium;

/**
 *
 * You are given an m x n binary matrix grid.
 *
 * A move consists of choosing any row or column and toggling each value in that row or
 * column (i.e., changing all 0's to 1's, and all 1's to 0's).
 *
 * Every row of the matrix is interpreted as a binary number, and the score of the matrix is
 * the sum of these numbers.
 *
 * Return the highest possible score after making any number of moves (including zero moves).
 */

public class ScoreAfterFlippingMatrix {
  /**
   * Note : Have to flip binary for all rowas starting with 0. Because to increase binary value we have to make more
   * left ones. Then if for a column number of ones is less or equal to row then flip that column.
   * @param
   * @return
   */

  public static void flipRow(int[][] grid, int row) {
    for (int i=0; i<grid[row].length; i++) {
      if (grid[row][i] == 0) {
        grid[row][i] = 1;
      } else {
        grid[row][i] = 0;
      }
    }
  }

  public static void flipColumn(int[][] grid, int column) {
    for (int i=0; i<grid.length; i++) {
      if (grid[i][column] == 0) {
        grid[i][column] = 1;
      } else {
        grid[i][column] = 0;
      }
    }
  }



  public static double matrixScore(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    int[] oneCount = new int[col];

    for (int i=0; i < row; i++) {

      if (grid[i][0] == 0) {
        flipRow(grid, i);
      }

      for (int j=0; j<col; j++) {
        if (grid[i][j] == 1) {
          oneCount[j]++;
        }
      }
    }

    // Flip column where 1 count is less or equal to half of rows
    for (int i=0; i < oneCount.length; i++) {
      if (oneCount[i] <= row/2) {
        flipColumn(grid, i);
      }
    }

    double sum = 0;

    for (int i=0; i<row; i++) {
      double rowSum = 0;
      for (int j=col-1; j>=0; j--) {
        if (grid[i][j] == 1) {
          rowSum = rowSum + Math.pow(2, (col-1-j));
        }
      }

      sum = sum + rowSum;
    }

    return sum;
  }

  public static void main(String[] args) {
    int[][] grid = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
    System.out.println(matrixScore(grid));
  }
}
