package com.example.coding.matrix.leetcode.medium;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
 * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 */
public class ShortestPathInBinaryMatrix {

  public static int[][] dimension = {{0,1},{0,-1},{1,0},{-1,0}, {-1,1},{-1,-1},{1,1},{1,-1}};
  public static int shortestPathBinaryMatrix(int[][] grid) {
    int rows = grid.length;
    boolean[][] visited = new boolean[rows][rows];
    Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
    int pathCount = 0;
    queue.add(new Pair(0,0));
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size > 0) {
        Pair<Integer, Integer> tempPair = queue.poll();
        int tempRow = tempPair.getKey();
        int tempCol = tempPair.getValue();

        if (tempRow == rows - 1 && tempCol == rows - 1) {
          return pathCount + 1;
        }

        for (int i = 0; i < dimension.length; i++) {
          int newR = tempRow + dimension[i][0];
          int newC = tempCol + dimension[i][1];

          if (newR < 0 || newC < 0 || newR >= rows || newC >= rows
                  || visited[newR][newC] == true || grid[newR][newC] == 1) {
            continue;
          }
          visited[newR][newC] = true;
          queue.add(new Pair(newR, newC));
        }
        size--;
      }

      pathCount++;
    }

    return pathCount;
  }
  public static void main(String[] args) {
    int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
    System.out.println(shortestPathBinaryMatrix(grid));
  }
}
