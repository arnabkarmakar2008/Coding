package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * Any number of buy and sell allowed but there is a cooling period between every buy-sell.
 */
public class BuyAndSellStockWithCoolDown {

  public static void main(String[] args) {
    int[] price = {10,15,17,20,16,18,22,20,22,20,23,25};
    System.out.println(maxProfit(price, 1));
  }

  public static int maxProfit (int[] price, int coolDown) {
    int len = price.length;

    int obsp = -price[0]; //old buy state
    int ossp = 0; //old sold state
    int ocsp = 0; //old cool down state

    for (int i=1; i<price.length; i++) {
      int nbsp = 0;
      int nssp = 0; //new sold state
      int ncsp = 0; //new cool down state

      // Derive bought state profit
      if (ocsp - price[i] > obsp) {
        nbsp = ocsp - price[i];
      } else {
        nbsp = obsp;
      }

      // Derive sold state profit
      if (price[i] + obsp > ossp) {
        nssp = price[i] + obsp;
      } else {
        nssp = ossp;
      }

      // Derive cool state profit
      if (ossp > ocsp) {
        ncsp = ossp;
      } else {
        ncsp = ocsp;
      }

      ossp = nssp;
      obsp = nbsp;
      ocsp = ncsp;

    }

    return ossp;
  }
}
