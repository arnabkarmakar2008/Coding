package com.example.coding.matrix.leetcode.medium;

/**
 * You are given a map of a server center, represented as a m * n integer matrix grid,
 * where 1 means that on that cell there is a server and 0 means that it is no server.
 * Two servers are said to communicate if they are on the same row or on the same column.
 *
 * Return the number of servers that communicate with any other server.
 */
public class CountServersThatCommunicate {

  public static int countServers(int[][] grid) {
    int count = -1;
    int rows = grid.length;
    int cols = grid[0].length;
    int totalComp = 0;

    int[] rowCompCount = new int[rows];
    int[] colCompCount = new int[cols];

    for (int i=0; i < rows; i++) {
      for (int j=0; j < cols; j++) {
        if (grid[i][j] == 1) {
          rowCompCount[i]++;
          colCompCount[j]++;
          totalComp++;
        }

      }
    }

    //Find isolated comp. If a single comp in a particular row and column, then comp is isolated
    for (int i=0; i < rows; i++) {
      for (int j=0; j < cols; j++) {
        if (grid[i][j] == 1) {
          if (rowCompCount[i] == 1 && colCompCount[j] == 1) {
            totalComp--;
          }
        }

      }
    }

    return totalComp;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
    System.out.println(countServers(grid));
  }
}
