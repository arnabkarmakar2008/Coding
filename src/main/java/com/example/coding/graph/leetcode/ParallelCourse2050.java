package com.example.coding.graph.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given an integer n, which indicates that there are n courses labeled from 1 to n.
 * You are also given a 2D integer array relations where relations[j] = [prevCoursej, nextCoursej]
 * denotes that course prevCoursej has to be completed before course nextCoursej (prerequisite relationship).
 * Furthermore, you are given a 0-indexed integer array time where time[i] denotes how many months it takes to complete the (i+1)th course.
 *
 * You must find the minimum number of months needed to complete all the courses following these rules:
 *
 * You may start taking a course at any time if the prerequisites are met.
 * Any number of courses can be taken at the same time.
 * Return the minimum number of months needed to complete all the courses.
 */
public class ParallelCourse2050 {

    /**
     * Kahn's toposort has been used.
     * @param n
     * @param relations
     * @param time
     * @return
     */

    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer> adj[] = new ArrayList[n];

        for (int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] completionTime = new int[n];
        int[] indegree = new int[n];

        for (int i=0; i<n; i++) {
            int u = relations[i][0]-1;
            int v = relations[i][1]-1;
            adj[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i =0; i<n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                completionTime[i] = time[i];
            }
        }

        while(!queue.isEmpty()) {
            int tempCourse = queue.poll();

            for (Integer itr : adj[tempCourse]) {
                completionTime[itr] = Math.max(completionTime[itr], (time[itr] + completionTime[tempCourse]));

                if (--indegree[itr] == 0) {
                    queue.add(itr);
                }
            }
        }

        int res=0;
        for(int x: completionTime) res = Math.max(res, x);
        return res;
    }
}
