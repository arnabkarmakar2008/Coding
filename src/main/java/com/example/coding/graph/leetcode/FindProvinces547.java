package com.example.coding.graph.leetcode;

public class FindProvinces547 {

    static int[] parent;
    static int[] rank;

    public static void makeSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

    }

    public static int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = findParent(parent[node]);
    }

    public static void union(int node1, int node2) {
        int p1 = findParent(node1);
        int p2 = findParent(node2);

        if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
        } else if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
            rank[p2]++;
        }
    }

    public static void main(String[] args) {
        makeSet(3);
        union(0,1);
        union(1,2);
        System.out.println(parent);
    }
}
