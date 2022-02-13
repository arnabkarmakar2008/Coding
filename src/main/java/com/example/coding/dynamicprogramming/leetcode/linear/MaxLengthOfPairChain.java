package com.example.coding.dynamicprogramming.leetcode.linear;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 *
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 *
 * Return the length longest chain which can be formed.
 *
 * You do not need to use up all the given intervals. You can select pairs in any order.
 */
public class MaxLengthOfPairChain {

  public static int findLongestChain(int[][] pairs) {
    int length = pairs.length;

    int[] lisArray = new int[length];

    //We have to sort the either by 1st element or 2nd
    Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[1]));

    //Then the problem is similar to increasing subsequence

    Arrays.fill(lisArray,1);

    for (int i=1; i<length; i++) {
      int j=0;

      while (j<i) {

        if (pairs[i][0] > pairs[j][1] && lisArray[i] <= lisArray[j]) {
          lisArray[i] = lisArray[j] + 1;
        }
        j++;
      }
    }

    int maxSize = -1;

    for (int size : lisArray) {
      maxSize = Math.max(maxSize, size);
    }

    return maxSize;
  }

  public static void main(String[] args) {
    int[][] arr = {{1,2},{7,8},{4,5}};
    System.out.println(findLongestChain(arr));
  }
}
