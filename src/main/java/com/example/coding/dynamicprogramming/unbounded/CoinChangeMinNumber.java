package com.example.coding.dynamicprogramming.unbounded;

import java.util.Arrays;

public class CoinChangeMinNumber {

    /**
     * Follow this one : https://www.youtube.com/watch?v=1R0_7HqNaW0
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

        int[] coins = {3,5};
        int sum = 2;
        int n = coins.length;
        System.out.println(efficient(coins, sum));
    }

    public static int efficient(int[] coins, int sum) {
        int count = coins.length;
        int[] dp = new int[sum+1];

        //Have to fill array with invalid values first. Because if it is not possible to
        //make the sum value with coins then we will have invalid value in the cell.
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0; //dp of 0 will be the fewest number of coins to make 0 cents\
        //dp of 1 will be fewest number of coins to make 1 cent
        //dp of n will be fewest number of coin to make n cents

        for (int i=0; i<= sum; i++) {

            //Iterate through each coin
            for (int j=0; j<coins.length; j++) {
                //If current coin is less than i than or equal to i then can take it
                if (coins[j] <= i) {
                    //Now if we take this coin, then rest amount is i-coins[j]. So total coin will
                    //be 1 + dp[i-coins[j]]
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                }
            }
        }

        return dp[sum] != Integer.MAX_VALUE ? dp[sum] : -1;

    }





}
