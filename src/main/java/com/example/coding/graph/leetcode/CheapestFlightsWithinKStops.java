package com.example.coding.graph.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * There are n cities connected by some number of flights.
 * You are given an array flights where flights[i] = [fromi, toi, pricei] indicates
 * that there is a flight from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src
 * to dst with at most k stops. If there is no such route, return -1.
 *
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 * Example 2:
 */
public class CheapestFlightsWithinKStops {
    static int minCost = Integer.MAX_VALUE;

    public static void minFlights(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> adjList = new ArrayList<>();

        for (int ct=0; ct <n; ct++) {
            adjList.add(ct, new ArrayList<>());
        }

        for (int i=0; i<flights.length; i++) {
            adjList.get(flights[i][0]).add(new Pair<>(flights[i][1], flights[i][2]));
        }

        int[] visited = new int[n];

        dfs(0,2, adjList, visited, 0, 3, 0);
        System.out.println(minCost);
    }


    public static void dfs(int source, int dest, ArrayList<ArrayList<Pair<Integer, Integer>>> adjList, int[] visited, int step, int k, int cost) {
        if (source == dest) {
            if (step <= k) {
                minCost = Math.min(minCost, cost);
            }
            return;
        }

        for (Pair<Integer, Integer> pair : adjList.get(source)) {
            if (visited[pair.getKey()] != 1) {
                visited[pair.getKey()] = 1;
                dfs(pair.getKey(), dest, adjList, visited, step+1, k, cost+ pair.getValue());
            }
        }
    }

    public static void main(String[] args) {
        int[][] flights = {{0,2,800},{0,1,100},{1,3,100},{3,2,100}};
        minFlights(4, flights, 0, 2, 2);
    }
}
