package com.example.coding.graph.leetcode;

import java.util.*;

/**
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
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
     * @param n
     * @param edges
     * @return
     */


    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        List<Integer> result = new ArrayList<>();


        //Create adjList and indegree count
        for (int count=0; count<edges.length; count++ ) {
            map.putIfAbsent(edges[count][0], new ArrayList<>());
            map.get(edges[count][0]).add(edges[count][1]);
            indegree[edges[count][0]]++;

            map.putIfAbsent(edges[count][1], new ArrayList<>());
            map.get(edges[count][1]).add(edges[count][0]);
            indegree[edges[count][1]]++;
        }

        //Push all indegree one into queue
        Queue<Integer> queue = new LinkedList<>();

        for (int count=0; count<n; count++) {
            if (indegree[count] == 1) {
                queue.add(count);
                indegree[count]--;
            }
        }

        int rootCount = n;

        while (rootCount > 2) {
            rootCount = rootCount - queue.size();
            result.clear();
            for (int count=0; count<queue.size(); count++) {
                int topVertex = queue.poll();
                for (int adjVertex : map.get(topVertex)) {
                    indegree[adjVertex]--;
                    map.get(adjVertex).remove(new Integer(topVertex));
                    if (indegree[adjVertex] == 1) {
                        queue.add(adjVertex);
                        result.add(adjVertex);
                    }
                }
            }


        }

        return result;

    }

    public static void main(String[] args) {
        int N = 7;
        int edges[][] = {{3,0},{3,1},{3,2},{3,4},{5,4},{5,6}};

        List<Integer> list = findMinHeightTrees(N, edges);
    }
}
