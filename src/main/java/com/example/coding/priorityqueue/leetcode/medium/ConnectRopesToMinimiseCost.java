package com.example.coding.priorityqueue.leetcode.medium;

import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=9
 */
public class ConnectRopesToMinimiseCost {

    /**
     * Always connect two lowest length ropes to get min cost
     * @param ropes
     * @return
     */
    public static int minCost(int[] ropes) {
        int minCost = 0;
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (int ropeLength : ropes) {
            minPQ.offer(ropeLength);
        }

        while (minPQ.size() >=2 ) {
            int rope1 = minPQ.poll();
            int rope2 = minPQ.poll();

            minCost += rope1+rope2;

            //add the joined rope back in minPQ
            minPQ.offer(rope1+rope2);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[] ropes = {1,2,3,4,5};
        System.out.println(minCost(ropes));
    }
}
