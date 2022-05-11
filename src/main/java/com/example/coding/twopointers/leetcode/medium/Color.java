package com.example.coding.twopointers.leetcode.medium;

/**
 * Given an array nums with n objects colored red, white,
 * or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red,
 * white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 */
public class Color {

  public static void sortColors(int[] nums) {
    //red = 0
    //white = 1
    //blue = 2

    int redCount = 0;
    int whiteCount = 0;
    int blueCount = 0;

    for (int i=0; i < nums.length; i++) {

      if (nums[i] == 0) {
        redCount++;
      }

      if (nums[i] == 1) {
        whiteCount++;
      }

      if (nums[i] == 2) {
        blueCount++;
      }
    }

    int counter = 0;

    while (counter < nums.length) {
      while (redCount > 0) {
        nums[counter] = 0;
        redCount--;
        counter++;
      }

      while (whiteCount > 0) {
        nums[counter] = 1;
        whiteCount--;
        counter++;
      }

      while (blueCount > 0) {
        nums[counter] = 2;
        blueCount--;
        counter++;
      }


    }

    for (int i=0; i< nums.length; i++) {
      System.out.println(nums[i]);
    }

  }

  public static void main(String[] args) {
    int[] nums = {2,0,2,1,1,0,2};
    sortColors(nums);
  }
}
