package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * Any number of buy and sell allowed but there is a cooling period between every buy-sell.
 */
public class BuyAndSellStockWithKTransactions {

  public static void main(String[] args) {
    int[] price = {10,15,17,20,16,18,22,20,22,20,23,25};
    System.out.println(maxProfit(price, 3));
  }

  /**
   * DP Problem. Put prices in X and Days in Y.
   *    9  6  7  6  3  8
   * 0
   *
   * 1
   *
   * 2           p2 p1
   *
   * 3              Y  X
   *
   * X in the cell will represent, max profit on Day6 if 3 transactions are allowed.
   *
   * Now, if 3 txns are done in Day5, then X = Y.
   * Else if 2 txns are done on Day5, then p1 + (8(price on Day5) -3 (price on Day4))
   * Else if 2 txns are done on Day4, then p2 + (8(price on Day5) -6 (price on Day3)) ....
   * X will be max of above all combinations.
   *
   */

  public static int maxProfit (int[] price, int maxTrn) {
    int len = price.length;
    //Transactions in Row and Day in Column
    int[][] dp = new int[maxTrn+1][len];

    //Ist row and Ist column will be zero. On 0th Day, max profit will be 0. And if 0 txns are allowed then
    // aslo max profit will be 0.

    for (int i = 1; i <= maxTrn; i++) {
      for (int j = 1; j < len; j++) {

        // Max profit on jth day by making i txns.
        dp[i][j] = dp[i][j-1];

        //If i-1 txns are made on j-1th days, then profit will be j-1th days profit + price diff
        int max = Integer.MIN_VALUE;
        for (int pd = 0; pd < i; pd ++) {
          max = Math.max(max, (dp[i-1][pd] + (price[j] - price[pd])));
        }
        dp[i][j] = Math.max(dp[i][j], max);

      }
    }

    return dp[maxTrn][len-1];

  }
}
