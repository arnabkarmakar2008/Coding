package com.example.coding.matrix.leetcode.medium;


import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
 *
 * If isWater[i][j] == 0, cell (i, j) is a land cell.
 * If isWater[i][j] == 1, cell (i, j) is a water cell.
 * You must assign each cell a height in a way that follows these rules:
 *
 * The height of each cell must be non-negative.
 * If the cell is a water cell, its height must be 0.
 * Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to
 * another
 * cell if the former is directly north, east, south, or west of the latter (i.e., their sides are
 * touching).
 * Find an assignment of heights such that the maximum height in the matrix is maximized.
 *
 * Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height.
 * If there are multiple solutions, return any of them.
 */
public class MapOfHighestPeak {

  public static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

  public static int[][] highestPeak(int[][] isWater) {
    int rows = isWater.length;
    int cols = isWater[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int[][] height = new int[rows][cols];
    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        // 1 is water 0 is land
        if (isWater[i][j] == 1) { // water cell
          height[i][j] = 0;
          queue.add(new int[] {i, j});
        } else {
          // Fill land cell with -1
          height[i][j] = -1;
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] arr = queue.remove();
      int row = arr[0];
      int col = arr[1];
      for (int k=0; k<dir.length; k++) {
        int newRow = row + dir[k][0];
        int newCol = col + dir[k][1];

        if (newRow>=0 && newRow< isWater.length && newCol>=0 && newCol< isWater[0].length
                && height[newRow][newCol] == -1) {
          height[newRow][newCol] = height[row][col] + 1;
          queue.add(new int[] {newRow, newCol});
        }
      }
    }

    return height;
  }

}
