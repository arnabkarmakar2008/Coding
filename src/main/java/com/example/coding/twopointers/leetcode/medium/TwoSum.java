package com.example.coding.twopointers.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use
 * the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] resultArray = new int[2];
    for (int i=0; i< nums.length; i++) {
      int reminder = target - nums[i];

      if (map.containsKey(reminder)) {
        resultArray[0] = i;
        resultArray[1] = map.get(reminder);
        break;

      } else {
        map.put(nums[i], i);
      }
    }

    return resultArray;
  }


  public static void main(String[] args) {
    int nums[] = {2,7,11,15};
    int target = 9;

    int[] ind = twoSum(nums, target);
    System.out.println(ind);

  }
}

