package com.example.coding.matrix.leetcode.medium;

/**
 * Given a 2D grid of 0s and 1s, return the number of elements in the largest square
 * subgrid that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.
 */
public class Largest1BorderedSquare {


  public static int largest1BorderedSquare(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int maxSize = Integer.MIN_VALUE;

    int[][] h = new int[rows][cols]; // storing horizontal consecutive 1 count
    int[][] v = new int[rows][cols]; // storing vertical consecutive 1 count

    for (int i=0; i< rows; i++) {
      for (int j=0; j< cols; j++) {
        if (grid[i][j] == 0) {
          h[i][j] = v[i][j] = 0;
        } else {
          h[i][j] = j == 0 ? 1 : 1 + h[i][j-1];
          v[i][j] = i == 0 ? 1 : 1 + v[i-1][j];
        }
      }
    }

    //Start from the rightmost cell
    for (int i = rows-1; i>=0; i--) {
      for (int j = cols-1; j>=0; j--) {
        int small = Math.min(h[i][j], v[i][j]); // We have to form square. So take min.

        // Note : Now we know min size right vertical and down horizontal sides of the square exist.
        // We have to verify if left vertical and up horizontal sides of square of small size exist or not.
        while (small > maxSize) {
          if (h[i - small + 1][j] >= small && v[i][j - small + 1] >= small) {

            //Note : h[i - small + 1][j] will check if up horizontal of size small exists or ot
            // v[i][j - small + 1 will check if left vertical of size small exists or not

            maxSize = small;
          }
         small--;
       }

      }
    }
    return maxSize;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
    System.out.println(largest1BorderedSquare(grid));
  }

}
