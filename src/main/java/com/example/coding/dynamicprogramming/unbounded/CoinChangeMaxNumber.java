package com.example.coding.dynamicprogramming.unbounded;

public class CoinChangeMaxNumber {
    public static void main(String[] args) {
        /**
         * IP : coins[] : {1,2,3}
         * Sum : 5
         *
         * OP : count : 5 {1,1,1,1,1}
         *      {2,3}
         *      {1,1,1,2}
         *      {1,1,3}
         *      {1,2,2}
         *
         * Have to find max possible coin subsets to get to sum 5
         */

        int[] coins = {1,2,3};
        int sum = 5;
        int n = coins.length;

        System.out.println(solve(coins,sum,n));
    }

    private static int solve(int[] coins, int sum, int n) {

        int[][] t = new int[n+1][sum+1];

        for (int i=0; i< n+1; i++) {
            for (int j=0; j < sum+1; j++) {
                if (i==0) {
                    t[i][j] = 0;
                }

                if (j ==0) {
                    t[i][j] = 1;
                }
            }

        }

        for (int i=1; i< n+1; i++) {
            for (int j=1; j < sum+1; j++) {
                if (coins[i-1] <= j) {
                    t[i][j] = t[i-1][j] + t[i][j - coins[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }

        }

        return t[n][sum];
    }
}
