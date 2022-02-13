package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * Same as BuyAndSellStock1 but we can buy and sell multiple times.
 * But we have to sell before next buy.
 */
public class BuyAndSellStock2 {

  public static void main(String[] args) {
    int[] price = {3,5,1,7,4,9,3};

    System.out.println(efficientSellEveryDay(price));
  }

  public static int efficientSellEveryDay(int[] price) {
    int profit = 0;
    for (int i=1; i< price.length; i++) {
      //Note: As we can buy and sell multiple times, so whenever we are seeing price higher than previous day
      // selling it to book profit
      if (price[i] > price[i-1]) {
        profit += price[i]-price[i-1];
      }
    }

    return profit;
  }

}
