package com.example.coding.sort.leetcode.easy;

import java.util.Arrays;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 */
public class ContainsDuplicate {

  public static boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);

    for (int i=1; i<nums.length; i++) {
      if (nums[i-1] == nums[i]) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,4,3};
    System.out.println(containsDuplicate(nums));
  }
}
