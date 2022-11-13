package com.example.coding.priorityqueue.leetcode.medium;

import java.util.PriorityQueue;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane
 * and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the
 * order that it is in).
 */
public class KClosestPointsToOrigin {

    /**
     * https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
     * @param points
     * @param k
     * @return
     */
    public static int[][] kClosest(int[][] points, int k) {
        if (points.length == 1) {
            return points;
        }

        /*
        We have to take max heap here. Whenever heap size is more than K, it will kick out max distance element from the heap.
        That way at end we will have k closet distance in heap
         */
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((p1,p2) -> (p2[0]*p2[0] + p2[1]*p2[1]) - (p1[0]*p1[0] + p1[1]*p1[1]));

        for (int ct=0; ct<points.length; ct++) {
            maxpq.offer(points[ct]);

            if (maxpq.size() > k) {
                maxpq.poll();
            }

        }

        int[][] resArray = new int[k][2];

        while (k > 0) {
            resArray[k] = maxpq.poll();
            k--;
        }

        return resArray;
    }


    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k=2;

        int[][] closestPoints = kClosest(points, k);

    }
}
