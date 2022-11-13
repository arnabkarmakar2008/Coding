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
   * DP Problem. Put prices in X and transactions in Y.
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
   * Now, if 3 txns are done in Day5, then X = Y. (Not doing anything on last day)
   * Else if 2 txns are done on Day5, then p1 + (8(price on Day5) -3 (price on Day4))
   * Else if 2 txns are done on Day4, then p2 + (8(price on Day5) -6 (price on Day3)) ....
   * X will be max of above all combinations.
   *
   *
   * i -> number on txns
   * j -> price on jth day
   *
   * t[i][j] = max[ t[i][j-1],
   *  Selling on jth day. Lets say we bought it on mth day. m -> 0...j-1
   *  profit = price[j] - price[m] + dp[i-1][m] //doing ith transaction on jth day. So i-1th tnxs where done on mth day
   * ]
   *
   */

  public static int maxProfit (int[] price, int maxTrn) {
    int len = price.length;
    //Transactions in Row and Day in Column
    int[][] dp = new int[maxTrn+1][len];

    //Ist row and Ist column will be zero. On 0th Day, max profit will be 0. And if 0 txns are allowed then
    // aslo max profit will be 0.

    for (int t = 1; t <= maxTrn; t++) { // t :: transaction d :: day
      for (int d = 1; d < len; d++) {

        // Max profit on jth day by making i txns.
        dp[t][d] = dp[t][d-1];

        //If i-1 txns are made on j-1th days, then profit will be j-1th days profit + price diff
        int max = Integer.MIN_VALUE;
        for (int pd = 0; pd < d; pd ++) { //pd - previous day
          int profitTillTMinusOneTraninPd = dp[t-1][pd];
          int profitTillTTransaction = profitTillTMinusOneTraninPd + (price[d] - price[pd]);
          max = Math.max(max, profitTillTTransaction);
        }
        dp[t][d] = Math.max(dp[t][d], max);

      }
    }

    return dp[maxTrn][len-1];

  }
}
