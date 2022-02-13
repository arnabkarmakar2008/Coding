package com.example.coding.dynamicprogramming.leetcode.knapsack;

/**
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-'
 * before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and
 * concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 */
public class TargetSum {

  public static int findTargetSumWays(int[] nums, int target) {
    Counter ct = new Counter();
    solveRecursion(nums, target, 0, 0, ct);

    return ct.numberOfComb;
  }

  private static void solveRecursion(int[] nums, int target, int index, int sumTillNow, Counter ct) {

    if (index >= nums.length) {
      if (sumTillNow == target) {
        ct.numberOfComb++;
      }

      return;
    }

    solveRecursion(nums, target, index+1, sumTillNow + nums[target], ct);
    solveRecursion(nums, target, index+1, sumTillNow - nums[target], ct);
  }

  public static void main(String[] args) {
    int[] nums = {1,1,1,1,1};
    int target = 3;

    System.out.println(findTargetSumWays(nums, target));
  }
}

class Counter {
  int numberOfComb;
}
