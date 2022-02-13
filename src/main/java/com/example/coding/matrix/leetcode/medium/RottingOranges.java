package com.example.coding.matrix.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 */
public class RottingOranges {

  public static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
  public static int orangesRotting(int[][] grid) {
    int count = 0;
    int rows = grid.length;
    int cols = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();

    int freshCount = 0;

    for (int i=0; i< rows; i++) {
      for (int j=0; j < cols; j++) {
        if (grid[i][j] == 2) {
          queue.add(new int[] {i,j});
        } else if (grid[i][j] == 1) {
          freshCount++;
        }
      }
    }

    while (!queue.isEmpty()) {
      ++count;
      int size = queue.size();

      while (size > 0 ) {
        int[] rottenCell = queue.poll();
        int r = rottenCell[0];
        int c = rottenCell[1];

        for (int i = 0; i < 4; i++) {
          int nr = r + direction[i][0];
          int nc = c + direction[i][1];

          if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
            if (grid[nr][nc] == 1) {
              grid[nr][nc] = 2;
              queue.add(new int[]{nr, nc});
              freshCount--;
            }
          }
        }
        size--;

      }

    }


    /**
     * Think about that when we enter the while loop for the penultimate time, we have already marked
     * all the orange as rotted (don't care about -1 case here), and add them into the queue,
     * it means that when we enter the while loop in the last time, we have already polluted all oranges,
     * but still do (count++).
     * So we need to remove this time since all the orange are already rotted in the penultimate time.
     */
    return freshCount == 0 ? count-1 : -1;

  }

  public static void main(String[] args) {
    int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
    //int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
    System.out.println(orangesRotting(grid));
  }
}
