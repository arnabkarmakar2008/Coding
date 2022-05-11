package com.example.coding.twopointers.leetcode.medium;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {

  /**
   * https://www.youtube.com/watch?v=BHr381Guz3Y
   * Reverse the array. Then reverse first k element and then reverse rest k elements.
   * @param nums
   * @param k
   */

  public static void rotate(int[] nums, int k) {
    reverse(nums, 0, nums.length-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, nums.length-1);
  }

  private static void reverse (int[] nums, int start, int end) {

    while (start < end) {
      int temp = nums[end];
      nums[end] = nums[start];
      nums[start] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7};
    int k = 3;
    rotate(nums, k);

    System.out.println(nums);
  }
}
