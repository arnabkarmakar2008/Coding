package com.example.coding.sort.leetcode.medium;

import java.util.Arrays;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

  /**
   * https://leetcode.com/problems/largest-number/discuss/53158/My-Java-Solution-to-share
   * @param nums
   * @return
   */
  public static String largestNumber(int[] nums) {
    String[] stringArray = new String[nums.length];

    for (int ct = 0; ct < nums.length; ct++) {
      stringArray[ct] = String.valueOf(nums[ct]);
    }

    Arrays.sort(stringArray, (str1, str2) -> {
      String firstComb = str1 + str2;
      String secondComb = str2 + str1;
      return secondComb.compareTo(firstComb);
    });

    StringBuilder sb = new StringBuilder();

    for (String str : stringArray) {
      sb.append(str);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    int[] nums = {3,30,34,5,9};
    System.out.println(largestNumber(nums));
  }
}
