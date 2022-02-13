package com.example.coding.graph.leetcode;

import java.util.HashSet;
import java.util.Set;

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
     * Note : If there is cycle, then all nodes which are on cycle not part of safer nodes.
     * So have to detect cycles and have to find nodes which are on cycle. Non-cycle nodes are safer
     */


    public static Set<Integer> cycleNodes = new HashSet<>();
    public static Set<Integer> safeNodes = new HashSet<>();
    public static Set<Integer> visitedNodes = new HashSet<>();

    public static boolean dfsNotCycle(int node, int[][] graph, Set<Integer> visitedNodes) {
        if (cycleNodes.contains(node)) {
            return false; //node is part of cycle already
        }

        if (safeNodes.contains(node)) {
            return true; // safe node
        }

        if (visitedNodes.contains(node)) { //we have determined node is in cycle
            cycleNodes.add(node);
            return false;
        }

        visitedNodes.add(node);

        //Check child nodes
        for (int i : graph[node]) {
            if (!dfsNotCycle(i, graph, visitedNodes)) {
                cycleNodes.add(i);
                return false;
            }
        }

        safeNodes.add(node);
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};

        for (int node=0; node<graph.length; node++) {
            if (dfsNotCycle(node, graph, visitedNodes)) {
                System.out.println(node);
            }
        }
    }


}


