package com.example.coding.matrix.leetcode.medium;


/**
 * There is an m x n grid, where (0, 0) is the top-left cell and (m - 1, n - 1)
 * is the bottom-right cell. You are given an integer array startPos where
 * startPos = [startrow, startcol] indicates that initially, a robot is at the cell
 * (startrow, startcol). You are also given an integer array homePos where
 * homePos = [homerow, homecol] indicates that its home is at the cell (homerow, homecol).
 *
 * The robot needs to go to its home. It can move one cell in four directions: left,
 * right, up, or down, and it can not move outside the boundary. Every move incurs some cost.
 * You are further given two 0-indexed integer arrays: rowCosts of length m and colCosts of length n.
 *
 * If the robot moves up or down into a cell whose row is r, then this move costs rowCosts[r].
 * If the robot moves left or right into a cell whose column is c, then this move costs colCosts[c].
 * Return the minimum total cost for this robot to return home.
 */
public class MinRobotHomeComingCost {


  /**
   * It's a brain-teaser,
   * all shortest paths have the same cost.
   *
   *
   *
   * From the view of row index, the best path will be go directly from start x to home x
   * From the view of col index, the best path will be go directly from start y to home y
   *
   * Firstly move rows, from startPos[0] to homePos[0].
   * Secondly move cols, from startPos[1] to homePos[1].
   * Sum up the cost for every step.
   *
   *
   * @param startPos
   * @param homePos
   * @param rowCosts
   * @param colCosts
   * @return
   */
  public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
    int cost = 0;

    int counter = -1;
    if (homePos[0] > startPos[0]) {
      counter = startPos[0] + 1;

      while (counter <= homePos[0]) {
        cost = cost + rowCosts[counter];
        counter++;
      }
    } else {
      counter = startPos[0] - 1;
      while (counter >= homePos[0]) {
        cost = cost + rowCosts[counter];
        counter--;
      }
    }

    counter = -1;
    if (homePos[1] > startPos[1]) {
      counter = startPos[1] + 1;

      while (counter <= homePos[1]) {

        cost = cost + colCosts[counter];
        counter++;
      }
    } else {
      counter = startPos[1] -1;
      while (counter >= homePos[1]) {
        cost = cost + colCosts[counter];
        counter--;
      }
    }

    return cost;

  }

  public static void main(String[] args) {
    int[] startPos = {1,0};
    int[] homePos = {2,3};
    int[] rowCost = {5,4,3};
    int[] colCost = {8,2,6,7};

    System.out.println(minCost(startPos, homePos, rowCost, colCost));
  }
}
