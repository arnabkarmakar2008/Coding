package com.example.coding.matrix.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

//Note similar to number of island
public class NumberOfDistinctIsland {
  public static int[][] dimensions = {{0,1},{0,-1},{1,0},{-1,0}};
  public static String islandString = "";
  public static int numIslands(char[][] grid) {
    int count = 0;
    Set<String> set = new HashSet<>();
    for (int i=0; i< grid.length; i++) {
      for (int j=0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          islandString = "";
          String dfsString = dfs(grid, i, j,"X");
          set.add(dfsString);
          count++;
        }
      }
    }


    return set.size();
  }

  public static String dfs(char[][] grid, int row, int col, String dir) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
      return "O";
    }

    grid[row][col] = '0';
    String allDirection = "";
    for (int i=0; i< dimensions.length; i++) {
      if (i==0) dir = "R";
      if (i==1) dir = "L";
      if (i==2) dir = "D";
      if (i==3) dir = "U";
      allDirection = allDirection + dfs(grid, row + dimensions[i][0], col + dimensions[i][1], dir);
    }

    return dir + allDirection;
  }

  public static void main(String[] args) {
    char[][] grid = {{'1','1','0','0','0'},{'1','0','0','0','0'},{'1','1','0','0','0'},{'1','0','0','1','1'}};
    System.out.println(numIslands(grid));
  }
}
