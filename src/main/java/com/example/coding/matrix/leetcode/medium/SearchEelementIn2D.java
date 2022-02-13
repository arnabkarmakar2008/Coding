package com.example.coding.matrix.leetcode.medium;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchEelementIn2D {

  public static boolean searchMatrix(int[][] matrix, int target) {

    int rows = matrix.length;;
    int cols = matrix[0].length;

    int startRow = 0;
    int startCol = cols-1;

    while (startRow < rows && startCol >=0) {
      if (matrix[startRow][startCol] == target) {
        return true;
      } else if (target < matrix[startRow][startCol]) {
        startCol--;
      } else if (target > matrix[startRow][startCol]) {
        startRow++;
      }
    }
    return false;
  }

  public static boolean binarySearchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;;
    int cols = matrix[0].length;

    int begin = 0;
    int end = rows*cols-1;

    while (begin <= end) {
      int mid = (begin+end)/2;
      int midValue = matrix[mid/cols][mid%cols];

      if (midValue == target) {
        return true;
      } else if (target < midValue) {
        end = mid - 1;
      } else if (target > midValue) {
        begin = mid + 1;
      }
    }

    return false;
  }



  public static void main(String[] args) {
    int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    int target = 23;
    System.out.println(searchMatrix(matrix, target));

    System.out.println(binarySearchMatrix(matrix, target));
  }
}
