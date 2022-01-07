package com.example.coding.graph;

import java.util.ArrayList;

public class DFSDirectedCycleDetection {




    private static boolean dfsCycleCheck(int vertex, ArrayList<ArrayList<Integer>> adjList, int[] visited, int[] dfsVisited) {
            visited[vertex] = 1;
            dfsVisited[vertex] = 1;

            for (Integer itr : adjList.get(vertex)) {
                if (visited[itr] != 1) {
                    if (dfsCycleCheck(itr, adjList, visited, dfsVisited)) {
                        return true;
                    }
                } else if (dfsVisited[itr] == 1) { //both visited and dfsVisited are 1, then there is cycle
                    return true;
                }
            }

            dfsVisited[vertex] = 0;
            return false;
    }

    public static boolean isCyclic(int numberOfVertices, ArrayList<ArrayList<Integer>> adjList) {
        //Need to take visited and dfsVisited array.
        int[] visited = new int[numberOfVertices + 1];
        int[] dfsVisited = new int[numberOfVertices + 1];

        for (int vertex = 1; vertex < numberOfVertices; vertex++) {
            if (visited[vertex] != 1) {
                if (dfsCycleCheck(vertex, adjList, visited, dfsVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int numberOfVertex = 3;

        for (int count=0; count <= numberOfVertex; count++) {
            adjList.add(new ArrayList<Integer>());
        }

        adjList.get(1).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(3);

        System.out.println(isCyclic(3, adjList));
    }
}
