package com.example.coding.graph.leetcode;

import com.example.coding.graph.GraphNode;

import java.util.*;

public class ReorderRoutesToMakeAllPathToZero1466 {

    /**
     * n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
     */

    /**
     * Treat this graph as undirected. Put the direction in set. Do BFS traversal.
     * During traversal if path is from parent -> adj then need to reverse
     * @param n
     * @param connections
     * @return
     */
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i=0; i<n; i++) {
            adjList.add(i, new ArrayList<Integer>());
        }

        Set<String> set = new HashSet<>(); //storing the original direction

        for (int[] conn : connections) {
            adjList.get(conn[0]).add(conn[1]);
            adjList.get(conn[1]).add(conn[0]);
            set.add(conn[0] + "->" + conn[1]);
        }

        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[0] = 1;
        queue.add(0);
        int ans = 0;

        while (!queue.isEmpty()) {
            int tempNode = queue.poll();

            for (Integer itr : adjList.get(tempNode)) {
                if (visited[itr] != 1) {
                    queue.add(itr);
                    visited[itr] = 1;

                    if (set.contains(tempNode +"->" + itr)) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
