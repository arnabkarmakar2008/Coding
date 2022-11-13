package com.example.coding.backtracking;

import java.util.ArrayList;

public class PartitionInKEqualSumSubSets {

  /**
   * Input: nums = [4,3,2,3,5,2,1], k = 4
   * Output: true
   * Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
   *
   *
   * https://www.youtube.com/watch?v=mBk4I0X46oI
   * @param arr
   * @param k
   * @return
   */
  public static boolean isSolutionPossible(int[] arr, int k) {
    int target = 0;
    int sum = 0;

    for (int num : arr) {
      sum += num;
    }

    target = sum/k;

    return backtrack(0, 0, arr, k, target, new boolean[arr.length]);
  }

  public static boolean backtrack(int index, int currentSum, int[] arr, int k, int target, boolean[] used) {
    if (k == 0 ) {
      return true;
    }

    if (currentSum == target) {
      //If currentSum == target, one partition is found. So start from 0 again and search for k-1 partition
      return backtrack(0, 0, arr, k-1, target, used);
    }

    for (int i = index; i< arr.length; i++) {
      if (used[i] || currentSum + arr[i] > target) {
        continue;
      } else {
        used[i] = true;
        if (backtrack(i+1, currentSum + arr[i], arr, k, target, used)) {
          return true;
        }

        used[i] = false;
      }
    }

    return false;
  }

  /**
   * Partition n elements in k subsets. If n-1 elements form k subsets then n can join any subset. If n-1 elements form
   * k-1 subsets then nth element will form k subset.
   * @param args
   */
  public static void main(String[] args) {
    int[] arr = {8,3,2,3,5,2,1};
    int k = 4;
    boolean flag = isSolutionPossible(arr, k);

    System.out.println(flag);

  }
}
