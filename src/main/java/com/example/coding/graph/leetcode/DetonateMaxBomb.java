package com.example.coding.graph.leetcode;

/**
 * You are given a list of bombs. The range of a bomb is defined as the area where its
 * effect can be felt. This area is in the shape of a circle with the center as the location
 * of the bomb.
 *
 * The bombs are represented by a 0-indexed 2D integer array bombs where
 * bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of
 * the location of the ith bomb, whereas ri denotes the radius of its range.
 *
 * You may choose to detonate a single bomb. When a bomb is detonated,
 * it will detonate all bombs that lie in its range. These bombs will further detonate
 * the bombs that lie in their ranges.
 *
 * Given the list of bombs, return the maximum number of bombs that can be detonated
 * if you are allowed to detonate only one bomb.
 */
public class DetonateMaxBomb {
    public static int count;

    //Note - Just a DFS problem. Need to run DFS for all nodes and if circle is within range
    //then increase count and traverse

    public int maximumDetonation(int[][] bombs) {
        int N = bombs.length;
        int result = Integer.MIN_VALUE;

        for (int i=0; i<N; i++) {
            count = 0;
            dfs(i, new boolean[N], bombs);
            result = Math.max(result, count);
        }

        return result;
    }

    private void dfs(int i, boolean[] visited, int[][] bombs) {
        visited[i] = true;
        count++;
        for (int ct = 0; ct < bombs.length; ct++) {
            if (visited[ct] == false && inRange(bombs[i], bombs[ct])) {
                visited[ct] = true;
                dfs(ct, visited, bombs);
            }
        }
    }


    public static boolean inRange(int a[], int b[]) {
        // Need to check if center of circle b lies inside circle a or not
        // Formula  = change in x square + change in y square <= radius square

        int changeinX = a[0] - b[0];
        int changeinY = a[1] - b[1];

        return changeinX*changeinX + changeinY*changeinY <= a[2]*b[2];
    }
}
