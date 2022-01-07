package com.example.coding.matrix.leetcode.easy;

public class SpecialPositionInBinaryMatrix {

  public static int numSpecial(int[][] mat) {
    int count = 0;

    for (int i = 0; i < mat.length; i++) {
      for (int j=0; j< mat[i].length; j++) {
        if (mat[i][j] == 1 || mat[j][i] == 1) {

        }
      }
    }
    return 0;
  }

  public static void main(String[] args) {

  }
}
