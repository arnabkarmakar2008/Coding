package com.example.coding.priorityqueue.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There is a car with capacity empty seats. The vehicle only drives east
 * (i.e., it cannot turn around and drive west).
 *
 * You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi]
 * indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them
 * off are fromi and toi respectively. The locations are given as the number of kilometers due east from the
 * car's initial location.
 *
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or
 * false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 */
public class CarPooling {

    public static boolean carPooling(int[][] trips, int capacity) {
        //Sort array based on start time
        Arrays.sort(trips, Comparator.comparingInt(trip->trip[1]));

        PriorityQueue<int[]> minPQ = new PriorityQueue<>(Comparator.comparingInt(trip->trip[2]));

        for (int[] trip : trips) {
            while (!minPQ.isEmpty() && trip[1] >= minPQ.peek()[2]) {
                capacity+= minPQ.poll()[0];
            }

            capacity -= trip[0];

            if (capacity <= 0) {
                return false;
            }

            minPQ.offer(trip);
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
