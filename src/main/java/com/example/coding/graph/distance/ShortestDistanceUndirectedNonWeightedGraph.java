package com.example.coding.graph.distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceUndirectedNonWeightedGraph {

    public static void shortestPath(int source, int[] distArray, ArrayList<ArrayList<Integer>> adjList) {
        distArray[source] = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (Integer itr : adjList.get(temp)) {
                int tempDist = distArray[temp] + 1;

                if (tempDist < distArray[itr]) {
                    distArray[itr] = tempDist;
                    queue.add(itr);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int numberOfVertex = 5;

        for (int count=0; count < numberOfVertex; count++) {
            adjList.add(new ArrayList<Integer>());
        }

        //prepare adjList
        //1-2
        //2-3 2-7
        //3-5
        //7-5
        //4-6
        adjList.get(0).add(1);
        adjList.get(1).add(0);

        //adjList.get(1).add(3);
        //adjList.get(3).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        adjList.get(2).add(4);
        adjList.get(4).add(2);

        adjList.get(3).add(1);
        adjList.get(3).add(4);
        adjList.get(4).add(3);

        int[] distArray = new int[5];

        Arrays.fill(distArray, Integer.MAX_VALUE);

        shortestPath(0, distArray, adjList);

        for (int i : distArray) {
            System.out.println(i);
        }
    }
}
