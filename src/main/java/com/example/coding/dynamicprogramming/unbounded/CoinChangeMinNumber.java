package com.example.coding.dynamicprogramming.unbounded;

public class CoinChangeMinNumber {

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
        System.out.println(solve(coins, sum, n));
    }

    private static int solve(int[] coins, int sum, int n) {
        int[][] t = new int[n+1][sum+1];

        for (int i=0; i < n+1; i++) {
            for (int j=0; j < sum+1; j++) {
                if (i == 0) {
                    t[i][j] = Integer.MAX_VALUE -1;
                }

                if (j == 0 && i != 0) {
                    t[i][j] = 0;
                }
            }
        }


        //For some reason we have to initialize the first row as well
        for (int j=1;  j < sum+1; j++) {
            if (j % coins[0] == 0) {
                t[1][j] = j/coins[0];
            } else {
                t[1][j] = Integer.MAX_VALUE -1;
            }
        }

        for (int i=2; i < n+1; i ++) {
            for (int j=1; j < sum +1; j++) {
                if (coins[i-1] <= j) {
                    //As we are including the coin so add 1, for else 0
                    t[i][j] = Math.min(0 + t[i-1][j] , 1 + (t[i-1][j - coins[i-1]]));
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }


        for (int i=0; i < n+1; i++) {
            for (int j=0; j < sum+1; j++) {
                System.out.print(" " + t[i][j]);
                if (j == sum) {
                    System.out.print("\n");
                }
            }
        }

        return t[n][sum];

    }


}
