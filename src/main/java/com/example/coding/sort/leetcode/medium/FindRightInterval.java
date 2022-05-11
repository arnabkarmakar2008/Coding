package com.example.coding.sort.leetcode.medium;

import java.util.*;

/**
 * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
 *
 * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
 * Note that i may equal j.
 *
 * Return an array of right interval indices for each interval i. If no right interval exists
 * for interval i, then put -1 at index i.
 *
 * Input: intervals = [[3,4],[2,3],[1,2]]
 * Output: [-1,0,1]
 * Explanation: There is no right interval for [3,4].
 * The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
 * The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
 */
public class FindRightInterval {

  public static int[] findRightInterval(int[][] intervals) {

    TreeMap<Integer, Integer> map = new TreeMap<>(); //Store interval starting with index;

    int[] resultArray = new int[intervals.length];

    for (int i=0; i<intervals.length; i++) {
        map.put(intervals[i][0], i); // so we will store  3-0, 2-1, 1-2 start-index of start
    }

    for (int i=0; i<intervals.length; i++) {
      int endingInterval = intervals[i][1];

      //Now check if low of endingInterval exists in map or not.
      Integer ceilingKey = map.ceilingKey(endingInterval); //Returns the least key greater than or equal to the given key, or null if there is no such key.

      resultArray[i] = ceilingKey == null ? -1 : map.get(ceilingKey);
    }

    return resultArray;

  }

  public static void main(String[] args) {
    int[][] intervals = {{3,4},{2,3},{1,2}};
    System.out.println(findRightInterval(intervals));
  }
}
