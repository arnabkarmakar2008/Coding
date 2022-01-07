package com.example.coding.graph.leetcode;

public class RedundantConnection684 {
    /**
     * Union find solution. If parents of two edges are same then redundant
     */

    static int[] parent;


    public static void makeSet(int n) {
        parent = new int[n+1];
        for (int i=0; i<=n; i++) {
            parent[i] = i;
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

        if (p1 != p2) {
            parent[p2] = p1;
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[] {-1,-1};
        makeSet(edges.length);
        for (int[] edge : edges) {
            int p1 = findParent(edge[0]);
            int p2 = findParent(edge[1]);

            if (p1 != p2) {
                union(p1,p2);
            } else {
                res[0] = edge[0];
                res[1] = edge[1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] edges = new int[3][2];

        edges[0] = new int[] {1,2};
        edges[1] = new int[] {1,3};
        edges[2] = new int[] {2,3};
        findRedundantConnection(edges);

    }
}
