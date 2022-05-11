package com.example.coding.sort.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and
 * end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.)
 *
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms
 * room1: (0,30)
 * room2: (5,10),(15,20)
 *
 */
public class MeetingRoomII {

  public static int meetingRoomRequired(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
    minHeap.add(intervals[0]); //minHeap top will contain the earliest ending meeting.


    for (int i=1; i<intervals.length; i++) {
      int[] intervalCurrent = intervals[i];
      int[] earliest = minHeap.remove();

      if (earliest[1] <= intervalCurrent[0]) {
        earliest[1] = intervalCurrent[1]; //If there is no overlap then do not add anything to heap. Just update the ending time.
      } else {
        minHeap.add(intervalCurrent);
      }

      minHeap.add(earliest); // Add it back for further comparison

    }

    return minHeap.size();
  }

  public static void main(String[] args) {
    int[][] intervals = {{0,30},{5,10},{15,20}};
    System.out.println(meetingRoomRequired(intervals));
  }
}
