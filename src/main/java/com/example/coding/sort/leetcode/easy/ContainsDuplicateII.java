package com.example.coding.sort.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if there are
 * two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 */
public class ContainsDuplicateII {

  public static boolean containsDuplicate(int[] nums , int k) {
    Map<Integer, Integer> hashMap = new HashMap<>();

    for (int i=0; i< nums.length; i++) {
      int current = nums[i];

      if (hashMap.containsKey(current) && (i-hashMap.get(current))<=k) {
        return true;
      } else {
        hashMap.put(current, i);
      }
    }

    return false;

  }

  public static void main(String[] args) {
    int[] nums = {1,2,1,3};
    System.out.println(containsDuplicate(nums,2));
  }
}
