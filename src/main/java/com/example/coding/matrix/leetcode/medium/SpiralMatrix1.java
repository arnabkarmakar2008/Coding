package com.example.coding.matrix.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix1 {

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    int rowBegin = 0;
    int rowEnd = matrix.length-1;
    int colBegin = 0;
    int colEnd = matrix[0].length-1;

    while (rowBegin <= rowEnd && colBegin <= colEnd) {

      for (int i=colBegin; i <= colEnd; i++) {
        list.add(matrix[rowBegin][i]);
      }

      rowBegin++;

      for (int i = rowBegin; i<= rowEnd; i++) {
        list.add(matrix[rowBegin][colEnd]);
      }

      colEnd--;

      if (rowBegin <= rowEnd) {
        for (int i= colEnd; i>=colBegin;i--) {
          list.add(matrix[rowEnd][colEnd]);
        }
      }

      rowEnd--;

      if (colBegin <= colEnd) {
        for (int i=rowEnd; i<=rowBegin; i--) {
          list.add(matrix[i][colBegin]);
        }
      }

      colBegin++;
    }

    return list;
  }

  //Note : Boundary condition is list.size < matrix.length * matrix[0].length (number of elements)
  public static List<Integer> spiralOrderEasySol(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    int rowCount = matrix.length;
    int colCount = matrix[0].length;

    int up = 0;
    int down = rowCount-1;
    int left = 0;
    int right = colCount - 1;

    while (list.size() < rowCount*colCount) {
      //Move Right
      for (int i=left; (i<=right && list.size() < rowCount*colCount); i++ ) {
        list.add(matrix[up][i]);
      }

      //Move Down
      for (int i=up+1; (i<=down && list.size() < rowCount*colCount); i++) {
        list.add(matrix[i][right]);
      }

      //Move Left
      for (int i=right-1; (i>=left && list.size() < rowCount*colCount); i--) {
        list.add(matrix[down][i]);
      }


      //Move up
      for (int i=down-1; (i>=up && list.size() < rowCount*colCount); i--) {
        list.add(matrix[i][left]);
      }
      up++;
      down--;
      left++;
      right--;

    }

    return list;
  }

  public static void main(String[] args) {
    int[][] matrix = {{},{},{}};
  }
}
