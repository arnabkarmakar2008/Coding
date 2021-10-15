package com.example.coding.dynamicprogramming;

public class ZeroKnapsackTopDown {
    public static void main(String[] args) {
        /**
         * IP = wt[]  : 1, 3, 4, 5
         *      val[] : 1, 4, 5, 7
         *      Knapsack Capacity W : 7
         * OP = Max Profit
         */
        int weight[] = {1, 5, 4, 3};
        int val[] = {1, 7, 5, 4};
        int totalWeight = 7;

        int maxProfit = knapsack(weight, val, totalWeight, weight.length);

        System.out.println(maxProfit);
    }

    private static int knapsack(int[] weight, int[] val, int totalWeight, int length) {
        int[][] t = new int[length+1][totalWeight+1];

        for (int i=0; i< length+1; i++) {
            for (int j=0; j< totalWeight+1; j++) {
                if (i==0 || j==0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i=1; i<length+1; i++) {
            for (int j=1; j<totalWeight+1; j++) {
                if (weight[i-1] <= j) {
                    t[i][j] = Math.max(val[i-1] + t[i-1][j - weight[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }


        return t[length][totalWeight];
    }

}
