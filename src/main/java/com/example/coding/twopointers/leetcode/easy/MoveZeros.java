package com.example.coding.twopointers.leetcode.easy;

/**
 * Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeros {

  public static void moveZeroes(int[] nums) {
    int insertIndex = 0;

    for (int start = 0; start < nums.length; start++) {
      if (nums[start] != 0) {
        nums[insertIndex++] = nums[start];
      }
    }

    while (insertIndex < nums.length) {
      nums[insertIndex++] = 0;
    }
  }

  /**
   * https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation
   * @param nums
   */
  public static void moveZeros2(int nums[]) {
    int snowBallSize = 0;

    for (int start = 0; start < nums.length; start++) {
      if (nums[start] == 0) {
        snowBallSize++;
      } else if (snowBallSize > 0) {
        int temp = nums[start];
        nums[start] = 0;
        nums[start - snowBallSize] = temp;

      }
    }

  }

  public static void main(String[] args) {
    int[] nums = {0,1,0,3,2};
    moveZeroes(nums);

    for (int num : nums) {
      System.out.println(num + "\n");
    }

  }
}
