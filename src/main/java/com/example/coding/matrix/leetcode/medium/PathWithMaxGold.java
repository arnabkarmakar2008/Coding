package com.example.coding.matrix.leetcode.medium;

public class PathWithMaxGold {

  public static int getMaximumGold(int[][] grid) {
    int maxPath = Integer.MIN_VALUE;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i=0; i<grid.length;i++) {
      for (int j=0; j<grid[0].length;j++) {
        if (grid[i][j] != 0) {
          int sumPath = maxPath(grid, i, j, new boolean[grid.length][grid[0].length]);
          maxPath = Math.max(maxPath, sumPath);
        }
      }
    }
    return maxPath;
  }

  public static int maxPath(int[][] grid, int row, int col, boolean[][] visited) {
    if (grid[row][col] ==0) {
      return 0;
    }

    visited[row][col] = true;
    grid[row][col] += 1000;
    int leftMax = Integer.MIN_VALUE;
    int rightMax =  Integer.MIN_VALUE;
    int topMax =  Integer.MIN_VALUE;
    int bottomMax =  Integer.MIN_VALUE;

    if (row-1 >=0 && visited[row-1][col] == false) {
      topMax = maxPath(grid, row-1, col, visited);
    }

    if (row+1 < grid.length && visited[row+1][col] == false) {
      bottomMax = maxPath(grid, row+1, col, visited);
    }

    if (col-1 > 0 && visited[row][col-1] == false) {
      leftMax = maxPath(grid, row, col-1, visited);
    }

    if (col+1 < grid[0].length && visited[row][col+1] == false) {
      rightMax = maxPath(grid, row, col+1, visited);
    }

    return grid[row][col] + Math.max(Math.max(Math.max(topMax,bottomMax), leftMax), rightMax);
  }

  public static void main(String[] args) {
    int[][] grid = {{0,6,0},{5,8,7},{0,10,0}};
    System.out.println(getMaximumGold(grid));
  }
}
