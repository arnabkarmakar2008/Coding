package com.example.coding.matrix.leetcode.medium;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrix2 {

  public static int[][] generateMatrixWithDirection(int n) {
    int[][] mat = new int[n][n];

    int up = 0;
    int down = n-1;
    int left = 0;
    int right = n-1;
    int counter = 0;
    int direction = 0; //0 -> right 1 -> down 2-> left 3 -> up

    while (up<= down && left<=right) {
      if (direction == 0) {
        for (int i= left; i <= right; i++) {
          mat[up][i] = ++counter;
        }

        up = up + 1;
      } else if (direction == 1) {
        for (int i= up; i <= down; i++) {
          mat[i][right] = ++counter;
        }

        right = right - 1;
      } else if (direction == 2) {
        for (int i= right; i >= left; i--) {
          mat[down][i] = ++counter;
        }

        down = down -1;
      } else if (direction == 3) {
        for (int i= down; i >= up; i--) {
          mat[i][left] = ++counter;
        }

        left = left + 1;
      }

      direction = (direction+1)%4;

    }

    return mat;

  }



  public static int[][] generateMatrix(int n) {
    int[][] mat = new int[n][n];

    int up = 0;
    int down = n-1;
    int left = 0;
    int right = n-1;

    int counter = 0;

    while (up <= down && left <= right) {

      //Move Right
      for (int i=left; (i<=right && counter <= n*n); i++) {
        mat[up][i] = ++counter;
      }

      //Move down
      for (int i = up+1; (i <= down && counter <= n*n); i++) {
        mat[i][right] = ++counter;
      }

      //Move left
      for (int i = right-1; (i >= left && counter <= n*n); i--) {
        mat[down][i] = ++counter;
      }

      //Move Up
      for (int i = down-1; (i > up && counter <= n*n); i--) {
        mat[i][left] = ++counter;
      }

      up++;
      down--;
      left++;
      right--;
    }

    return mat;
  }

  public static void main(String[] args) {
    //int[][] mat = generateMatrix(4);
    int[][] mat = generateMatrixWithDirection(4);

    for (int i=0; i<4; i++) {
      for (int j=0; j<4; j++) {
        System.out.print("    " + mat[i][j] + "    ");
      }
      System.out.println();
    }
  }
}
