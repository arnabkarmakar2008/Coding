package com.example.coding.matrix.leetcode.easy;

public class DiagonalSum {

  public static int diagonalSum(int[][] mat) {

    int length = mat.length;
    int collength = mat[0].length;
    int sec = 0;
    int main = 0;

    if (length == 1) {
      return mat[0][0];
    }

    boolean odd = length%2 != 0 ? true: false;
    int i = 0;
    for (int k=collength-1, j=0; (k>=0 && j<=collength-1); k--, j++) {

      main = main + mat[i][j];

      if (odd && k==j) {
        sec = sec;
      } else {
        sec = sec + mat[i][k];
      }

      i++;

    }


    return sec+main;

  }

  public static void main(String[] args) {
    int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println(diagonalSum(arr));
  }
}
