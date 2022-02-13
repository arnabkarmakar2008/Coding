package com.example.coding.matrix.leetcode.medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare
 * of forested land and a 1 represents a hectare of farmland.
 *
 * To keep the land organized, there are designated rectangular areas of hectares
 * that consist entirely of farmland. These rectangular areas are called groups. No t
 * wo groups are adjacent, meaning farmland in one group is not four-directionally
 * adjacent to another farmland in a different group.
 *
 * land can be represented by a coordinate system where the top left corner of
 * land is (0, 0) and the bottom right corner of land is (m-1, n-1).
 * Find the coordinates of the top left and bottom right corner of each group of farmland.
 * A group of farmland with a top left corner at (r1, c1) and a bottom right corner
 * at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].
 *
 * Return a 2D array containing the 4-length arrays described above for each group
 * of farmland in land. If there are no groups of farmland, return an empty array.
 * You may return the answer in any order.
 */
public class AllGroupsOfFarmland {

  public static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

  public static int[][] findFarmland(int[][] land) {
    int rows = land.length;;
    int cols = land[0].length;

    List<int[]> list = new ArrayList<>();

    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        if (land[i][j] == 1) {
          bfs(land, i, j, list);
        }
      }
    }

    return list.toArray(new int[list.size()][]);

  }

  public static void bfs(int[][] land, int row, int col, List<int[]> list) {
    int endRow = -1;
    int endCol = -1;
    land[row][col] = 0;

    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
    queue.add(new Pair<>(row, col));

    while (!queue.isEmpty()) {
      Pair<Integer, Integer> tempPair = queue.remove();
      endRow = tempPair.getKey();
      endCol = tempPair.getValue();

      for (int[] dir : directions) {
        int newRow = endRow + dir[0];
        int newCol = endCol + dir[1];

        if (newRow >=0 && newCol >=0 && newRow < land.length && newCol < land[0].length && land[newRow][newCol] == 1) {
          land[newRow][newCol] = 0;
          queue.add(new Pair<>(newRow, newCol));
        }
      }

    }

    list.add(new int[] {row, col, endRow, endCol});

  }

  public static void main(String[] args) {
    int[][] land = {{1,0,0},{0,1,1},{0,1,1}};

    int[][] cord = findFarmland(land);

    for (int i=0; i< cord.length; i++) {
      for (int j=0; j<cord[0].length; j++) {
        System.out.print(" " + cord[i][j]);
      }
    }
  }
}
