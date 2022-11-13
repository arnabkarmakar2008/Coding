package com.example.coding.matrix.leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

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
public class WeakestRow {

  public static int[] kWeakestRows(int[][] mat, int k) {
    int row = mat.length;
    int col = mat[0].length;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]!=b[0] ? b[0]-a[0] : b[1]-a[1]);
    int[] resultArray = new int[k];

    for (int i=0; i < row; i++) {
      int numberOfOnes = numberOfOnes(mat[i]);
      pq.add(new int[] {numberOfOnes, i});

      if (pq.size() > k) {
        pq.poll();
      }
    }

    while (k > 0 ) {
      resultArray[--k] = pq.poll()[1];
    }

    return resultArray;
  }

  public static int numberOfOnes(int[] num) {
    int low = 0;
    int high = num.length;

    while (low < high) {
      int mid = low + (high-low)/2;

      if (num[mid] == 1) {
        low = mid+1;
      } else {
        high = mid;
      }
    }

    return low;
  }

  public static void main(String[] args) {

  }
}
