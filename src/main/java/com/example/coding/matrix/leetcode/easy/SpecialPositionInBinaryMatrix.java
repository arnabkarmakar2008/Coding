package com.example.coding.matrix.leetcode.easy;

/**
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 *
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and
 * column j are 0 (rows and columns are 0-indexed).
 */
public class SpecialPositionInBinaryMatrix {

  public static int numSpecial(int[][] mat) {
    int count = 0;
    int row = mat.length;
    int col = mat[0].length;

    int[] colArray = new int[col];
    int[] rowArray = new int[row];

    for (int i = 0; i < mat.length; i++) {
      for (int j=0; j< mat[i].length; j++) {
        if (mat[i][j] == 1) {
          rowArray[i]++;
          colArray[j]++;
        }
      }
    }

    for (int i = 0; i < mat.length; i++) {
      for (int j=0; j< mat[i].length; j++) {
        if (mat[i][j] == 1 && colArray[j] == 1 && rowArray[i] == 1) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};

    System.out.println(numSpecial(mat));
  }
}
