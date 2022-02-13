package com.example.coding.dynamicprogramming.leetcode.linear;


import java.util.Arrays;

/**
 * You have planned some train traveling one year in advance. The days of the year in
 * which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in three different ways:
 *
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 *
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7,
 * and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 */
public class MinCostForTickets {

  public static int recursive(int currentDay, int[] days, int[] costs, int[] memeoize) {

    if (currentDay > days[days.length-1]) {
      return 0;
    }

    if (memeoize[currentDay] != -1) {
      return memeoize[currentDay];
    }

    int minCost = Integer.MAX_VALUE;
    if (willTravelToday(currentDay, days)) {
      int dayPassCost = recursive(currentDay+1, days, costs,memeoize) + costs[0];
      int weekPassCost = recursive(currentDay+7, days, costs, memeoize) + costs[1];
      int monthPassCost = recursive(currentDay+30, days, costs, memeoize) + costs[2];

      minCost = Math.min(Math.min(dayPassCost,weekPassCost),monthPassCost);
    } else {
      minCost = recursive(currentDay+1, days, costs, memeoize);
    }

    return memeoize[currentDay] = minCost;
  }

  private static boolean willTravelToday(int currentDay, int[] days) {
    for (int i=0; i<days.length; i++) {
      if (days[i] == currentDay) {
        return true;
      }
    }

    return false;
  }


  public static int mincostTickets(int[] days, int[] costs) {
    int[] memoize = new int[400]; // As days[] can contain 365 and we have to call recursion for 365+30. So safe side take
    //array of size 400.

    Arrays.fill(memoize, -1);

    return recursive(days[0], days, costs, memoize);
  }

  public static void main(String[] args) {
    int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
    int[] costs = {2,7,15};

    System.out.println(mincostTickets(days, costs));
  }
}
