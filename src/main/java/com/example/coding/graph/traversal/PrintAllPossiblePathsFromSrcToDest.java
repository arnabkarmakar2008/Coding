package com.example.coding.graph.traversal;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPossiblePathsFromSrcToDest {


    public static void dfs(int src, int dest, ArrayList<ArrayList<Integer>> adjList, int[] visited, List<Integer> path) {
        if (src == dest) {
            //print path;
            System.out.println("======");
            for (Integer i : path) {
                System.out.println(i);
            }
            return;
        }

        visited[src] = 1;
        path.add(src);

        for (Integer itr : adjList.get(src)) {
            if (visited[itr] != 1) {
                path.add(itr);
                dfs(itr, dest, adjList, visited, path);
                path.remove(itr);
            }
        }

        visited[src] = 0;
        path.remove(src);
    }

    public static void printPaths(ArrayList<ArrayList<Integer>> adjList, int vertexCount, int src, int dest) {
        int[] visited = new int[vertexCount];
        List<Integer> path = new ArrayList<>();
        dfs(src, dest,adjList, visited, path);
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int numberOfVertex = 4;

        for (int count=0; count <= numberOfVertex; count++) {
            adjList.add(new ArrayList<Integer>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        printPaths(adjList, 4, 0, 3);
    }
}
