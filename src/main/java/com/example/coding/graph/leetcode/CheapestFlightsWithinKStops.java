package com.example.coding.graph.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;

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
