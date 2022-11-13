package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * There is a transaction fee to sell. Need to find max profit.
 */
public class BuyAndSellStockWithTransactionFee {

  /**
   * Note : https://www.youtube.com/watch?v=pTQB9wbIpfU&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=32
   * @param args
   */
  public static void main(String[] args) {
    int[] price = {1,3,2,8,4,9};
    int txFee = 2;

    System.out.println(maxProfit(price, 2));
    System.out.println(maxProfitEfficient(price, 2));
  }

  /**
   * https://www.youtube.com/watch?v=DzH4kVcyuOI
   * We have to maintain Buy and Sell state.
   *
   * In Buy state, I can either do not do anything or I can buy. First case, copy value from previous buy row.
   * 2nd case, Check the value of last row sell state. So it will be prev sell - current price - fee. Get the max from these twi values.
   *
   * In Sell state, I can either do not do anything or I can sell. First case, copy value from previous sell row.
   * 2nd case, value will be prev buy state + current price. Get the max.
   *
   * @param price
   * @param fee
   * @return
   */

  public static int maxProfitEfficient(int [] price, int fee) {
    int priceLength = price.length;
    int[][] dp = new int[priceLength][2];

    dp[0][0] = -(price[0] + fee);
    dp[0][1] = 0;

    for (int i=1; i<priceLength; i++) {
      //Derive buy state
      int buyValue = Math.max(dp[i-1][0], dp[i-1][1] - (price[i] + fee));
      int sellValue = Math.max(dp[i-1][1], dp[i-1][0] + price[i]);

      dp[i][0] = buyValue;
      dp[i][1] = sellValue;
    }

    return dp[priceLength-1][1];

  }


  public static int maxProfit (int[] price, int txFee) {
    int len = price.length;

    int obsp = -price[0]; //old bought state profit
    int ossp = 0; //old sold state profit

    for (int i=1; i<len; i++) {
      int nbsp = 0; //new bought
      int nssp = 0; //new sold

      //Derive bought state profit :: Derived from old sold state.

      if (ossp - price[i] > obsp) {
        nbsp = ossp - price[i];
      } else {
        nbsp = obsp;
      }

      // Derive sold state profit :: Derived from old bought state
      if (price[i] + obsp - txFee > ossp) {
        nssp = price[i] + obsp - txFee;
      } else {
        nssp = ossp;
      }

      obsp = nbsp;
      ossp = nssp;

    }
    return ossp;
  }
}
