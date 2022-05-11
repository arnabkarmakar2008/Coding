package com.example.coding.dynamicprogramming.leetcode.classic;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 */
public class MaximumSumSubArray {

  public static int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];

    dp[0] = nums[0];
    int max = dp[0];

    for (int i=1; i<nums.length; i++) {
      //If sum till previous index is -ve then it will smaller the sum. So ignore.
      dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);

      max = Math.max(max, dp[i]);
    }

    return max;

  }

  public static int maxSubArrayKadenesAlgo(int[] nums) {

    /**
     * https://www.youtube.com/watch?v=VMtyGnNcdPw
     * 1 2 -2 4 -6 8 10 -11
     *
     * cSum = 1
     * oSum = 1
     *
     * i=1
     * cSum = 1+2 = 3
     * oSum = 3>1 = 3
     *
     * i=2
     * cSum = 3>0 so 3+(-2) = 1
     * oSum = 3
     *
     * i=3
     * cSum = 1>0 so 4+(1) = 5
     * oSum = 5........
     */

    int currentSum = nums[0];
    int overAllSum = nums[0];

    for (int i=1; i< nums.length; i++) {
      if (currentSum < 0) {
        currentSum = nums[i];
      } else {
        currentSum += nums[i];
      }

      if (currentSum > overAllSum) {
        overAllSum = currentSum;
      }
    }

    return overAllSum;
  }

  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

    System.out.println(maxSubArray(nums));
  }
}
