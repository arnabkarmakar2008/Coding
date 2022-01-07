package com.example.coding.matrix.leetcode.medium;

import java.util.Arrays;

/**
 * There is a city composed of n x n blocks, where each block contains a single building shaped like a
 * vertical square prism. You are given a 0-indexed n x n integer matrix grid where grid[r][c] represents
 * the height of the building located in the block at row r and column c.
 *
 * A city's skyline is the the outer contour formed by all the building when viewing the side of the
 * city from a distance. The skyline from each cardinal direction north, east, south, and west may be different.
 *
 * We are allowed to increase the height of any number of buildings by any amount (the amount can be
 * different per building). The height of a 0-height building can also be increased. However, increasing
 * the height of a building should not affect the city's skyline from any cardinal direction.
 *
 * Return the maximum total sum that the height of the buildings can be increased by without changing the city's skyline from any cardinal direction.
 */
public class MaxIncreasetoKeepCitySkyline {


  //Note : Get Max of each row and column
  public static int maxIncreaseKeepingSkyline(int[][] grid) {
    int[] rowMaxArray = new int[grid.length];
    int[] colMaxArray = new int[grid.length];

    int row = grid.length;
    int col = grid[0].length;

    int rowMax = 0;
    int colMax = 0;

    //n*n matrix
    for (int i=0; i< row; i++) {
      rowMax=0;
      colMax=0;
      for (int j=0; j<col; j++) {
        if (rowMax < grid[i][j]) {
          rowMax = grid[i][j];
        }

        if (colMax < grid[j][i]) {
          colMax = grid[j][i];
        }
      }

      rowMaxArray[i] = rowMax;
      colMaxArray[i] = colMax;
    }

    int increase = 0;

    for (int i=0; i<row; i++) {
      for (int j=0; j<row; j++) {
        int rMax = rowMaxArray[i];
        int cMax = colMaxArray[j];

        if (grid[i][j] != rMax || grid[i][j] != cMax) {
          if (rMax > cMax) {
            increase = increase + (cMax - grid[i][j]);
            grid[i][j] = cMax;
          } else {
            increase = increase + (rMax - grid[i][j]);
            grid[i][j] = rMax;
          }
        }

      }
    }

    return increase;
  }

  public static void main(String[] args) {
    int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
    System.out.println(maxIncreaseKeepingSkyline(grid));

  }




}
