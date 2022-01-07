package com.example.coding.graph.algo.kahns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSCycleDetectionKahnsAlgo {

    //Kahn's Algorithm
    // Toposort is possible only in DAG. If there is cycle in the graph then topo sort is not possible
    // Kahn's algo will be used to generate toposort. If number of vertices in topo sort is less
    //then total number, then there is cycle.
    private static boolean findCycle(int numberOfVertices, ArrayList<ArrayList<Integer>> adjList) {
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

        int topoCount = 0;

        while (!queue.isEmpty()) {
            int tempVertex = queue.poll();
            topoCount++;
            for (Integer itr : adjList.get(tempVertex)) {
                inDegree[itr]--; // Decrease inDegree count. When 0, insert into queue

                if (inDegree[itr] == 0) {
                    queue.add(itr);
                }
            }
        }

        if (topoCount == numberOfVertices) {
            return false;
        } else {
            return true;
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
        //adjList.get(2).add(0);

        System.out.println(findCycle(numberOfVertex, adjList));
    }
}
