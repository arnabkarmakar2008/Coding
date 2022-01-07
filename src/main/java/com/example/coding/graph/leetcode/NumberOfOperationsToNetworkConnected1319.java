package com.example.coding.graph.leetcode;

public class NumberOfOperationsToNetworkConnected1319 {
    /**
     * There are n computers numbered from 0 to n-1 connected by ethernet cables connections
     * forming a network where connections[i] = [a, b] represents a connection between
     * computers a and b. Any computer can reach any other computer directly or indirectly
     * through the network.
     *
     * Given an initial computer network connections.
     * You can extract certain cables between two directly connected computers,
     * and place them between any pair of disconnected computers to make them directly connected.
     * Return the minimum number of times you need to do this in order to make all the computers
     * connected. If it's not possible, return -1.
     *
     * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
     * Output: 1
     *
     * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
     * Output: 2
     *
     * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
     * Output: -1
     * Explanation: There are not enough cables.
     */

    private static int[] parent;
    private static int operation;

    public static void makeSet(int computerCount) {
        parent = new int[computerCount];

        for (int count=0; count<computerCount; count++) {
            parent[count] = count;
        }
    }

    public static int findParent(int computer) {
        if (parent[computer] == computer) {
            return computer;
        }

        return parent[computer] = findParent(parent[computer]);
    }

    public static void union(int computer1, int computer2) {
        int p1 = findParent(computer1);
        int p2 = findParent(computer2);

        if (p1 != p2) {
            parent[p2] = p1;
        } else {
            operation++;
        }
    }

    public static void findOperations(int computerCount, int[][] edges) {
        if (edges.length < computerCount-1) {
            operation = -1;
            return;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
    }

    public static void main(String[] args) {
        //int[][] edges = {{0,1},{0,2},{1,2}};
        int[][] edges = {{0,1},{0,2},{0,3},{1,2}};
        int computerCount = 6;
        makeSet(computerCount);
        findOperations(computerCount, edges);
        System.out.println("Number of operations : " + operation);

    }
}
