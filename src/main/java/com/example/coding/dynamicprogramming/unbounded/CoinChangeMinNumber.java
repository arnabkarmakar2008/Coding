package com.example.coding.dynamicprogramming.unbounded;

public class CoinChangeMinNumber {

    /**
     * Follow this one : https://www.youtube.com/watch?v=ZI17bgz07EE
     * @param args
     */
    public static void main(String[] args) {
        /**
         * IP : coins[] : {1,2,3}
         * Sum : 5
         *
         * OP : count : 2 {2,3}
         *
         * Have to find min possible coin count to get to sum 5
         */

        int[] coins = {1,2,3};
        int sum = 5;
        int n = coins.length;
        System.out.println(efficient(coins, sum));
    }

    private static int solve(int[] coins, int sum, int n) {
        int[][] t = new int[n+1][sum+1];

        for (int i=0; i< n+1; i++) {
            for (int j=0; j < sum+1; j++) {
                if (i == 0) {
                    t[i][j] = Integer.MAX_VALUE; // We have 0 element in the coin array and we can form numbers in infinite way
                } else if (j == 0) {
                    t[i][j] = 0;
                } else if (coins[i-1] <= sum) {
                    t[i][j] = Math.min(t[i-1][j], (1 + t[i][j - coins[i-1]]));
                } else {
                    t[i][j] = t[i-1][j];
                }

            }
        }

        return t[n][sum];

    }

    public static int efficient(int[] coins, int sum) {
        int count = coins.length;
        int[] dp = new int[sum+1];

        dp[0] = 1;

        for (int i=0; i < count; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[sum];

    }





}
