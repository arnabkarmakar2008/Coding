package com.example.coding.arrays.grind75;

/**
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith interval and
 * intervals is sorted in ascending order by starti. You are also given an interval
 * newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending
 * order by starti and intervals still does not have any overlapping intervals
 * (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 */
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] resultInterval = new int[intervals.length][2];
        int counter = 0;
        int resultCounter = 0;

        while (counter < intervals.length && intervals[counter][1] < newInterval[0]) {
            resultInterval[resultCounter][0] = intervals[counter][0];
            resultInterval[resultCounter][1] = intervals[counter][1];
            counter++;
            resultCounter++;
        }

        while (counter < intervals.length && intervals[counter][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[counter][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[counter][1], newInterval[1]);
            counter++;
        }

        resultInterval[resultCounter][0] = newInterval[0];
        resultInterval[resultCounter][1] = newInterval[1];
        resultCounter++;

        //Add rest of the elements
        while (counter < intervals.length) {
            resultInterval[resultCounter][0] = intervals[counter][0];
            resultInterval[resultCounter][1] = intervals[counter][1];
            counter++;
            resultCounter++;
        }

        return resultInterval;

    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

        int[][] resultInterval = insert(intervals, newInterval);

        System.out.println(resultInterval);

    }
}
