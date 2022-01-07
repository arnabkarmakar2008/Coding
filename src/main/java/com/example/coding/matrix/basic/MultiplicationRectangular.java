package com.example.coding.matrix.basic;

public class MultiplicationRectangular {

  public static int[][] multiply(int[][] a, int row1, int col1, int[][] b, int row2, int col2 ) {
    if (col1 != row2) {
      System.out.println("Not possible");
      return null;
    }

    int[][] res = new int[row1][col2];

    for (int i=0; i < res.length; i++) {
      for (int j=0; j<col2; j++) {
        res[i][j] = 0;

        for (int k=0; k<col1; k++) {
          res[i][j] = res[i][j] + (a[i][k]*b[k][j]);
        }
      }
    }

    return res;

  }

  public static void main(String[] args) {
    int[][] a = {{2,3},{2,3}};
    int[][] b = {{2,3},{2,3}};

    int[][] res;

    res = multiply(a, 2,2, b, 2, 2);

    for (int i=0; i< res.length; i++) {
      for (int j=0; j<res[i].length; j++) {
        System.out.print(" " + res[i][j] + " ");
      }

      System.out.println("/n");

    }
  }

}
