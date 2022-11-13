package com.example.coding.graph.leetcode;

import java.util.*;

public class EventualSaferState802 {
    /**
     * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
     * The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes
     * adjacent to node i, meaning there is an edge from node i to each node in graph[i].
     *
     * A node is a terminal node if there are no outgoing edges. A node is a safe node if every
     * possible path starting from that node leads to a terminal node.
     *
     * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
     *
     * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
     * Output: [2,4,5,6]
     * Explanation: The given graph is shown above.
     * Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
     * Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
     *
     *
     */


    /**
     * https://www.youtube.com/watch?v=4ymVOCiQBtw
     *
     * Here we have to find cycle in a directed graph. Also node which are part of cycle are not safe.
     * Else all are safe nodes.
     * So we
     *
     */
    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int ct=0; ct <n; ct++) {
            adjList.add(new ArrayList<>());
            adjList.get(ct).add(graph[ct][0]);
            adjList.get(ct).add(graph[ct][1]);
        }

        int[] visited = new int[n];
        int[] dfsVisited = new int[n];
        boolean[] partOfCycle = new boolean[n];

        for (int vertex = 0; vertex < n; vertex++) {
            if (visited[vertex] != 1) {
                dfsCycleCheck(vertex, adjList, visited, dfsVisited, partOfCycle);
            }
        }

        List<Integer> resultList = new ArrayList<>();

        for (int ct=0; ct < partOfCycle.length; ct++) {
            if (!partOfCycle[ct]) {
                resultList.add(ct);
            }
        }
        return resultList;
    }

    private static boolean dfsCycleCheck(int vertex, ArrayList<ArrayList<Integer>> adjList, int[] visited, int[] dfsVisited,
                                         boolean[] partOfCycle) {
        visited[vertex] = 1;
        dfsVisited[vertex] = 1;

        for (Integer itr : adjList.get(vertex)) {
            if (visited[itr] != 1) {
                if (dfsCycleCheck(itr, adjList, visited, dfsVisited,partOfCycle)) {
                    partOfCycle[vertex] = true; //We are starting from source. So source is part of cycle
                    return true;
                }
            } else if (dfsVisited[itr] == 1) { //both visited and dfsVisited are 1, then there is cycle
                partOfCycle[vertex] = true;
                return true;
            }
        }

        dfsVisited[vertex] = 0;
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};

        List<Integer> list = eventualSafeNodes(graph);

        System.out.println(list);
    }


}


