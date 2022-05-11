package com.example.coding.sort.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a
 * balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates
 * of the balloons.
 *
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
 * A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to
 * the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in
 * its path.
 *
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 *
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 */
public class MinArrowsToBurstBaloons {

  /** Similar to non-overlapping intervals
   *
   * @param points
   * @return
   */
  public static int findMinArrowShots(int[][] points) {
    //Sort array based on starting location
    Arrays.sort(points, (arr1, arr2) -> arr1[0]-arr2[0]);

    int previousEnd = points[0][1];
    int balloonCount = 1;

    for (int i=1; i<points.length; i++) {
      int currentStarting = points[i][0];
      int currentEnd = points[i][1];

      if (currentStarting > previousEnd) {
        balloonCount++;
        previousEnd = currentEnd;
      } else {
        previousEnd = Math.min(currentEnd, previousEnd);
      }
    }


    return balloonCount;
  }

  public static void main(String[] args) {
    int[][] points = {{1,2},{3,4},{7,8},{5,6}};
    System.out.println(findMinArrowShots(points));
  }
}
