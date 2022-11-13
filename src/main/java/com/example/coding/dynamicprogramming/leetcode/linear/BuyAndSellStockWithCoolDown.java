package com.example.coding.dynamicprogramming.leetcode.linear;

import java.util.Map;

/**
 * Any number of buy and sell allowed but there is a cooling period between every buy-sell.
 */
public class BuyAndSellStockWithCoolDown {

  public static void main(String[] args) {
    int[] price = {10,15,17,20,16,18,22,20,22,20,23,25};
    System.out.println(dpMaxProfit(price, 1));
  }

  /**
   * https://www.youtube.com/watch?v=I7j0F7AHpb8
   * @param day
   * @param isBuying
   * @param price
   * @param map
   * @return
   */
  public static int usingRecursion(int day, boolean isBuying, int[] price, Map<String, Integer> map) {
    //base case
    if (day >= price.length) {
      return 0; //profit is zero if out of bound
    }

    if (map.containsKey(day+""+isBuying)) {
      return map.get(day+""+isBuying);
    }

    /**
     * if today is buying state, the  call recursion with selling state with day = day+1
     * If today is selling state then call recursion with buying state with day = day+2 because of cooldown
     *
     */

    if (isBuying) {
      //In buying state either we can but stock or cool down
      int buyingProfit = usingRecursion(day+1, !isBuying, price, map) - price[day];
      int coolDown = usingRecursion(day+1, isBuying, price, map);
      map.put(day+""+isBuying, Math.max(buyingProfit, coolDown));
    } else {
      //selling state.
      int sellingProfit = usingRecursion(day+2, !isBuying, price, map) + price[day];
      int coolDown = usingRecursion(day+1, isBuying, price, map);
      map.put(day+""+isBuying, Math.max(sellingProfit, coolDown));
    }

    return map.get(day+""+isBuying);
  }



  public static int dpMaxProfit(int[] price, int coolDown) {

    /**
     * There are three states::
     *
     * 1. No stock 2. In Hand 3. Sold (Stock will be sold on this day)
     *
     * State transition ::
     *
     * No stock -> No stock
     * Sold -> No stock (We cannot go sold to In hand directly because of cool down)
     *
     * In Hand -> In Hand
     * No stock -> In hand (We can buy stock to come from No stock to In Hand)
     *
     * In hand -> Sold
     *
     * We have to create dp table where column will be number of days with price and row will be 3 states.
     * Each cell will hold the max profit.
     *
     * Note : When we go from No stock -> In Hand state, profile will be :: previous day No stock profit - current day price
     * Also when we go from In Hand to Sold state, profit will be previous day In hand profit + current day price
     *
     */


    if (price.length <= 1) {
      return 0;
    }

    int[] buyState = new int[price.length];
    int[] soldState = new int[price.length];
    int[] noStockState = new int[price.length];

    buyState[0] = -price[0];
    soldState[0] = Integer.MIN_VALUE;
    noStockState[0] = 0;

    for (int i = 1; i < price.length; i++) {
      noStockState[i] = Math.max(noStockState[i-1], soldState[i-1]);
      buyState[i] = Math.max(buyState[i-1], noStockState[i-1] - price[i]);
      soldState[i] = buyState[i-1] + price[i];
    }

    return Math.max(noStockState[price.length-1], soldState[price.length-1]);

  }


}
