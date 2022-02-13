package com.example.coding.matrix.leetcode.medium;

import javafx.util.Pair;

import java.util.*;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
 * The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right
 * and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where
 * heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east,
 * and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow
 * from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from
 * cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlow {

  /**
   * Note : Have to dfs for pacific row-colum and atlantic row-colum. Then do the intersection of the visited sets.
   */

  public static int[][] dimension = {{0,1},{0,-1},{1,0},{-1,0}};

  public static List<List<Integer>> pacificAtlantic(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;

    Set<Pair<Integer, Integer>> pacific = new HashSet<>();
    Set<Pair<Integer, Integer>> atlantic = new HashSet<>();

    for (int j=0; j < cols; j++) {
      dfs(heights, 0, j, heights[0][j], pacific);
      dfs(heights, rows-1, j, heights[rows-1][j], atlantic);
    }

    for (int i = 0; i< rows; i++) {
      dfs(heights, i, 0, heights[i][0], pacific);
      dfs(heights, i, cols - 1, heights[i][cols - 1], atlantic);
    }

    pacific.retainAll(atlantic);

    List<List<Integer>> list = new ArrayList<>();

    int count = 0;
    for (Pair<Integer, Integer> pair: pacific) {
      list.add(count, Arrays.asList(pair.getKey(), pair.getValue()));
      count++;
    }

    return list;
  }

  private static void dfs(int[][] heights, int row, int col, int prevHeight, Set<Pair<Integer, Integer>> set) {
    if (set.contains(new Pair<>(row, col)) || row < 0 || row >= heights.length || col <0 || col >= heights[0].length
            ||    prevHeight > heights[row][col]) {
      return;
    }

    set.add(new Pair<>(row, col));

    for (int k=0; k<4; k++) {
      int newR = row + dimension[k][0];
      int newC = col + dimension[k][1];
      dfs(heights, newR, newC, heights[row][col], set);
    }
  }

  public static void main(String[] args) {
    int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
    pacificAtlantic(heights);
  }
}
