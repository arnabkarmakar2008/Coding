package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
 * return 0.
 */
public class BuyAndSellStock1 {

  public static void main(String[] args) {
    int[] price = {3,5,1,7,4,9,3};

    System.out.println(efficientSellEveryDay(price));
  }

  public static int efficientSellEveryDay(int[] price) {
    int minSoFar = Integer.MAX_VALUE;
    int maxProfitSoFar = Integer.MIN_VALUE;

    for (int i=0; i< price.length; i++) {
      minSoFar = Math.min(minSoFar, price[i]);
      maxProfitSoFar = Math.max(maxProfitSoFar, price[i] - minSoFar);
    }

    return maxProfitSoFar;
  }

  public static int bruteForceSolution(int[] price) {
    int len = price.length;
    int maxProfit = -1;

    for (int i=0; i<len; i++) {
      for (int j=i+1; j<len; j++) {
        if ( (price[j] - price[i]) > 0) {
          maxProfit = Math.max(maxProfit, price[j] - price[i]);
        }
      }
    }

    return maxProfit;

  }
}
