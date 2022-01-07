package com.example.coding.matrix.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix3 {

  public static List<String> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
    int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    int d = 0;
    int length = 0;

    List<String> list = new ArrayList<>();
    list.add(rStart+"-"+cStart);

    while (list.size() < rows*cols) {

      if (d == 0 || d == 2) {
        length = length+1;
      }

      for (int k=0; k<length; k++) {
        rStart = rStart + direction[d][0];
        cStart = cStart + direction[d][1];

        if (rStart>=0 && rStart <= rows-1 && cStart>=0 && cStart<= cols-1) {
          list.add(rStart+"-"+cStart);
        }

      }

      d = (d+1)%4;
    }

    return list;
  }

  public static void main(String[] args) {
    int rows = 5;
    int cols = 6;
    int rStart = 1;
    int cStart = 4;

    List<String> list = spiralMatrixIII(rows, cols, rStart, cStart);

    System.out.println(list.size());
  }
}
