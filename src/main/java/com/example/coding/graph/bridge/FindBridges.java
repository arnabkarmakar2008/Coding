package com.example.coding.graph.bridge;

import com.example.coding.graph.GraphNode;

import java.util.ArrayList;

public class FindBridges {

    public static int[] parent;
    public static int[] disc;
    public static int[] low;
    public static boolean[] ap;
    public static boolean[] vis;

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

    public static void articulationPoint(ArrayList<ArrayList<Integer>> adjList) {
        parent = new int[adjList.size()];
        low = new int[adjList.size()];
        disc = new int[adjList.size()];
        vis = new boolean[adjList.size()];
        ap = new boolean[adjList.size()];

        parent[0] = -1;
        dfs(0, adjList);
    }

    public static void dfs(int source, ArrayList<ArrayList<Integer>> adjList) {
        disc[source] = timer;
        low[source] = timer;
        timer++;
        vis[source] = true;
        int count = 0;

        ArrayList<Integer> adjNodes = adjList.get(source);

        for (int ct=0; ct < adjNodes.size(); ct++) {
            int adjNode = adjNodes.get(ct);

            if (parent[source] == adjNode) {
                continue;
            } else if (vis[adjNode] == true) {
                low[source] = Math.min(low[source], disc[adjNode]);
            } else {
                count++;
                parent[adjNode] = source;
                dfs(adjNode, adjList);
                low[source] = Math.min(low[source], low[adjNode]);

                //For original source we have to add this logic

                if (parent[source] == -1) {
                    if (count >= 2) {
                        ap[source] = true;
                    }
                } else {
                    if (low[adjNode] >= disc[source]) {
                        //source -> adjNode will be bridge
                        ap[source] = true;
                    }
                }
            }
        }
    }


}
