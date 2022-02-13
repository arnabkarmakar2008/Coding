package com.example.coding.matrix.leetcode.hard;


/**
 * You are given a rows x cols matrix grid representing a field of
 * cherries where grid[i][j] represents the number of cherries that you can collect
 * from the (i, j) cell.
 *
 * You have two robots that can collect cherries for you:
 *
 * Robot #1 is located at the top-left corner (0, 0), and
 * Robot #2 is located at the top-right corner (0, cols - 1).
 * Return the maximum number of cherries collection using both robots by following the rules below:
 *
 * From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
 * When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
 * When both robots stay in the same cell, only one takes the cherries.
 * Both robots cannot move outside of the grid at any moment.
 * Both robots should reach the bottom row in grid.
 */
public class CherryPick2 {


  /**
   * Note : Explanation : https://leetcode.com/problems/cherry-pickup-ii/discuss/1674112/Well-Detailed-Explaination-JAVA-C%2B%2B-oror-Easy-for-mind-to-Accept-it
   * @param grid
   * @return
   */
  public static int cherryPickup(int[][] grid) {
    int dir[] = {-1,0,1}; // As robot can move to 1,-1; 1,0;1,1

    int rows = grid.length;;
    int cols = grid[0].length;

    /**
     * Here we are taking dp dimensions 3. As both robots can simultaneously move to same row.
     * Only on different columns. Now robot1 can move to 3 columns. Similarly robot2 can move to 3.
     * So there are 3*3 possible moves.
     */

    int[][][] dp = new int[rows][cols][cols];

    //Initialize with -1
    for (int i=0; i<rows; i++) {
      for (int j=0; j< cols; j++) {
        for (int k=0; k< cols; k++) {
          dp[i][j][k] = -1;
        }
      }
    }

    int col1 = 0; // Position of the first robot
    int col2 = cols-1; //position of the second robot

    dp[0][col1][col2] = grid[0][0] + grid[0][cols-1]; // Addition of two positions of grid.
    int max = dp[0][col1][col2];

    //Now start from row 1.
    for (int i=1; i<rows; i++) {
      for (int c1=0; c1 < cols; c1++) {
        for (int c2=0; c2<cols; c2++) {
          int prev = dp[i-1][c1][c2];

          if (prev >= 0) { // If it is -1, then we haven't reached that cell. That is why we have initialized dp array as -1

            //Now fill for all 3*3 =9 positions
            for (int d1 : dir) {
              col1 = c1 + d1;

              for (int d2 : dir) {
                col2 = c2 + d2;

                if (col1 >=0 && col1 < cols && col2 >=0 && col2 <cols) {
                  //When robots are on the same column then count value one time. means give it to one robot.
                  int dpValue = col1 == col2 ? grid[i][col1] : grid[i][col1] + grid[i][col2];
                  dp[i][col1][col2] = Math.max(dp[i][col1][col2], prev+dpValue);
                  max = Math.max(max, dp[i][col1][col2]);
                }
              }
            }
          }
        }
      }
    }

    return max;
  }

  public static void main(String[] args) {
    int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
    System.out.println(cherryPickup(grid));
  }
}
