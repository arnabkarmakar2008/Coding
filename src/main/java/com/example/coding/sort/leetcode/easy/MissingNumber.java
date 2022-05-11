package com.example.coding.sort.leetcode.easy;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */
public class MissingNumber {

  public static int missingNumber(int[] nums) {
    int size = nums.length;

    int sum = (size * (size+1))/2;

    for (int i=0; i< nums.length; i++) {
      sum = sum - nums[i];
    }

    return sum;
  }

  public static int missingNumberXOR(int[] nums) {
    int res = nums.length;
    for(int i=0; i<nums.length; i++){
      res = res ^ i ^ nums[i]; // a^b^b = a
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,0,4};
    System.out.println(missingNumberXOR(nums));
  }
}
