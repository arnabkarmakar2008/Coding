package com.example.coding.matrix.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class AllGroupsOfFarmland {

  public static int[][] findFarmland(int[][] land) {
    int rows = land.length;;
    int cols = land[0].length;

    List<int[]> list = new ArrayList<>();

    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        if (land[i][j] == 1) {
          extend(land, i, j, list);
        }
      }
    }

    return list.toArray(new int[list.size()][]);

  }

  public static void extend(int[][] land, int row, int col, List<int[]> list) {
    int endRow = row;
    int endCol = col;
    land[row][col] = 0;

    //Extend row wise
    if (endRow+1 < land.length && land[endRow+1][col] == 1) {
      land[endRow+1][col] = 0;
      endRow++;
    }

    //Extend col wise
    if (endCol+1 < land[0].length && land[row][endCol+1] == 1) {
      land[row][endCol+1] = 0;
      endCol++;
    }

    list.add(new int[] {row, col, endRow, endCol});

  }

  public static void main(String[] args) {

  }
}
