package com.example.coding.search.leetcode.medium;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and
 * ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 */
public class FirstAndLastPositionOfElement {

  /**
   * https://www.youtube.com/watch?v=Y7LiLNdayF0
   *
   * Apply 2 binary searches. After getting the target continue search in left and right arrays.
   * @param nums
   * @param target
   * @return
   */
  public static int[] searchRange(int[] nums, int target) {
    int[] answerArray = new int[2];
    Arrays.fill(answerArray, -1);

    int low = 0;
    int high = nums.length-1;

    while (low <= high) {
      int mid = (low+high)/2;

      if (nums[mid] == target) {
        answerArray[0] = mid; //first index
        //Continue search in the left array

        high = mid-1;

      } else if (nums[mid] < target) {
        low = mid+1;
      } else if (nums[mid] > target) {
        high = mid-1;
      }
    }


    low = 0;
    high = nums.length-1;

    while (low <= high) {
      int mid = (low+high)/2;

      if (nums[mid] == target) {
        answerArray[1] = mid; //end index
        //Continue search in the right array

        low = mid+1;

      } else if (nums[mid] < target) {
        low = mid+1;
      } else if (nums[mid] > target) {
        high = mid-1;
      }
    }

    return answerArray;

  }

  public static void main(String[] args) {
    int[] nums = {5,7,7,8,8,10};
    int target = 10;

    int[] arr = searchRange(nums, target);

    for (int index : arr) {
      System.out.print(index + " ");
    }

  }
}
