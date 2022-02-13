package com.example.coding.matrix.leetcode.medium;
///////Not Complete///////
/**
 * Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and
 * swap them.
 *
 * A grid is said to be valid if all the cells above the main diagonal are zeros.
 *
 * Return the minimum number of steps needed to make the grid valid, or -1 if the grid
 * cannot be valid.
 *
 * The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).
 */
public class MinSwapsToArrangeBinaryGrid {

  /**
   * Note : In an array take the index of the rightmost array. Sort the array. Then if rightmost[i] <=i,
   * then only answer exists.
   * {{0,0,1},{1,1,0},{1,0,0}};
   * array[] = {2,1,0}. After sort {0,1,2}. So it is possible to get answer
   *
   * @param grid
   * @return
   */
  public static int minSwaps(int[][] grid) {
    int count = 0;
    int[] rightMost1Index = new int[grid.length];

    for (int i=0; i< grid.length; i++) {
      int index = -1;
      for (int j=0; j< grid[0].length; j++) {
        if (grid[i][j] == 1) {
          index = j;
        }
      }

      if (index > i) {
        break;
      }

      rightMost1Index[i] = index;
    }




    return count;
  }

  public static void main(String[] args) {
    int[][] grid = {{0,0,1},{1,1,0},{1,0,0}};
  }
}
