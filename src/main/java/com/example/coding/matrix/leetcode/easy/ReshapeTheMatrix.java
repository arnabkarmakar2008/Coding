package com.example.coding.matrix.leetcode.easy;

/**
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a
 * new one with a different
 * size r x c keeping its original data.
 *
 * You are given an m x n matrix mat and two integers r and c representing the number of rows
 * and the number of columns of the wanted reshaped matrix.
 *
 * The reshaped matrix should be filled with all the elements of the original matrix in the
 * same row-traversing order as they were.
 *
 * If the reshape operation with given parameters is possible and legal, output the new reshaped
 * matrix; Otherwise, output the original matrix.
 */
public class ReshapeTheMatrix {

  public static int[][] matrixReshape(int[][] mat, int r, int c) {
    int[][] array = new int[r][c];

    if (mat.length * mat[0].length != r*c) {
      System.out.println("Not possible");
      return mat;
    }

    int newRow = 0;
    int newColumn = 0;
    int count = 0;
    for (int i=0; i< mat.length; i++) {
      for (int j=0; j< mat[0].length; j++) {
        count++;

        if (count <= c) {
          array[newRow][newColumn] = mat[i][j];
          newColumn ++;
        } else {
          newRow++;
          newColumn = 0;
          count = 0;
          array[newRow][newColumn] = mat[i][j];
          newColumn++;
        }
      }
    }

    return array;
  }

  //Concise solution
  public static int[][] conciseSolution(int[][] mat, int r, int c) {
    int matRow = mat.length;
    int matCol = mat[0].length;

    if (matRow*matCol != r*c) {
      return mat;
    }

    int[][] resArray = new int[r][c];

    for (int i=0; i<r*c; i++) {
      resArray[i/c][i%c] = mat[i/matCol][i%matCol];
    }

    return resArray;
  }

  public static void main(String[] args) {
    int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    int[][] res = matrixReshape(arr, 3, 8);
    System.out.println(res);
  }
}
