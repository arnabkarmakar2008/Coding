package com.example.coding.matrix.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 *
 * You are given an m x n matrix mat that has its rows sorted in non-decreasing order and an integer k.
 *
 * You are allowed to choose exactly one element from each row to form an array.
 *
 * Return the kth smallest array sum among all possible arrays.
 *
 */
public class KthSmallestSumOfMatrixSortedRow {

  /**
   * Note : 1,10,10
   *        1,4,5
   *        2,3,6
   *
   * For first 2 rows : 1+1, 1+4, 1+5, 10+1, 10+4, 10+5,10+1, 10+4, 10+5
   * After sorting 2,5,6,11,11,14,14,15,15
   * From above only k=7 columns will be used for next calculation as rows are sorted.
   * @param mat
   * @param k
   * @return
   */
  public static int kthSmallest(int[][] mat, int k) {
    int rows = mat.length;
    int cols = mat[0].length;

    int effectiveCol = Math.min(cols,k);

    PriorityQueue<Integer> externalPQ = new PriorityQueue<>(Comparator.reverseOrder());
    externalPQ.add(0);

    for (int i=0; i< rows; i++) {

      //ith row's pq
      PriorityQueue<Integer> internalPQ = new PriorityQueue<>(Comparator.reverseOrder());

      //For each element of externalPQ, add combination in internalPQ. Keep size only = k.
      for (int pqElement : externalPQ) {
        for (int j=0; j < effectiveCol; j++) {
          internalPQ.add(mat[i][j] + pqElement);

          if (internalPQ.size() > k) {
            internalPQ.poll();
          }
        }
      }

      externalPQ = internalPQ;
    }

    return externalPQ.poll();


  }

  public static void main(String[] args) {
    int[][] grid = {{1,10,10},{1,4,5},{2,3,6}};
    int k = 7;
    System.out.println(kthSmallest(grid,k));
  }
}
