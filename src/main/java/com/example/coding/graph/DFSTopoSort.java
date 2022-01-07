package com.example.coding.graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFSTopoSort {

    private static void findTopoSort(int vertex, ArrayList<ArrayList<Integer>> adjList, int[] visited,
                                     Stack<Integer> stack) {
        visited[vertex] = 1;

        for (Integer itr : adjList.get(vertex)) {
            if (visited[itr] != 1) {
                findTopoSort(itr, adjList, visited, stack);
            }
        }

        stack.push(vertex);
    }

    public static void topoSort(int numberOfVertices, ArrayList<ArrayList<Integer>> adjList) {
        int[] visited = new int[numberOfVertices+1];
        Stack<Integer> stack = new Stack<>();

        for (int vertex = 1; vertex < visited.length; vertex ++) {
            if (visited[vertex] != 1) {
                findTopoSort(vertex, adjList, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int numberOfVertex = 5;

        for (int count=0; count < numberOfVertex; count++) {
            adjList.add(new ArrayList<Integer>());
        }

        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(0);
        adjList.get(3).add(4);

        topoSort(numberOfVertex, adjList);
    }
}
