package com.example.coding.matrix.leetcode.medium;


import java.util.LinkedList;
import java.util.Queue;

public class DetectCyclesIn2DGrid {
  public static int[][] dimension = {{0,1},{0,-1},{1,0},{-1,0}};

  public static boolean containsCycle(char[][] grid) {
    int rows = grid.length;;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    boolean flag = false;
    for (int i=0; i<rows; i++) {
      if (flag) break;
      for (int j=0; j< cols; j++) {
        if (grid[i][j] != 'x') {
          flag = dfs(grid, i, j, -1, -1, visited, grid[i][j]);
          if (flag) break;
        }
      }
    }

    if (flag) {
      System.out.println("Cycle detected");
    }

    return flag;

  }

  public static boolean dfs (char[][] grid, int row, int col, int parentRow, int parentCol, boolean[][] visited, char startChar) {

    boolean hasCycle = false;
    visited[row][col] = true;

    for (int i=0; i<4; i++) {
      int newR = row + dimension[i][0];
      int newC = col + dimension[i][1];

      if (newR < 0 || newC <0 || newR >= grid.length || newC >= grid[0].length) {
        continue;
      }

      //Do not visit parent cell again
      if (!(newR == parentRow && newC == parentCol)) {
        if (grid[newR][newC] == startChar) {
          if (visited[newR][newC]) {
            return true;
          } else {
            hasCycle = hasCycle | dfs (grid, newR, newC, row, col, visited, startChar);
          }
        }
      }

    }

    return hasCycle;
  }



  //This can be done using BFS.
  public static boolean containsCycleUsingBFS(char[][] grid) {
    int rows = grid.length;;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    boolean flag = false;
    for (int i=0; i<rows; i++) {
      for (int j=0; j< cols; j++) {
        if (visited[i][j]) {
          continue;
        } else {
          if (containCycleBFS(grid, visited, i, j)) {
            return true;
          }
        }
      }
    }
    return false;

  }

  private static boolean containCycleBFS(char[][] grid, boolean[][] visited, int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    char ch = grid[i][j];
    queue.add(new int[] {i,j,-1,-1});

    int currentI, currentJ, childI, childJ, parentI, parentJ;

    while (!queue.isEmpty()) {
      int[] currentPosition = queue.remove();

      currentI = currentPosition[0];
      currentJ = currentPosition[1];
      parentI = currentPosition[2];
      parentJ = currentPosition[3];

      if (visited[currentI][currentJ]) {
        //cycle detected
        return true;
      }

      visited[currentI][currentJ] = true;

      for (int[] direction : dimension) {
        childI = currentI + direction[0];
        childJ = currentJ + direction[1];

        if (childI >= 0 && childI < grid.length && childJ >=0 && childJ < grid[0].length
        && grid[childI][childJ] == ch && !(parentI == childI && parentJ == childJ)) {
          queue.add(new int[] {childI,childJ,currentI,currentJ});
        }
      }

    }

    return false;
  }

  public static void main(String[] args) {
    char[][] grid = {{'a','a','a','a'},{'c','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
    containsCycle(grid);
  }
}
