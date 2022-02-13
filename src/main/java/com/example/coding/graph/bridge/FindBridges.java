package com.example.coding.graph.bridge;

import com.example.coding.graph.GraphNode;

import java.util.ArrayList;

public class FindBridges {
    public static int timer = 0;
    public static void findBridges(int vertex, int parentVertex, int[] low, int[] insertionTime, int[] visited, ArrayList<ArrayList<Integer>> adjList) {
        visited[vertex] = 1;
        low[vertex] =  insertionTime[vertex] = timer++;

        for (Integer itr : adjList.get(vertex)) {
            //
            // low[] : which lowest discovered vertex it can touch with other route.
            //There are 3 categories of neighbour. 1. Visited & Parent 2. Visited 3. Unvisited.
            // 1 -> continue
            // 2 -> low[vertex] = min(low[vertex], discover/insertion time of visited neighbour
            // 3 ->

            if (itr == parentVertex) {
                continue;
            } else {
                if (visited[itr] != 1) {
                    findBridges(itr, vertex, low, insertionTime, visited, adjList);
                    low[vertex] = Math.min(low[vertex], low[itr]);

                    if (low[itr] > insertionTime[vertex]) {
                        System.out.println(itr +"-" + vertex);
                    }
                } else {
                    low[vertex] = Math.min(low[vertex], insertionTime[itr]);
                }
            }
        }
    }


}
