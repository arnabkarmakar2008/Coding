package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * A wiggle sequence is a sequence where the differences between successive numbers strictly alternate
 * between positive and negative. The first difference (if one exists) may be either positive or negative.
 * A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.
 *
 * For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3)
 * alternate between positive and negative.
 * In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences.
 * The first is not because its first two differences are positive, and the second is not because
 * its last difference is zero.
 */
public class WiggleSubsequence {

  /*
  Note :  Take 2 counters. Increasing and Decreasing
      1   17   5   [10]   [13]   15   10   [5]    16    8

 Inc  1   2    2   4    4    4   4    4    6      6

 dec  1   1   3    3    3    3   5    5    5     7

 Next inc = pre dec + 1;
 Next dec = prev inc + 1;


   */
  public static int wiggleMaxLength(int[] nums) {
    int inc = 1; // For first number, it can be increasing or decreasing. So setting 1 in both.
    int dec = 1;

    for (int i=1; i<nums.length; i++) {
      if (nums[i] > nums[i-1]) {
        inc = dec + 1;
      } else if (nums[i] < nums[i-1]) {
        dec = inc + 1;
      } // If it is equal then do not change inc and dec.
    }

    return Math.max(inc, dec);
  }

  public static void main(String[] args) {
    int[] nums = {1,17,5,10,13,15,10,5,16,8};
    System.out.println(wiggleMaxLength(nums));
  }
}
