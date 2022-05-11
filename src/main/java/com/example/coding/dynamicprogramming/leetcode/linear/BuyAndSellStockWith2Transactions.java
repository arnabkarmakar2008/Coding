package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * Any number of buy and sell allowed but there is a cooling period between every buy-sell.
 */
public class BuyAndSellStockWith2Transactions {

  public static void main(String[] args) {
    int[] price = {10,15,17,20,16,18,22,20,22,20,23,25};
    System.out.println(maxProfit(price));
  }

  public static int maxProfit (int[] price) {
    int len = price.length;

    int maxProfitIfSoldToday = 0;
    int leastSoFar = price[0];

    int[] dp = new int[price.length];

    //Here we have to check max profit if we sell upto today.
    // Lets say we are on Day4 with price 20. On Day1 price was min and it was 5. So o Day4 profit is
    // 15. But on Day3 price was 25. So prfit on Day3 was 20. So on Day4 we will store 20 as this is the max
    //profit if we sell upto Day4.
    for (int i=1; i< price.length; i++) {
      if (price[i] < leastSoFar) {
        leastSoFar = price[i];
      }

      maxProfitIfSoldToday = price[i] - leastSoFar;

      if (maxProfitIfSoldToday > dp [i-1]) {
        dp[i] = maxProfitIfSoldToday;
      } else {
        dp[i] = dp[i-1];
      }
    }

    //Here we have to check max profit if we buy share today or later. As above we will store max profit
    // from today onwards. So lets say on Day4 if we buy share and make profit 20 but on Day8 or whatever
    // we make profit 25, we will store 25 on Day4.
    int maxProfitIfBoughtToday = 0;
    int maxSoFar = price[len-1];
    int[] dpIfBoughtToday = new int[len];

    for (int i = len-2; i>=0; i--) {

      if (price[i] > maxSoFar) {
        maxSoFar = price[i];
      }

      maxProfitIfBoughtToday = maxSoFar - price[i];

      if (maxProfitIfBoughtToday > dpIfBoughtToday[i+1]) {
        dp[i] = maxProfitIfBoughtToday;
      } else {
        dp[i] = dp[i+1];
      }
    }

    // So this dp[] and dpIfBoughtToday[] will store 2 max profits for each day. dp[i] will store
    // max profit if we sell share on day i or previous. dpIfBoughtToday[i] will store max profit
    // if we buy share on day i or later. So at any ith day, we will get profit for 2 transactions.
    // So max(dp[i] + dpIfBoughtToday[i]) will be the result.

    int maxProfit = Integer.MIN_VALUE;

    for (int k=0; k<len; k++) {
      maxProfit = Math.max(maxProfit, (dp[k] + dpIfBoughtToday[k]));
    }

    return maxProfit;
  }
}
