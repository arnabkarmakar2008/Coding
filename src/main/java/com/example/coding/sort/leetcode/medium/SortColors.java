package com.example.coding.sort.leetcode.medium;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so
 * that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 */
public class SortColors {

  /**
   * Kind of bucket sort 0(N) solution
   * @param nums
   */
  public static void sortColorsSinglePass(int[] nums) {

    int low = 0;
    int mid = 0;
    int high = nums.length-1;

    while (mid <= high) {
      if (nums[mid] == 0) {
        swap(nums, mid, low);
        mid++;
        low++;
      } else if (nums[mid] == 1) {
        mid++;
      } else {
        swap(nums, mid, high);
        high--;
      }
    }
  }

  private static void swap (int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  public static void sortColorsTwoPass(int[] nums) {
    int count0 = 0, count1 = 0, count2 = 0;

    for (int i = 0; i <= nums.length - 1; i++) {
      if (nums[i] == 0) count0++;
      if (nums[i] == 1) count1++;
      if (nums[i] == 2) count2++;
    }

    for (int i = 0; i <= nums.length - 1; i++) {
      if (i < count0) {
        nums[i] = 0;
      } else if (i < count0 + count1) {
        nums[i] = 1;
      } else {
        nums[i] = 2;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {0,1,2,2,1,0};
    sortColorsTwoPass(nums);

    for (int num : nums) {
      System.out.print(num + " ");
    }
  }
}
