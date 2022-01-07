package com.example.coding.matrix.leetcode.easy;

import java.util.Arrays;

/**
 * Given two n x n binary matrices mat and target, return true if it is possible to
 * make mat equal to target by rotating mat in 90-degree increments,
 * or false otherwise.
 */
public class MatrixCanBeObtainedBy90Rotation {

  //Note : 90 degree rotation = Reverse rows order and transpose
  public static void rotate(int[][] matrix) {
    int length = matrix.length;

    //Reverse rows order
    for (int i=0, j=length-1; i<j; i++,j--) {
      int[] temp = matrix[i];
      matrix[i] = matrix[j];
      matrix[j] = temp;
    }

    //transpose
    for (int i=0; i<matrix.length; i++) {
      for (int j=1; j<matrix.length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }

  public static boolean findRotation(int[][] mat, int[][] target) {

    //Need to rotate matrix max 4 times
    for (int i=0; i<4; i++) {
      if (Arrays.deepEquals(mat, target)) {
        return true;
      }

      rotate(mat);


    }
    return false;
  }

  public static void main(String[] args) {
    int[][] src = {{0,1},{1,1}};
    int[][] target = {{1,0},{0,1}};

    System.out.println(findRotation(src, target));
  }


}
