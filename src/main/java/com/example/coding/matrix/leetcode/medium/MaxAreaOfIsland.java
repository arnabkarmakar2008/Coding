package com.example.coding.matrix.leetcode.medium;

import java.util.Stack;

class Cell {
  int row;
  int col;

  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
  }
}

/**
 * You are given an m x n binary matrix grid. An island is a
 * group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {

  public static int maxAreaOfIsland(int[][] grid) {
    int maxSum = 0;
    int row = grid.length;;
    int col = grid[0].length;

    boolean[][] visited = new boolean[row][col];
    Stack<Cell> stack = new Stack<>();

    int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    int count = 0;
    for (int i=0; i<row; i++) {
      for (int j=0; j<col; j++) {
        if (grid[i][j] == 1 && visited[i][j] != true) {
          count = 1;
          visited[i][j] = true;
          stack.push(new Cell(i,j));

          while (!stack.empty()) {
            Cell temp = stack.pop();

            for (int k=0; k<direction.length; k++) {
              int tempRow = temp.row + direction[k][0];
              int tempCol = temp.col + direction[k][1];

              if (tempRow>=0 && tempRow<row && tempCol>=0 && tempCol<col) {
                if (grid[tempRow][tempCol] == 1 && visited[tempRow][tempCol] != true) {
                  visited[tempRow][tempCol] = true;
                  count++;
                  stack.push(new Cell(tempRow, tempCol));

                }
              }
            }
          }
          maxSum = Math.max(maxSum, count);
        }
      }
    }


    return maxSum;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,1,1,0},{1,1,1,0},{0,0,0,0},{0,1,0,1}};
    System.out.println(maxAreaOfIsland(grid));
  }
}
