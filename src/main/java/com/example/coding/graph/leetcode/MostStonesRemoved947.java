package com.example.coding.graph.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemoved947 {
    /**
     * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
     *
     * A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
     *
     * Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
     *
     * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
     * Output: 5
     * Explanation: One way to remove 5 stones is as follows:
     * 1. Remove stone [2,2] because it shares the same row as [2,1].
     * 2. Remove stone [2,1] because it shares the same column as [0,1].
     * 3. Remove stone [1,2] because it shares the same row as [1,0].
     * 4. Remove stone [1,0] because it shares the same column as [0,0].
     * 5. Remove stone [0,1] because it shares the same row as [0,0].
     * Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
     */


    /**
     * We have to find number of connected components. We cannot remove last stone from a component.
     * So if there are M components, we cannot remove M stones. So stones can be moved = N-M.
     * If 2 stones share either row or column then they are connected. We have to do union find.
     *
     *
     */

    class DSU {
        int[] parent;
        int N;

        public DSU(int n) {
            N = n;
            parent = new int[n];

            for (int i=0; i<n; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int stone) {
            if (parent[stone] == stone) {
                return stone;
            }

            return parent[stone] = findParent(parent[stone]);
        }

        public void unionByRank(int stone1, int stone2) {
            int parent1 = findParent(stone1);
            int parent2 = findParent(stone2);

            if (parent1 != parent2) {
                parent[parent1] = parent2;
                N--;
            }
        }
    }


    public int removeStones(int[][] stones) {
        int size = stones.length;
        DSU dsu = new DSU(size);

        for (int i=0; i<size-1; i++) {
            for (int j = i+1; j<size; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.unionByRank(i, j);
                }
            }

        }

        return size - dsu.N;
    }

    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0}, {1,2}, {2,1}, {2,2}};

        int computerCount = 6;
        MostStonesRemoved947 sol = new MostStonesRemoved947();
        int ct = sol.removeStones(stones);
        System.out.println(ct);

    }
}
