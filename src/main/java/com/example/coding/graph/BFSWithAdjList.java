package com.example.coding.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSWithAdjList {

    public static void bfs(int numberOfVertex, ArrayList<ArrayList<Integer>> adjList) {
        //visited list

        int[] visitedArray = new int[numberOfVertex + 1];

        for (int i = 0; i < visitedArray.length; i++) {
            visitedArray[i] = 0;
        }

        for (int i = 1; i <= numberOfVertex; i++) { // Need this loop for disconnected graph
            if (visitedArray[i] != 1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visitedArray[i] = 1;

                while (!queue.isEmpty()) {
                    Integer vertex = queue.poll();
                    System.out.println(vertex);

                    for (Integer it : adjList.get(vertex)) {
                        if (visitedArray[it] != 1) {
                            queue.add(it);
                            visitedArray[it] = 1;
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int numberOfVertex = 7;

        for (int count = 0; count <= numberOfVertex; count++) {
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
        adjList.get(2).add(7);
        adjList.get(3).add(2);
        adjList.get(7).add(2);

        adjList.get(3).add(5);
        adjList.get(5).add(3);

        adjList.get(7).add(5);
        adjList.get(5).add(7);

        adjList.get(4).add(6);
        adjList.get(6).add(4);

        for (int i = 1; i <= numberOfVertex; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" " + adjList.get(i).get(j));
            }

            System.out.println();
        }

        bfs(7, adjList);
    }
}
