package com.example.coding.matrix.leetcode.medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order,
 * return the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order,
 * not the kth distinct element.
 *
 * You must find a solution with a memory complexity better than O(n2).
 */
public class KthSmallestElementInSortedMatrix {


  //Using MaxHeap
  public static int kthSmallest(int[][] matrix, int k) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int i=0; i< rows; i++) {
      for (int j=0; j<cols; j++) {
        pq.add(matrix[i][j]);

        if (pq.size() > k) {
          pq.poll();
        }
      }
    }

    return pq.poll();
  }


  /**
   * Using MinHeap : Start from first column. Add all first column in MinHeap. Now loop for Ktimes and
   * pop MinHeap and add top's next element from row in minHeap. At the end of kth times, MinHeap top
   * will have kth smallest element.
   * @param matrix
   * @param k
   * @return
   */
  public static int kthSmallestUsingMinHeap(int[][] matrix, int k) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));


    //Adding first column in pq.
    for (int i=0; i<rows; i++) {
      pq.add(new int[] {matrix[i][0], i, 0}); //element, row, column
    }

    int ans = -1;
    // Loop through k times...
    for (int i=1; i<=k; i++) {
      int[] topArray = pq.poll(); // Top of the queue will be ith smallest element. First pop will give 1st smallest
      //element..2nd pop will give second. As rowsa are sorted, add next element from the same row in pq.
      int r = topArray[1]; //row
      int c = topArray[2]; //column
      ans = topArray[0]; //element

      if (c+1 < cols) {
        pq.add(new int[] {matrix[r][c+1], r, c+1});
      }
    }

    return ans;

  }

  public static void main(String[] args) {

  }
}
