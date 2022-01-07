package com.example.coding.graph.algo.kahns;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponentKosaraju {

    /**
     * SSC : A component in which if you start from any node then you can reach to any other node in the
     * component.
     * 0->1
     * 1->2 -> 3
     * 2->0
     * 3->4
     *
     * op: [012] [4] [5]
     *
     * Algo : 1. Sort vertex in order of finishing time - nothing but topo sort
     * 2. Transpose the graph : reverse the direction of the edges
     * 3. DFS based on finishing time on the transposed graph
     *
     */

    public static void dfs(int vertex, Stack<Integer> stack, int[] visited, ArrayList<ArrayList<Integer>> adjList) {
        visited[vertex] = 1;

        for (Integer itr : adjList.get(vertex)) {
            if (visited[itr] != 1) {
                dfs(itr, stack, visited, adjList);
            }
        }

        stack.push(vertex);
    }

    public static void revDfs(int vertex, int[] visited, ArrayList<ArrayList<Integer>> adjList) {
        visited[vertex] = 1;
        System.out.print(vertex + " ");

        for (Integer itr : adjList.get(vertex)) {
            if (visited[itr] != 1) {
                revDfs(itr, visited, adjList);
            }
        }
    }

    public static void kosaRaju(int numberOfVertices, ArrayList<ArrayList<Integer>> adjList) {

        int[] visited = new int[numberOfVertices];
        Stack<Integer> stack = new Stack<>();

        // Step 1 : Do dfs and store the vertices in stack like toposort
        for (int count=0; count < numberOfVertices; count ++) {
            if (visited[count] != 1) {
                dfs(count, stack, visited, adjList);
            }
        }

        // Step 2 : Transpose the graph
        ArrayList<ArrayList<Integer>> transposedAdjList = new ArrayList<ArrayList<Integer>>();
        for (int count=0; count < numberOfVertices; count ++) {
            transposedAdjList.add(count, new ArrayList<Integer>());
            visited[count] = 0; //reverting back to 0 as it was changed in prev dfs
        }

        for (int count=0; count < numberOfVertices; count ++) {
            for (Integer itr : adjList.get(count)) {
                transposedAdjList.get(itr).add(count);
            }
        }

        // Step 3 : dfs the transposed graph in reverseDFS from stack order
        while (!stack.empty()) {
            int tempVertex = stack.pop();

            if (visited[tempVertex] == 0) {
                System.out.println("SSC :: ");
                revDfs(tempVertex, visited, transposedAdjList);
                System.out.println("=======");
            }
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

        kosaRaju(5, adjList);

    }
}
