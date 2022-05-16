package com.example.coding.dynamicprogramming.leetcode.linear;

import java.util.Arrays;

/**
 * IP = {5,8,7,1,9} op = 3 :: 5,8,9
 */
public class LongestIncreasingSubsequence {

  public static int longest(int[] arr) {
    int length = arr.length;;

    int[] lisArray = new int[length];

    Arrays.fill(lisArray, 1); // As each element will be LIS of size 1.

    // We will take two pointer. i will point starting from index 1. j will start from 0 and will
    //go till i

    for (int i=1; i<length; i++) {
      int j=0;

      while (j < i) {
        if (arr[i] > arr[j] && lisArray[i] < lisArray[j]+1) {
          lisArray[i] = lisArray[j] + 1;
        }

        j++;
      }
    }

    int maxSize = -1;
    for (int val : lisArray) {
      maxSize = Math.max(maxSize, val);
    }

    return maxSize;
  }

  public static void main(String[] args) {
    int[] arr = {1,3,5,4,7};
    System.out.println(longest(arr));
  }

}
