package com.example.coding.twopointers.leetcode.hard;

/**
 * Given n non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it can trap after raining.
 */
public class TrappingRainWater {

  /**
   * https://www.youtube.com/watch?v=C8UjlJZsHBw
   * @param height
   * @return
   */
  public static int trap(int[] height) {
    //Calculate maxLeft and maxRight for each index.

    int[] maxLeftArray = new int[height.length];
    int[] maxRightArray = new int[height.length];

    int maxLeft = 0;
    int maxRight = 0;

    //populate maxLeftArray
    for (int i=0; i< height.length; i++) {
      if (i == 0) {
        maxLeftArray[i] = 0;
      } else {
        maxLeftArray[i] = maxLeft;
      }

      if (height[i] > maxLeft) {
        maxLeft = height[i];
      }
    }

    //populate maxRightArray
    for (int i = height.length-1; i>=0; i--) {
      if (i == height.length-1) {
        maxRightArray[i] = 0;
      } else {
        maxRightArray[i] = maxRight;
      }

      if (height[i] > maxRight) {
        maxRight = height[i];
      }
    }

    //Water calculation = Min(MaxLeft, MaxRight) - height[i]
    //First and last index will not store water.
    int totalWater = 0;
    for (int i=1; i <= height.length-2; i++) {
      int waterLevel = Math.min(maxLeftArray[i], maxRightArray[i]);

      if (waterLevel > height[i]) {
        totalWater += waterLevel - height[i];
      }
    }

    return totalWater;

  }

  public static void main(String[] args) {
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(trap(height));
  }
}
