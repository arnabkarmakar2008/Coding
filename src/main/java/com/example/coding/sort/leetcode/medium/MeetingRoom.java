package com.example.coding.sort.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of
 * start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 *
 * Input: intervals = [(5,8),(9,15)]
 * Output: true
 * Explanation:
 * Two times will not conflict
 */
public class MeetingRoom {

  public static boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

    int[] prevInterval = intervals[0];

    for (int i=1; i<intervals.length; i++) {
      int[] currentInterval = intervals[i];
      if (prevInterval[1] > currentInterval[0]) {
        return false;
      } else {
        prevInterval = currentInterval;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int[][] intervals = {{1,4},{5,6},{8,10},{15,18}};
    System.out.println(canAttendMeetings(intervals));
  }
}
