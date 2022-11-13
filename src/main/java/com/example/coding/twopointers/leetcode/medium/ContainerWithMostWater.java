package com.example.coding.twopointers.leetcode.medium;


/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line
 * are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container
 * contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {

  /**
   * Move the short line as there is possibility to increase area. Whereas if we move long line and
   * keep short line same, area will surely decrease as we are reducing width.
   *
   * https://www.youtube.com/watch?v=TI3e-17YAlc
   *
   * @param height
   * @return
   */
  public static int maxArea(int[] height) {

    int maxArea = Integer.MIN_VALUE;
    int startPointer = 0;
    int endPointer = height.length-1;

    while (startPointer < endPointer) {
      int area = (endPointer-startPointer) * Math.min(height[startPointer], height[endPointer]);
      maxArea = Math.max(maxArea, area);

      if (height[startPointer] <= height[endPointer]) {
        startPointer++;
      } else {
        endPointer--;
      }
    }

    return maxArea;

  }


  public static void main(String[] args) {
    int[] height = {1,8,6,2,5,4,8,3,7};
    int water = maxArea(height);
    System.out.println(water);
  }
}
