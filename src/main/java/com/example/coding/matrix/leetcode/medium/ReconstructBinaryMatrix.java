package com.example.coding.matrix.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the following details of a matrix with n columns and 2 rows :
 *
 * The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
 * The sum of elements of the 0-th(upper) row is given as upper.
 * The sum of elements of the 1-st(lower) row is given as lower.
 * The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given
 * as an integer array with length n.
 * Your task is to reconstruct the matrix with upper, lower and colsum.
 *
 * Return it as a 2-D integer array.
 *
 * If there are more than one valid solution, any of them will be accepted.
 *
 * If no valid solution exists, return an empty 2-D array.
 */
public class ReconstructBinaryMatrix {
  public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
    List<List<Integer>> list = new ArrayList<>();

    int[][] array = new int[2][colsum.length];

    //Construct upper row
    for (int j=0; j<colsum.length; j++) {
      array[0][j] = ((colsum[j] == 2) || (colsum[j] == 1 && lower < upper)) ? 1 : 0;
      array[1][j] = ((colsum[j] == 2) || (colsum[j] == 1 && array[0][j] != 1)) ? 1 : 0;

      upper -= array[0][j];
      lower -= array[1][j];
    }

    return (lower == 0 && upper == 0) ? new ArrayList(Arrays.asList(array[0], array[1])) : new ArrayList<>();

  }

  public static void main(String[] args) {
    int upper = 2;
    int lower = 1;
    int[] colsum = {1,1,1};

    reconstructMatrix(upper, lower, colsum);
  }
}
