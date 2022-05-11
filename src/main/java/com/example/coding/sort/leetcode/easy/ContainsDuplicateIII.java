package com.example.coding.sort.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Given an integer array nums and two integers k and t, return true if there are two distinct
 * indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 */
public class ContainsDuplicateIII {

  /**
   * https://www.youtube.com/watch?v=Cu7g9ovYHNI
   * @param nums
   * @param k
   * @return
   */
  public static boolean containsDuplicate(int[] nums , int k, int t) {
    TreeSet<Long> set = new TreeSet<>();

    for (int i=0; i< nums.length; i++) {

      Long floor = set.floor((long)nums[i]); // Floor will return the highest number which is less or equal to nums[i]
      if (floor != null && (nums[i] - floor) <= t) {
        return true;
      }

      Long ceiling = set.ceiling((long)nums[i]); //Ceiling ill return the smallest number which is greater or equal to nums[i]
      if (ceiling != null && (ceiling - nums[i]) <= t) {
        return true;
      }

      //Else add the number
      set.add((long)nums[i]);

      //Now distance btwn number should be <=k. So maintain set size as k only.
      if (set.size() > k) {
        //then remove last element
        set.remove(nums[i-k]);
      }

    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,1,3};
    System.out.println(containsDuplicate(nums,3,0));
  }
}
