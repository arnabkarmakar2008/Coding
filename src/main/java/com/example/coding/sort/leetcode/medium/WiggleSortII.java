package com.example.coding.sort.leetcode.medium;

/**
 * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * You may assume the input array always has a valid answer.
 *
 * Input: nums = [1,5,1,1,6,4]
 * Output: [1,6,1,5,1,4]
 * Explanation: [1,4,1,5,1,6] is also accepted.
 */
public class WiggleSortII {

  /**
   * Values at odd index should be greater than previous value.
   * Values at even index should be smaller than previous value.
   *
   * https://www.youtube.com/watch?v=vGsyTE4s34w
   * @param nums
   * @return
   */
  public static void wiggleSort(int[] nums) {
    for (int i=1; i < nums.length; i++) {
      if (i % 2 == 0 && nums[i] > nums[i-1]) {
          swap(nums, i, i-1);
      }

      if (i % 2 == 1 && nums[i] < nums[i-1]) {
        swap(nums, i, i-1);
      }
    }

  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {1,5,1,1,6,4};
    wiggleSort(nums);
    System.out.println(nums);
  }
}
