package com.example.coding.graph;

import java.util.ArrayList;

public class DFSWithAdjList {


    public static void dfs(int vertex, ArrayList<ArrayList<Integer>> adjList, int[] visitedArray) {
        System.out.println(vertex);
        visitedArray[vertex] = 1;

        for (Integer adjVertex : adjList.get(vertex)) {
            if (visitedArray[adjVertex] != 1) {
                dfs(adjVertex, adjList, visitedArray);
            }
        }
    }

    public static void dfsGraph(int vertexCount, ArrayList<ArrayList<Integer>> adjList) {
        int[] visitedArray = new int[vertexCount+1];

        for (int count = 1; count < visitedArray.length; count ++) {
            if (visitedArray[count] != 1) {
                dfs(count, adjList, visitedArray);
            }
        }
    }


    public static void main(String[] args) {
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
        adjList.get(2).add(7);
        adjList.get(3).add(2);
        adjList.get(7).add(2);

        adjList.get(3).add(5);
        adjList.get(5).add(3);

        adjList.get(7).add(5);
        adjList.get(5).add(7);

        adjList.get(4).add(6);
        adjList.get(6).add(4);

        for (int i=1; i <= numberOfVertex; i++) {
            System.out.print(i + " ");
            for (int j=0; j < adjList.get(i).size(); j++) {
                System.out.print(" " + adjList.get(i).get(j));
            }

            System.out.println();
        }

        dfsGraph(7, adjList);
    }
}
