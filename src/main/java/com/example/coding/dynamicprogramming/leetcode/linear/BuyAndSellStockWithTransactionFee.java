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
    int[] price = {10,15,17,20,16,18,22,20,22,20,23,25};
    int txFee = 3;

    System.out.println(maxProfit(price, 3));
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
