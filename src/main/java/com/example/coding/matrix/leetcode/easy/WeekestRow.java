package com.example.coding.matrix.leetcode.easy;

import java.util.Arrays;

/**
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and
 * 0's (representing civilians). The soldiers are positioned in front of the civilians.
 * That is, all the 1's will appear to the left of all the 0's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 */
public class WeekestRow {

  public static int[] kWeakestRows(int[][] mat, int k) {
    int rows = mat.length;
    int cols = mat[0].length;
    int[] scores = new int[rows];

    for (int i=0; i< rows; i++) {
      int j = 0;
      for (; j < cols; j++) {
        if (mat[i][j] == 0) {
          break;
        }
      }

      // score depends on the index of the row. If row 2 and 3 both have 2 soldiers then we have to
      // take 2 only. So keeping index also in the calculation. score can be like j + i/rows. But this
      // will br fraction. So multiply both sides by rows will give j*rows+1;
      scores[i] = j * rows + 1;
    }

    Arrays.sort(scores);

    for (int i=0; i < scores.length; i++) {
      scores[i] = scores[i]%rows;
    }

    return Arrays.copyOfRange(scores, 0, k);

  }
}
