package com.example.coding.dynamicprogramming.leetcode.multidm;

/**
 * Given an array nums which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum among these m subarrays.
 */
public class SplitArrayLargestSum {
  /**
   * Same binary search problem as min number of pages.
   * Here min sum of max subarray will be max element from array and max range will be sum of all elements of array
   * @param nums
   * @param m
   * @return
   */
  public static int splitArray(int[] nums, int m) {
    int totalSum = 0;
    int maxElement = Integer.MIN_VALUE;

    for (int element : nums) {
      totalSum += element;
      maxElement = Math.max(maxElement, element);
    }

    int answer = 0;
    int hi = totalSum;
    int low = maxElement;

    while (low <= hi) {
      int mid = (low + hi) / 2;

      if (findIfPossible(mid, nums, m)) {
        hi = mid-1;
        answer = mid;
      } else {
        low = mid + 1;
      }
    }

    return answer;
  }

  public static boolean findIfPossible(int target, int[] nums, int m) {
    int subArrayCount = 1;
    int sum = 0;

    for (int ct=0; ct < nums.length; ct++) {
      sum += nums[ct];

      if (sum > target) {
        sum = nums[ct];
        subArrayCount++;
      }
    }

    return subArrayCount <= m;
  }

  public static void main(String[] args) {
    int[] nums = {7,2,5,10,8};
    int m = 2;

    System.out.println(splitArray(nums, m));
  }


}
