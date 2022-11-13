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

  /**
   * https://www.youtube.com/watch?v=PWgFnSygweI
   * @param intervals
   * @return
   */
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

  /**
   * https://www.youtube.com/watch?v=FdzJmTCVyJU&t=508s -- neetcode
   *
   * @param intervals
   * @return
   */
  public static int meetingRoomRequiredNoHeap(int[][] intervals) {
    int[] startTime = new int[intervals.length];
    int[] endTime = new int[intervals.length];

    for (int ct=0; ct < intervals.length; ct++) {
      startTime[ct] = intervals[ct][0];
      endTime[ct] = intervals[ct][1];
    }

    int startCounter = 0;
    int endCounter = 0;

    int roomCount = 0;
    int maxRoomCount = 0;

    while (startCounter < intervals.length) {
      if (startTime[startCounter] > endTime[endCounter]) {
        roomCount++;
        startCounter++;
      } else if (endTime[endCounter] >= startTime[startCounter]) {
        roomCount--;
        endCounter++;
      }

      maxRoomCount = Math.max(maxRoomCount,roomCount);


    }

    return maxRoomCount;
  }

  public static void main(String[] args) {
    int[][] intervals = {{0,30},{5,10},{15,20}};
    System.out.println(meetingRoomRequired(intervals));
  }
}
