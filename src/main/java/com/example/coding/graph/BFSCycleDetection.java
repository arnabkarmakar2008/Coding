package com.example.coding.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSCycleDetection {


    private static boolean bfsCycleCheckTraversal(int vertex, ArrayList<ArrayList<Integer>> adjList, int[] visited) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<Integer, Integer>(vertex, -1));
        visited[vertex] = 1;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> tempPair = queue.poll();

            for (Integer itr : adjList.get(tempPair.getKey())) {
                if (visited[itr] == 1 && tempPair.getValue() != itr) { // Parent is diff than current vertex
                    return true;
                }
                else if (visited[itr] == 0) {
                    visited[itr] = 1;
                    queue.add(new Pair<Integer, Integer>(itr, tempPair.getKey()));
                }
            }
        }

        return false;
    }


    public static boolean bfsCycleCheck(int numberOfVertex, ArrayList<ArrayList<Integer>> adjList) {
        int[] visited = new int[numberOfVertex+1];

        for (int i=1; i< visited.length; i++) {
            if (visited[i] != 1) {
                if (bfsCycleCheckTraversal(i, adjList, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        /**
         * We have to store node - prev node in queue. Now if for any node, if adj node is already visited
         * and visited node is not prev node thn there is cycle.
         */

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int numberOfVertex = 7;

        for (int count=0; count <= numberOfVertex; count++) {
            adjList.add(new ArrayList<Integer>());
        }

        //prepare adjList
        //1-2
        //2-3 2-7
        //3-5
        //7-5
        //4-6
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        adjList.get(2).add(3);
        //adjList.get(2).add(7);
        adjList.get(3).add(2);
        //adjList.get(7).add(2);

        adjList.get(3).add(5);
        adjList.get(5).add(3);

        adjList.get(7).add(5);
        adjList.get(5).add(7);

        adjList.get(4).add(6);
        adjList.get(6).add(4);

        System.out.println(bfsCycleCheck(7, adjList));
    }
}
