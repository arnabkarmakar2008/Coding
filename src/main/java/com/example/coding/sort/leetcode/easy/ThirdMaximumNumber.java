package com.example.coding.sort.leetcode.easy;

/**
 * Given an integer array nums, return the third distinct maximum number in this array.
 * If the third maximum does not exist, return the maximum number.
 */
public class ThirdMaximumNumber {
  /**
   * https://www.youtube.com/watch?v=SBsRk-gGBuE
   * @param nums
   * @return
   */
  public static int thirdMax(int[] nums) {
    int firstMax = nums[0];
    int secondMax = Integer.MIN_VALUE;
    int thirdMax = Integer.MIN_VALUE;

    for (int i=0; i< nums.length; i++) {
      int current = nums[i];
      if (current > firstMax) {
        thirdMax = secondMax;
        secondMax = firstMax;
        firstMax = current;
      } else if (current > secondMax && current < firstMax) {
        thirdMax = secondMax;
        secondMax = current;
      } else if (current > thirdMax && current < secondMax) {
        thirdMax = current;
      }
    }

    return thirdMax != Integer.MIN_VALUE ? thirdMax : firstMax; // If there is no third max return max number

  }

  public static void main(String[] args) {
    int[] nums = {2,2,3,1};
    System.out.println(thirdMax(nums));
  }
}
