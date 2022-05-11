package com.example.coding.sort.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of the
 * intervals non-overlapping.
 *
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 */
public class NonOverlappingInterval {

  /**
   * https://www.youtube.com/watch?v=nONCGxWoUfM
   * @param intervals
   * @return
   */
  public static int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
    int removeCount = 0;

    int previousEnd = intervals[0][1];

    for (int i=1; i<intervals.length; i++) {
      int currentEnd = intervals[i][1];
      int currentStart = intervals[i][0];

      if (currentStart >= previousEnd) {
        previousEnd = currentEnd; // Not overlapping
      } else {
        removeCount++;
        previousEnd = Math.min(previousEnd, currentEnd); // Overlapping. We have to remove with max end as there is more
        //chance to overlap. We have to return min number.
      }
    }
    return removeCount;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
    System.out.println(eraseOverlapIntervals(intervals));
  }
}
