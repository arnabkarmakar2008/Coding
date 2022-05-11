package com.example.coding.twopointers.leetcode.medium;

import java.util.*;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 */
public class FourSum {

  public static Set<List<Integer>> fourSum(int[] nums, int target) {
    Set<List<Integer>> resultList = new HashSet<>();

    Arrays.sort(nums);

    for (int index1=0; index1+4 < nums.length; index1++) {
      for (int index2 = index1+1; index2+3 < nums.length; index2++) {
        int index3 = index2+1;
        int index4 = nums.length-1;

        while (index3 < index4) {
          int sum = nums[index1]+nums[index2]+nums[index3]+nums[index4];
           if (sum == target) {
             resultList.add(Arrays.asList(nums[index1], nums[index2], nums[index3], nums[index4]));
             index3++;
           } else if (sum < target) {
             index3++;
           } else {
             index4--;
           }
        }
      }
    }

    return resultList;

  }

  public static void main(String[] args) {
    int[] nums = {1,0,-1,0,-2,2};
    int target = 0;

    Set<List<Integer>> resultList = fourSum(nums, target);
  }
}
