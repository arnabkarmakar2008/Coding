package com.example.coding.graph.algo.kahns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSTopoSortKahnsAlgo {

    //Kahn's Algorithm
    private static void findTopoSort(int numberOfVertices, ArrayList<ArrayList<Integer>> adjList) {
        // Have to create inDegree array. Number of incoming edges to a node

        int[] inDegree = new int[numberOfVertices];
        for (int count = 0; count < numberOfVertices; count++) {
            for (Integer itr : adjList.get(count)) {
                inDegree[itr]++; // Incoming edge to node itr
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int count = 0; count < numberOfVertices; count ++) {
            if (inDegree[count] == 0) {
                queue.add(count);
            }
        }

        while (!queue.isEmpty()) {
            int tempVertex = queue.poll();
            System.out.println(tempVertex);

            for (Integer itr : adjList.get(tempVertex)) {
                inDegree[itr]--; // Decrease inDegree count. When 0, insert into queue

                if (inDegree[itr] == 0) {
                    queue.add(itr);
                }
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int numberOfVertex = 4;

        for (int count=0; count < numberOfVertex; count++) {
            adjList.add(new ArrayList<Integer>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(3);
        adjList.get(1).add(2);
        adjList.get(2).add(3);

        findTopoSort(numberOfVertex, adjList);
    }
}
