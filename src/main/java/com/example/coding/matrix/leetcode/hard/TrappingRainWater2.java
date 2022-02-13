package com.example.coding.matrix.leetcode.hard;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an m x n integer matrix heightMap representing the height of each unit cell
 * in a 2D elevation map, return the volume of water it can trap after raining.
 *
 * Solution : https://www.youtube.com/watch?v=fywyCy6Fyoo
 */
public class TrappingRainWater2 {

  public static int trapRainWater(int[][] heightMap) {
    int rows = heightMap.length;
    int cols = heightMap[0].length;
    int water = 0;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited = new boolean[rows][cols];

    PriorityQueue<Cell> pq = new PriorityQueue<>();

    //Add all border cells in pq
    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {

        if (i == 0 || j==0 || i == rows-1 || j == cols-1) {
          pq.add(new Cell(i, j, heightMap[i][j]));
          visited[i][j] = true;
        }
      }
    }

    //Traverse the pq. It will pick the lowest height border cell first.
    while (!pq.isEmpty()) {
      Cell tempCell = pq.remove();

      for (int k=0; k< directions.length; k++) {
        int newR = tempCell.row + directions[k][0];
        int newC = tempCell.col + directions[k][1];

        //Check the limits
        if (newR < 0 || newC < 0 || newR >= rows || newC >= cols || visited[newR][newC]) {
          continue;
        }

        /**
         * If height of the neighbour cell is lower then it can hold water. So we are doing water+=.
         * Now after computing this, pass the responsibility to the neighbour i.e. update the height of the neighbour if it is
         * lesser.
         */
        visited[newR][newC] = true;
        if (heightMap[newR][newC] < heightMap[tempCell.row][tempCell.col]) {
          water += heightMap[tempCell.row][tempCell.col] - heightMap[newR][newC];
          pq.add(new Cell(newR, newC, heightMap[tempCell.row][tempCell.col]));
        } else {
          //If neighbour height is higher or equal than it will not hold water. So just put i pq.
          pq.add(new Cell(newR, newC, heightMap[newR][newC]));
        }

      }
    }

    return water;

  }

  public static void main(String[] args) {
    int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
    System.out.println(trapRainWater(heightMap));
  }

}

class Cell implements Comparable<Cell> {
  int row, col, height;

  public Cell(int row, int col, int height) {
    this.row = row;
    this.col = col;
    this.height = height;
  }

  @Override
  public int compareTo(Cell o) {
    return this.height - o.height;
  }
}
