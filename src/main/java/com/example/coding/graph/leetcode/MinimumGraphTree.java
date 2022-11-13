package com.example.coding.graph.leetcode;

import java.util.*;

/**
 * A tree is an undirected graph in which any two vertices are connected by exactly one path.
 * In other words, any connected graph without simple cycles is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi]
 * indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any
 * node of the tree as the root. When you select a node x as the root, the result tree has height h.
 * Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 *
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 *
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class MinimumGraphTree {

    /**
     * Note : For the graph with odd no. of nodes, only the node at the middle of the graph when made the root, will give a minimum height tree.
     * For the graph with even no. of nodes, both the middle nodes when made the root give a minimum height tree.
     * Idea is to remove all leaf nodes till root.
     *
     * https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts
     *
     *
     * @param n
     * @param edges
     * @return
     */

    public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Set<Integer>> adj = new ArrayList<>();

        for (int ct=0; ct<n; ct++) {
            adj.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for (int ct=0; ct<n; ct++) {
            if (adj.get(ct).size() == 1) {
                leaves.add(ct); //Adding leaf nodes. Leaf node will have indegree 1
            }
        }

        /**
         * Idea is to remove leaf node one by one.
         */
        while ( n > 2) {
            n = n - leaves.size();

            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int parent = adj.get(leaf).iterator().next();
                adj.get(parent).remove(leaf);

                if (adj.get(parent).size() == 1) {
                    newLeaves.add(parent);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
     }




    public static void main(String[] args) {
        int N = 7;
        int edges[][] = {{3,0},{3,1},{3,2},{3,4},{5,4},{5,6}};

        List<Integer> list = findMinHeightTrees2(N, edges);
    }
}
