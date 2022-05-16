package com.example.coding.search.leetcode.medium;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given an integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {

  public static int findPeakElement(int[] nums) {

    int low = 0;
    int high = nums.length-1;

    while (low <= high) {
      int mid = (low+high)/2;

      if (mid == 0) {
        if (nums[mid] > nums[mid+1]) {
          return mid;
        }
      } else if (mid == nums.length-1) {
        if (nums[mid] > nums[mid-1]) {
          return mid;
        }
      } else {
        if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
          return mid;
        }
      }

      if (nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]) {
        low = mid+1;
      } else {
        high = mid-1;
      }

    }

    return -1;

  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,1};
    System.out.println(findPeakElement(nums));
  }
}
