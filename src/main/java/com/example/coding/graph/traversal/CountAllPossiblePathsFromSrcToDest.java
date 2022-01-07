package com.example.coding.graph.traversal;

import java.util.ArrayList;

public class CountAllPossiblePathsFromSrcToDest {

    public static int count = 0;

    public static void countNumberOfPaths(int src, int dest, ArrayList<ArrayList<Integer>> adjList) {
        if (src == dest) {
            count++;
            return;
        }

        for (Integer itr : adjList.get(src)) {
            countNumberOfPaths(itr, dest, adjList);
        }
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
        countNumberOfPaths(0,3,adjList);
        System.out.println(count);
    }
}
