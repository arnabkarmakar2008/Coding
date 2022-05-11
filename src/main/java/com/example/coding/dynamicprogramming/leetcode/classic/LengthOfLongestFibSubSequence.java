package com.example.coding.dynamicprogramming.leetcode.classic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A sequence x1, x2, ..., xn is Fibonacci-like if:
 *
 * n >= 3
 * xi + xi+1 == xi+2 for all i + 2 <= n
 * Given a strictly increasing array arr of positive integers forming a sequence, return the length
 * of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.
 *
 * A subsequence is derived from another sequence arr by deleting any number of elements (including none)
 * from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence
 * of [3, 4, 5, 6, 7, 8].
 */
public class LengthOfLongestFibSubSequence {


  //Brute force solution
  public static int lenLongestFibSubseq(int[] arr) {
    Set<Integer> set = new HashSet();

    for (int val : arr) {
      set.add(val);
    }
    int maxLength = Integer.MIN_VALUE;

    //Considering each and every pair.
    for (int i=0; i<arr.length; i++) {
      for (int j=i+1; j<arr.length; j++) {
        int length = 2;

        // A[i], A[j], A[i]+A[j]

        int x = arr[j];
        int y = arr[i] + arr[j];

        while (set.contains(y)) {
          int temp = x;
          x = y;
          y = temp + y;
          length++;
        }

        maxLength = Math.max(maxLength, length);

      }
    }

    return maxLength;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,8};
    System.out.println(lenLongestFibSubseq(arr));
  }
}
