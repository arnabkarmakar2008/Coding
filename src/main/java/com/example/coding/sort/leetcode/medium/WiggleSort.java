package com.example.coding.sort.leetcode.medium;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that
 *
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 * Input: [3, 5, 2, 1, 6, 4]
 * Output: [1, 6, 2, 5, 3, 4]
 */
public class WiggleSort {

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
    int[] nums = {3, 5, 2, 1, 4,6};
    wiggleSort(nums);
    System.out.println(nums);
  }
}
