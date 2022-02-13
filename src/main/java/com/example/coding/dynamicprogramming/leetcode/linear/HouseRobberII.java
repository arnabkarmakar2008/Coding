package com.example.coding.dynamicprogramming.leetcode.linear;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a
 * certain amount of money stashed. All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses
 * have a security system connected, and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {

  public static int rob(int[] nums) {
    int len = nums.length;

    int[] dp = new int[len];

    dp[0] = nums[0];
    dp[1] = Math.max(dp[0], nums[1]);

    for (int i=2; i < len; i++) {
      dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
    }

    return dp[len-1];
  }

  public static int solve(int[] nums) {
    // 1,2,3,1, If we rob house at index 0, then we cannot rob n-1 and 1. And if we rob house at index 1,
    // then we cannot rob 0 and 3. So problem is becoming find values if we rob house from 0..n-2 and 1 to n-1.
    // Answer would be max of these 2 values.

    int[] firstArray = Arrays.copyOfRange(nums, 0, nums.length-1);
    int[] secondArray = Arrays.copyOfRange(nums, 1, nums.length);

    int profit1 = rob(Arrays.copyOfRange(nums, 0, nums.length-1));
    int profit2 = rob(Arrays.copyOfRange(nums, 1, nums.length));

    return Math.max(profit1, profit2);

  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,1};
    System.out.println(solve(nums));
    System.out.println("hhjh");
  }
}
