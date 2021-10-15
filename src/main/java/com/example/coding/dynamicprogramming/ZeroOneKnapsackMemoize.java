package com.example.coding.dynamicprogramming;

public class ZeroOneKnapsackMemoize {
    static int[][] t = new int[10][10];
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

        for (int i=0; i < 9; i++) {
            for(int j=0; j <9; j++) {
                t[i][j] = -1;
            }
        }

        int maxProfit = knapsack(weight, val, totalWeight, weight.length);
        System.out.println(maxProfit);
    }

    private static int knapsack(int[] weight, int[] val, int totalWeight, int length) {
        //Base condition. If size of the sack is 0, then profit is zero or if size of the
        //item array is zero then profit is also zero
        if (totalWeight == 0 || length == 0) {
            return 0;
        }

        if (t[length][totalWeight] != -1) {
            return t[length][totalWeight];
        }

        if (weight[length-1] <= totalWeight) {
            /*
            Item can be included or not. If included then adjust weight and length and call recursion again.
            If not, then call recursion for smaller input. Get max of two choices.
             */
            return t[length][totalWeight] = Math.max(val[length-1] + knapsack(weight, val, (totalWeight - weight[length-1]), length-1 ),
                    knapsack(weight, val, totalWeight, length-1 ));
        } else if (weight[length-1] > totalWeight) {
            return t[length][totalWeight]=knapsack(weight, val, totalWeight, length-1 );
        }

        return 0;
    }
}
