package com.example.coding.matrix.basic;

public class Rotate90DegreeAntiClockWise {

  public static void transpose(int[][] mat, int n) {
    for  (int i=0; i<n; i++) {
      for (int j=i; j<n; j++) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
      }
    }
  }

  public static void reverseColumn(int[][] mat, int n) {
    for (int col=0; col<n; col++) {
      for (int row=0, k=n-1; row<k; row++, k--) {
        int temp = mat[row][col];
        mat[row][col] = mat[k][col];
        mat[k][col] = temp;
      }
    }
  }

  public static void main(String[] args) {
    //Rotate matrix 90 degree anti-clock wise
    int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

    //To rotate, first transpose(row to column and column to row), then reverse column
    transpose(mat, 3);
    reverseColumn(mat, 3);

    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        System.out.print(" " + mat[i][j] + " ");
      }
      System.out.println();
    }
  }
}
