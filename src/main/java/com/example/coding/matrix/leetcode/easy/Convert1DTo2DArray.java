package com.example.coding.matrix.leetcode.easy;

public class Convert1DTo2DArray {

  public static int[][] construct2DArray(int[] original, int m, int n) {
    int[][] newArray = new int[m][n];
    int len = original.length;

    if (len != m*n) {
      return newArray;
    }

    for (int i=0; i<len; i++) {
      newArray[i/n][i%n] = original[i];
    }


    return newArray;
  }

  public static void main(String[] args) {
    int[] array = {0,1,2,3,4,5};
    int[][] newArray = construct2DArray(array, 3,2);
  }
}
