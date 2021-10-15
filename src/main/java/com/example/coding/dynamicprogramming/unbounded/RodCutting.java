package com.example.coding.dynamicprogramming.unbounded;

public class RodCutting {
    public static void main(String[] args) {
        /**
         * Rod Length = S = 8;
         * length[] : {1,2,4,6,8}
         * price[] : {5,20,30,50,20}
         * Need to find max profit.
         * This is unbounded knapsack problem. Same size can be taken more than once.
         */

        int sum = 4;
        int[] length = {1,2,3,4};
        int[] price = {2,6,8,80};

        int max = calculateProfit(length, price, sum, length.length);
        System.out.println("Max profile :: " + max);
    }

    private static int calculateProfit(int[] length, int[] price, int sum, int n) {
        int[][] t = new int[n+1][sum+1];

        for (int i=0; i < n+1; i++) {
            for (int j=0; j < sum+1; j++) {
                if (i==0) {
                    t[i][j] = 0;
                }
                if (j==0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i=1; i < n+1; i++) {
            for (int j=1; j < sum+1; j++) {
                if (length[i-1] <= j) {
                    t[i][j] = Math.max(price[i-1] + t[i][j - length[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        for (int i=0; i < n+1; i++) {
            for (int j=0; j < sum+1; j++) {
                System.out.print(t[i][j]);

                if (j == sum) {
                    System.out.print("\n");
                }
            }
        }

        return t[n][sum];
    }
}
