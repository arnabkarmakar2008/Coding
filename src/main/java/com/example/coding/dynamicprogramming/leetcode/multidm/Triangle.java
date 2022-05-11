package com.example.coding.dynamicprogramming.leetcode.multidm;

import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally,
 * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */
public class Triangle {

  /**
   * 2
   * 3 4
   * 6 5 1
   * 4 1 8 3
   * Top down : 2 -> Min(3,4) : 3 -> Min(6,5) : 5 -> Min(1,8) :1  = 11 But correct answer is 2->4->1->3 = 10
   * So top down will not work here. We have to go bottom up.
   *
   * Bottom up ::
   *
   * dp[] = 4 1 8 3
   *
   * Now for 2nd last row : For 6, we can choose dp Min(4,1) : 1, For 5, dp Min(1,8) :1 For 1, dp Min(8,3) : 3
   * dp[] = 7 6 4 3
   *
   * Now for 3rd last row : For 3, we can choose dp Min(7,6) : 6, For 4, dp Min(6,4) :4
   * dp[] = 9 8 4 3
   *
   * Now for 1st row : For 1, dp Min(9,8) : 8
   * dp[] = 10,8,4,3
   *
   * @param triangle
   * @return
   */
  public static int minimumTotal(int[][] triangle) {

    int maxColumn = triangle[triangle.length-1].length;

    int[] dp = new int[maxColumn];

    dp = triangle[triangle.length-1];

    for (int i = triangle.length-2; i >=0; i--) {
      for (int j=0; j < triangle[i].length; j++) {
        dp[j] = Math.min(dp[j], dp[j+1]) + triangle[i][j];

      }
    }

    return dp[0];
  }

  public static void main(String[] args) {
    int[][] triangle = {{2},{3,4},{6,5,1},{4,1,8,3}};
    System.out.println(minimumTotal(triangle));
  }
}
