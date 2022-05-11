package com.example.coding.twopointers.leetcode.medium;

/**
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {

  /**
   * https://www.youtube.com/watch?v=anuarmFjTGU
   * @param nums
   * @param target
   * @return
   */
  public static int threeSumClosest(int[] nums, int target) {
    int diff = Integer.MAX_VALUE;
    int result = 0;

    for (int index1 = 0; index1+2< nums.length; index1++) {
      int index2 = index1+1;
      int index3 = nums.length-1;

      while (index2 < index3) {
        int sum = nums[index1] + nums[index2] + nums[index3];

        if (sum == target) {
          result = target;
          return result;
        } else if (Math.abs(target - sum) < diff) {
          diff = Math.abs(target - sum);
          result = sum;
        }

        if (sum > target) {
          index3--;
        } else {
          index2++;
        }
      }


    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {-1,2,1,4};
    int target = 1;

    System.out.println(threeSumClosest(nums, target));
  }
}
