package com.example.coding.graph.bridge;

import com.example.coding.graph.GraphNode;

import java.util.ArrayList;

public class FindBridges {
    public static int timer = 0;
    public static void findBridges(int vertex, int parentVertex, int[] low, int[] insertionTime, int[] visited, ArrayList<ArrayList<Integer>> adjList) {
        visited[vertex] = 1;
        low[vertex] =  insertionTime[vertex] = timer++;

        for (Integer itr : adjList.get(vertex)) {
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
