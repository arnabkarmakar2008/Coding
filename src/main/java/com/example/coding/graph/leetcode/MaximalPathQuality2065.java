package com.example.coding.graph.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * There is an undirected graph with n nodes numbered from 0 to n - 1 (inclusive).
 * You are given a 0-indexed integer array values where values[i] is the value of the ith node.
 * You are also given a 0-indexed 2D integer array edges, where each edges[j] = [uj, vj, timej] indicates that
 * there is an undirected edge between the nodes uj and vj, and it takes timej seconds to travel between the two nodes.
 * Finally, you are given an integer maxTime.
 *
 * A valid path in the graph is any path that starts at node 0, ends at node 0, and takes at most maxTime seconds to complete.
 * You may visit the same node multiple times. The quality of a valid path is the sum of the values of the unique nodes visited
 * in the path (each node's value is added at most once to the sum).
 *
 * Return the maximum quality of a valid path.
 *
 * Note: There are at most four edges connected to each node.
 */
public class MaximalPathQuality2065 {

    public static int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        ArrayList<ArrayList<Pair<Integer,Integer>>> adjList = new ArrayList<ArrayList<Pair<Integer, Integer>>>();
        int[] visited = new int[values.length];

        for (int i=0; i< values.length; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (int i=0; i< edges.length; i++) {
            adjList.get(edges[i][0]).add(new Pair<>(edges[i][1], edges[i][2]));
            adjList.get(edges[i][1]).add(new Pair<>(edges[i][0], edges[i][2]));
        }

        int result = values[0];

        dfs(adjList, values, visited, 0, result, 0, 0, maxTime);

        return result;
    }

    public static void dfs (ArrayList<ArrayList<Pair<Integer,Integer>>> adjList, int[] values, int[] visited,
                            int vertex, int result, int score, int time, int maxTime ) {

        if (time > maxTime) {
            return;
        }

        if (visited[vertex] == 0) {
            score = score + values[vertex];
        }

        visited[vertex]++;

        if (vertex == 0) {
            result = Math.max(result, score);
        }

        //traverse adjList
        for (Pair<Integer, Integer> pair : adjList.get(vertex)) {
            int newTime = time + pair.getValue();
            dfs(adjList, values, visited, pair.getKey(), result, score, newTime, maxTime);
        }

        visited[vertex]--;
    }

    public static void main(String[] args) {
        int[] values = {0,32,10,43};
        int[][] edges = {{0,1,10},{1,2,15},{0,3,10}};
        System.out.println(maximalPathQuality(values, edges, 49));
    }
}
