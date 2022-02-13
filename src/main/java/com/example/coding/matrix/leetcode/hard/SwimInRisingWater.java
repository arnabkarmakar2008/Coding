package com.example.coding.matrix.leetcode.hard;

import java.util.PriorityQueue;

/**
 * You are given an n x n integer matrix grid where each value grid[i][j] represents
 * the elevation at that point (i, j).
 *
 * The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a
 * square to another 4-directionally adjacent square if and only if the elevation of both squares individually
 * are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries
 * of the grid during your swim.
 *
 * Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the
 * top left square (0, 0).
 */
public class SwimInRisingWater {

  //Note : Dijkstra only. Just we have to keep max of each path. And that we are storing in maxSoFar.
  public int swimInWater(int[][] grid) {
    int rows = grid.length;;
    int cols = grid[0].length;

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean[][] visited = new boolean[rows][cols];
    pq.add(new Pair(0,0, grid[0][0]));

    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    while (!pq.isEmpty()) {
      Pair tempPair = pq.poll();

      if (tempPair.row == rows-1 && tempPair.column == cols-1) {
        return tempPair.maxSoFar;
      }

      if (visited[tempPair.row][tempPair.column] == true) {
        //Already processed. No need to do again.
        continue;
      }

      visited[tempPair.row][tempPair.column] = true;

      for (int i=0; i<dir.length; i++) {
        int newRow = tempPair.row + dir[i][0];
        int newCol = tempPair.column + dir[i][1];

        if (newRow < 0 || newRow >= rows || newCol <0 || newCol >= cols || visited[newRow][newCol] == true) {
          continue;
        }

        pq.add(new Pair(newRow, newCol, Math.max(tempPair.maxSoFar, grid[newRow][newCol])));
      }

    }

    return 0;

  }

  public static void main(String[] args) {
    int[][] grid = {{0,2},{1,3}};

    SwimInRisingWater risingWater = new SwimInRisingWater();

    System.out.println(risingWater.swimInWater(grid));
  }

  class Pair implements Comparable<Pair> {
    int row, column, maxSoFar;

    public Pair(int row, int column, int maxSoFar) {
      this.row = row;
      this.column = column;
      this.maxSoFar = maxSoFar;
    }

    @Override
    public int compareTo(Pair o) {
      return this.maxSoFar - o.maxSoFar;
    }
  }
}
