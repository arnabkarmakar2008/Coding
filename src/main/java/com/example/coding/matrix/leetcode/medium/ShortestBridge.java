package com.example.coding.matrix.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's.
 * There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 */
public class ShortestBridge {

  public static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

  //Note : Do DFS and add all 1's of first island in queue. Then for each queue element do BFS and
  // return step count as soon as second island is found.

  public static int shortestBridge(int[][] grid) {
    int count = 0;
    int rows = grid.length;;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    Queue<int[]> q = new LinkedList<>();

    boolean found = false;

    for (int i=0; i< rows; i++) {

      if (found) {
        break;
      }

      for (int j=0; j < cols; j++) {
        if (grid[i][j] == 1) {
          dfs(grid, i, j, q, visited);
          found = true;
        }
      }
    }

    // Now do BFS
    while(!q.isEmpty()) {
      int size = q.size();

      while (size > 0) {
        int[] tempCell = q.poll();
        int r = tempCell[0];
        int c = tempCell[1];

        for (int k=0; k< direction.length; k++) {
          int newR = r + direction[k][0];
          int newC = c + direction[k][1];

          if (newR >= 0 && newR < rows && newC >=0 && newC < cols && visited[newR][newC] == false) {
            if (grid[newR][newC] == 1) {
              return count;

            }

            visited[newR][newC] = true;
            q.add(new int[]{newR, newC});

          }
        }
        size--;
      }
      count++;
    }

    return count;

  }

  public static void dfs (int[][] grid, int row, int col, Queue<int[]> q, boolean[][] visited) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
            || visited[row][col] == true || grid[row][col] == 0) {
      return;
    }

    visited[row][col] = true;
    q.offer(new int[] {row, col});

    for (int k=0; k< direction.length; k++) {
      dfs(grid, row + direction[k][0], col + direction[k][1], q, visited);
    }
  }

  public static void main(String[] args) {
    int[][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
    System.out.println(shortestBridge(grid));
  }


}
