package com.example.coding.matrix.leetcode.medium;

/**
 * A k x k magic square is a k x k grid filled with integers such that every row sum,
 * every column sum,
 * and both diagonal sums are all equal. The integers in the magic square do not have
 * to be distinct. Every 1 x 1 grid is trivially a magic square.
 *
 * Given an m x n integer grid, return the size (i.e., the side length k) of the
 * largest magic square that can be found within this grid.
 */
public class LargestMagicSquare {

  public static int largestMagicSquare(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    int[][] rowSums = new int[rows][cols];
    int[][] colSums = new int[rows][cols];
    int[][] diaSums = new int[rows][cols];
    int[][] antiDiaSums = new int[rows][cols];

    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        if (j==0) {
          rowSums[i][j] = matrix[i][j];
        } else {
          rowSums[i][j] = rowSums[i][j-1] + matrix[i][j];
        }

        if (i == 0) {
          colSums[i][j] = matrix[i][j];
        } else {
          colSums[i][j] = colSums[i-1][j] + matrix[i][j];
        }

        if (i-1 >=0 && j-1 >= 0) {
          diaSums[i][j] = diaSums[i-1][j-1] + matrix[i][j];
        } else {
          diaSums[i][j] = matrix[i][j];
        }

        if (i-1 >= 0 && j+1 < cols) {
          antiDiaSums[i][j] = antiDiaSums[i-1][j+1] + matrix[i][j];
        } else {
          antiDiaSums[i][j] = matrix[i][j];
        }
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    int[][] grid = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
    largestMagicSquare(grid);
  }

}
