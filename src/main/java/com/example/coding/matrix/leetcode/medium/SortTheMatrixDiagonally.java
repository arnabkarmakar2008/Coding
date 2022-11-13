package com.example.coding.matrix.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row
 * or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example,
 * the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0],
 * mat[3][1], and mat[4][2].

 Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the
 resulting matrix.**/
public class SortTheMatrixDiagonally {

  public static int[][] diagonalSort(int[][] mat) {

    //Note : Elements falling on the same diagonal have same i-j value. So use i-j as the
    //index of map.

    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

    for (int i=0; i< mat.length; i++) {
      for (int j=0; j< mat[i].length; j++) {
        map.putIfAbsent(i-j, new PriorityQueue<>());
        map.get(i-j).add(mat[i][j]);
      }
    }

    for (int i=0; i< mat.length; i++) {
      for (int j=0; j< mat[i].length; j++) {
        mat[i][j] = map.get(i-j).poll();
      }
    }

    return mat;
  }
}
