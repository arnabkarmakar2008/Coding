package com.example.coding.sort.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 */
public class MergeIntervals {

  public static int[][] merge(int[][] intervals) {

    //Sort based on first element
    Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

    List<int[]> result = new ArrayList<>();

    int[] previousInterval = intervals[0];

    result.add(previousInterval);

    for (int i=1; i< intervals.length-1; i++) {
      int[] currentInterval = intervals[i];

      if (previousInterval[1] >= currentInterval[0]) {
        previousInterval[1] = Math.max(previousInterval[1], currentInterval[1]);
      } else {
        previousInterval = currentInterval;
        result.add(currentInterval);
      }
    }

    return result.toArray(new int[result.size()][]);

  }

  public static void main(String[] args) {
    int[][] intervals = {{1,4},{2,3},{8,10},{15,18}};
    int[][] response = merge(intervals);
    System.out.println(response);
  }
}
