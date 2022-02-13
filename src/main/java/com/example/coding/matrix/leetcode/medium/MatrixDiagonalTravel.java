package com.example.coding.matrix.leetcode.medium;

import java.util.*;
import java.util.stream.Collector;

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 */
public class MatrixDiagonalTravel {

  //Note :: Elements on the same diagonal will have same i+j
  public static int[] findDiagonalOrder(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;

    int[] arr = new int[rows*cols];
    int counter = 0;

    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

    for (int i=0; i< rows; i++) {
      for (int j=0; j<cols; j++) {
        map.putIfAbsent(i+j, new ArrayList<>());
        map.get(i+j).add(mat[i][j]);
      }
    }

    for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
      int key = entry.getKey();
      ArrayList<Integer> list = entry.getValue();

      if (key%2 == 0) {
        Collections.reverse(list); // Have to reverse for even index
      }

      for (Integer element : list) {
        arr[counter] = element;
        counter++;
      }
    }

    return arr;
  }

  public static int[] optimalSolution(int[][] mat) {

    //direction of going up right or going down left depends whether the index sum is even or odd
    //for each even or odd diagonal, there are three cases:
    // 1. there is room to go that direction
    // 2. there is no row space to go further but there is col space
    // 3. there is no col space to go further but there is row space

    int rows = mat.length;
    int cols = mat[0].length;

    int[] arr = new int[rows * cols];
    int r = 0;
    int c = 0;

    for (int k=0; k< arr.length; k++) {

      arr[k] = mat[r][c];

      if (r+c %2 == 0) {
        //Even diagonal. Will go up

        if (r-1 >=0 && c+1 < cols) {
          r = r-1;
          c = c+1;
        } else if (r-1 < 0 && c+1 < cols) {
          c = c+1;
        } else if (r-1 >= 0 && c+1 >= cols) {
          r = r+1;
        }
      } else {
        //Odd diagonal..Will do down

        if (r+1 < rows && c-1 >=0 ) {
          r = r+1;
          c = c-1;
        } else if (r+1 >= rows && c-1>=0) {
          c = c-1;
        } else if (r+1 < rows && c-1 < 0) {
          r = r+1;
        }
      }
    }
    return arr;

  }

  public static void main(String[] args) {
    //int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
    int[][] mat = {{1,2},{3,4}};
    int[] arr = findDiagonalOrder(mat);

    for (int a : arr) {
      System.out.print(a + " ");
    }
  }
}
