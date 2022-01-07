package com.example.coding.matrix.leetcode.medium;

/**
 * You are given two arrays rowSum and colSum of non-negative integers where rowSum[i] is the sum of the
 * elements in the ith row and colSum[j]
 * is the sum of the elements of the jth column of a 2D matrix. In other words, you do not know the
 * elements of the matrix, but you do know the sums of each row and column.
 *
 * Find any matrix of non-negative integers of size rowSum.length x colSum.length that satisfies the
 * rowSum and colSum requirements.
 *
 * Return a 2D array representing any matrix that fulfills the requirements. It's guaranteed that at least
 * one matrix that fulfills the requirements exists.
 */
public class ValidMatrixGivenRowAndColSum {
  public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    int[][] mat = new int[rowSum.length][colSum.length];

    for (int i=0; i< rowSum.length; i++) {
      for (int j=0; j< colSum.length; j++) {
        int temp = Math.min(rowSum[i], colSum[j]);
        mat[i][j] = temp;
        rowSum[i] = rowSum[i] - temp;
        colSum[j] = colSum[j] - temp;
      }
    }
    return mat;
  }

  public static void main(String[] args) {
    int[] rowSum = {3,8};
    int[] colSum = {4,7};

    System.out.println(restoreMatrix(rowSum, colSum)[0]);
  }
}
