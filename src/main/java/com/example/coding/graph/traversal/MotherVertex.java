package com.example.coding.graph.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MotherVertex {
    /**
     * What is a Mother Vertex?
     * A mother vertex in a graph G = (V, E) is a vertex v such that all other vertices in G can be reached by a path from v.
     */

    public static void dfs (int src, ArrayList<ArrayList<Integer>> adjList, int[] visited, Stack<Integer> stack) {
        visited[src] = 1;

        for (Integer itr : adjList.get(src)) {
            if (visited[itr] != 1) {
                dfs (itr, adjList, visited, stack);
            }
        }

        stack.push(src);
    }

    public static int hasMotherVertex(int numberOfVertices, ArrayList<ArrayList<Integer>> adjList) {
        int[] visited = new int[numberOfVertices];
        Stack<Integer> stack = new Stack<>();

        for (int ct = 0; ct < numberOfVertices; ct++) {
            if (visited[ct] != 1) {
                dfs (ct, adjList, visited, stack);
            }
        }

        // pop the last element from stack. It can be mother vertex
        int lastVertex = stack.pop();

        Arrays.fill(visited, 0);
        dfs (lastVertex, adjList, visited, stack);

        for (int visitedValue : visited) {
            if (visitedValue == 0) {
                return -1;
            }
        }

        return 1;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int numberOfVertex = 5;

        for (int count=0; count <= numberOfVertex; count++) {
            adjList.add(new ArrayList<Integer>());
        }

        adjList.get(0).add(3);
        adjList.get(0).add(2);
        adjList.get(1).add(0);
        adjList.get(2).add(1);
        adjList.get(3).add(4);

        int value = hasMotherVertex(5, adjList);
        System.out.println(value == 1 ? "There is mother vertex" : "No mother vertex");

    }

}

