package com.example.coding.matrix.leetcode.medium;

/**
 * Write an efficient algorithm that searches for a target value in an m x n integer
 * matrix. The matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class SearchElementin2DGrid {

  public static boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    int indexRow = 0;
    int indexCol = cols-1;

    while (indexRow < rows && indexCol >= 0) {
      if (target == matrix[indexRow][indexCol]) {
        return true;
      } else if (target < matrix[indexRow][indexCol]) {
        indexCol--;
      } else if (target > matrix[indexRow][indexCol]) {
        indexRow ++;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
    int target = 22;

    System.out.println(searchMatrix(grid, target));
  }
}
