package com.example.coding.dynamicprogramming.leetcode.linear;

import java.util.Arrays;

/**
 * IP = {5,8,7,1,9} op = 3 :: 5,8,9
 * 5,7,9
 *
 * Count = 2
 */
public class LongestIncreasingSubsequenceCount {

  public static int longest(int[] arr) {
    int length = arr.length;;

    int[] lisArray = new int[length];
    int[] countArray = new int[length];

    Arrays.fill(lisArray, 1); // As each element will be LIS of size 1.
    Arrays.fill(countArray, 1); // As each element will be LIS of size 1.

    // We will take two pointer. i will point starting from index 1. j will start from 0 and will
    //go till i
    int lis = 1;
    for (int i=1; i<length; i++) {
      int j=0;

      while (j < i) {
        if (arr[i] > arr[j]) {

          if (lisArray[i] < lisArray[j]+1) {
            lisArray[i] = lisArray[j] + 1;
            countArray[i] = countArray[j];

          } else if (lisArray[i] == lisArray[j]+1) {
            //5 8 7 1 9
            // lis array will be 1 2 2 1 3
            countArray[i] = countArray[i] + countArray[j];
          }

        }
        j++;
      }

      lis = Math.max(lis, lisArray[i]);
    }

    int numberOfLis = 0;
    for (int i=0; i<length; i++) {
      if (lisArray[i] == lis) {
        numberOfLis += countArray[i];
      }
    }

    return numberOfLis;
  }

  public static void main(String[] args) {
    int[] arr = {5,8,7,1,9};
    System.out.println(longest(arr));
  }

}
