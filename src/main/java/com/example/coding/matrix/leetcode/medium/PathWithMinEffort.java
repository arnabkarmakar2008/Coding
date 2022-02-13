package com.example.coding.matrix.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size
 * rows x columns, where heights[row][col] represents the height of cell (row, col).
 * You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell,
 * (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find
 * a route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of t
 * he route.
 *'
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 */
public class PathWithMinEffort {

  public static int[][] dimension = {{0,1},{0,-1},{1,0},{-1,0}};

  public static int minimumEffortPath(int[][] heights) {
    int rows = heights.length;;
    int cols = heights[0].length;

    int[][] dist = new int[rows][cols];

    for (int i=0; i< rows; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

    minHeap.add(new int[] {0,0,0}); // Adding (0,0) cell

    while (!minHeap.isEmpty()) {
      int[] top = minHeap.poll();
      int topDistance = top[0];
      int r = top[1], c = top[2];

      if (r == rows-1 && c == cols-1) {
        return topDistance; // Reached last cell
      }

      for (int i=0; i<4; i++) {
        int newR = r + dimension[i][0], newCol = c + dimension[i][1];

        if (newR < 0 || newR >= rows || newCol < 0 || newCol >= cols) {
          continue;
        }

        int newDistance = Math.max(topDistance, Math.abs(heights[newR][newCol] - heights[r][c]));
        if (newDistance < dist[newR][newCol]) {
          dist[newR][newCol] = newDistance;
          minHeap.add(new int[] {newDistance, newR, newCol});
        }
      }


    }

    return 0;
  }

  public static void main(String[] args) {
    int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
  }
}
