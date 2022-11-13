package com.example.coding.priorityqueue.leetcode.medium;

import java.util.PriorityQueue;

/**
 * Design a system that manages the reservation state of n seats that are numbered from 1 to n.
 *
 * Implement the SeatManager class:
 *
 * SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n.
 * All seats are initially available.
 * int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
 * void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
 */
public class SeatReservationManager {

    public static void main(String[] args) {

    }


    class SeatManager {

        PriorityQueue<Integer> minPQ;

        public SeatManager(int n) {
            minPQ = new PriorityQueue<>();

            for (int i=1; i<=n; i++) {
                minPQ.offer(i);
            }
        }

        public int reserve() {
            return minPQ.poll();
        }

        public void unreserve(int seatNumber) {
            minPQ.offer(seatNumber);
        }
    }

}
