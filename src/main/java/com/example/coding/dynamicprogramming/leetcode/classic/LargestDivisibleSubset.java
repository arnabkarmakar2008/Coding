package com.example.coding.dynamicprogramming.leetcode.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers nums, return the largest subset answer such
 * that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 */
public class LargestDivisibleSubset {

  /**
   * https://www.youtube.com/watch?v=Wv6DlL0Sawg
   *
   * This is same as LIS. We have to sort the array. Then we can check if nums[i] % nums[i-1] == 0 or not.
   * If we do not sort then we have to check both nums[i] % nums[i-1] == 0 or nums[i-1] % nums[i] == 0.
   * Mod is costly. So sortig is better with NlonN.
   *
   * @param nums
   * @return
   */
  public static List<Integer> largestDivisibleSubset(int[] nums) {
    int[] dp = new int[nums.length]; // Will store the size of the subset
    Arrays.fill(dp,1); // Each element can be divisible by itself. So size=1 initially.

    int maxSize = Integer.MIN_VALUE;

    for (int i=1; i<dp.length; i++) {
      for (int j=0; j<i; j++) {
        if (nums[i] % nums[j] == 0 && (dp[j] + 1)>dp[i]) {
          dp[i] = dp[j]+1;
          maxSize = Math.max(maxSize, dp[i]);
        }
      }
    }

    int preElement = -1;
    List<Integer> answerList = new ArrayList<>();

    //Now traverse the dp array from right side
    for (int i = dp.length-1; i>=0; i--) {
      if (dp[i] == maxSize && (preElement == -1 || preElement % nums[i] == 0)) {
        // Get the index from dp array and check element from nums array
        maxSize--;
        preElement = nums[i];
        answerList.add(preElement);
      }
    }

    return answerList;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,6};

    List<Integer> answer = largestDivisibleSubset(nums);

    System.out.println(answer.stream().count());
  }
}
