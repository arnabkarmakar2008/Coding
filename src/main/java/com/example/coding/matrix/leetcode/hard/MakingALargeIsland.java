package com.example.coding.matrix.leetcode.hard;

import javafx.util.Pair;

import java.util.*;

/**
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 *
 * Return the size of the largest island in grid after applying this operation.
 *
 * An island is a 4-directionally connected group of 1s.
 */
public class MakingALargeIsland {


  public static int largestIsland(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int result = 0;
    int maxArea = 0;
    int index = 3; //Starting from 3 to number island

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i=0; i< rows; i++) {
      for (int j=0; j< cols; j++) {
        if (grid[i][j] == 1) {
          int area = dfs (grid, i, j, index);
          map.put(index, area);
          maxArea = Math.max(maxArea, area);
        }
      }
    }

    // Now for each 0 cell check if it is touching any island or not. If yes then max area

    for (int i=0; i< rows; i++) {
      for (int j=0; j< cols; j++) {
        if (grid[i][j] == 0) {
          Set<Integer> visitedSet = new HashSet<>();

          for (Pair<Integer, Integer> pair : move(i,j,grid)) {
            // If we are getting any island in neighbour get the area of that islane from map
            int cellValue = grid[pair.getKey()][pair.getValue()];

            if (map.containsKey(cellValue) && !visitedSet.contains(cellValue)) {
              visitedSet.add(cellValue);
              // There is unvisited island in the neighbour
              result = Math.max(result, 1 + map.get(cellValue)); //Adding 1 as we have to calculate 0 cell to 1.
            }

          }
        }
      }
    }

    return result;
  }

  private static int dfs(int[][] grid, int row, int column, int index) {
    int area = 0;

    grid[row][column] = index; // Apply index to each and every island

    for (Pair<Integer, Integer> pair : move(row,column, grid)) {
      if (grid[pair.getKey()][pair.getValue()] == 1) {
        area += dfs(grid, pair.getKey(), pair.getValue(), index);
      }
    }

    return 1 + area;
  }

  private static List<Pair<Integer,Integer>> move (int row, int col, int[][] grid) {
    List<Pair<Integer, Integer>> list = new ArrayList<>();

    if (isValid(row+1, col, grid)) list.add(new Pair(row+1, col));
    if (isValid(row-1, col, grid)) list.add(new Pair(row-1, col));
    if (isValid(row, col+1, grid)) list.add(new Pair(row, col+1));
    if (isValid(row, col-1, grid)) list.add(new Pair(row, col-1));

    return list;
  }

  private static boolean isValid(int row, int col, int[][] grid) {
    return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,0},{0,1}};
  }

}
