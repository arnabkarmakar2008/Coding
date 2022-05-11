package com.example.coding.sort.leetcode.easy;

import java.util.Arrays;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Note : This is Moore's majority voting algo.
 *
 * 2 3 4 2 2
 *
 * First Pass ::
 * MC = 2
 * CT = 1
 * 3 not equal 2. So CT = CT-1 = 0. As CT = 0, MC = 3 now.
 * 3 not equal to 4. So CT = CT-1 = 0. As CT = 0, MC = 4 now. CT = 1.
 * 4 not equal to 2. So CT = CT-1 = 0. As CT=0, MC = 2 now. CT = 1.
 * 2 is equal to 2. So CT = CT+1 = 2.
 *
 * So at the end MC = 2.
 *
 * Run through the array again and take the count of 2. If count is > N/2 then MC = 2
 *
 */
public class MajorityElement {

  /**
   * https://www.youtube.com/watch?v=n5QY3x_GNDg
   * @param nums
   * @return
   */
  public static int majorityElement(int[] nums) {
    int majorityIndex = 0;
    int counter = 1;

    for (int i=1; i< nums.length; i++) {
      if (nums[majorityIndex] == nums[i]) {
        counter++;
      } else {
        counter--;
      }

      if (counter == 0) {
        majorityIndex = i;
        counter = 1;
      }
    }

    return nums[majorityIndex];
  }

  public static boolean isMajor(int[] nums, int candidate) {
    int counter = 0;

    for (int i=0; i<nums.length; i++) {
      if (nums[i] == candidate) {
        counter++;
      }
    }

    return counter >= (nums.length/2);
  }

  public static void main(String[] args) {
    int[] nums = {3,2,4,2,2,8,9};

    int candidate = majorityElement(nums);


    System.out.println(isMajor(nums, candidate));
  }
}
