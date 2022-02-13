package com.example.coding.dynamicprogramming.mcm;

import java.util.Arrays;

public class EggDroppig {
    public static int[][] t;
    public static void main(String[] args) {
        /**
         * Problem statement: You are given N floor and K eggs. You have to minimize the number
         * of times you have to drop the eggs to find the critical floor where critical floor means
         * the floor beyond which eggs start to break. Assumptions of the problem:
         *
         * If egg breaks at ith floor then it also breaks at all greater floors.
         * If egg does not break at ith floor then it does not break at all lower floors.
         * Unbroken egg can be used again.
         * Note: You have to find minimum trials required to find the critical floor not the critical floor.
         *
         * Example:
         * Input:
         *     4
         *     2
         *
         *     Output:
         *     Number of trials when number of eggs is 2 and number of floors is 4: 3
         */
        int egg = 2;
        int floor = 4;
        t = new int[egg+1][floor+1];

        for (int i=0; i<=egg; i++) {
            Arrays.fill(t[i], -1);
        }

        System.out.println("Minimum number of attempts :: " + solve(2,4));
    }

    public static int solve(int e, int f) {
        //Base condition
        if (e == 1) {
            return f; //worst case when we have 1 egg.
        }

        if (f == 0 || f == 1) {
            return 1;
        }

        if (t[e][f] != -1) {
            return t[e][f];
        }

        int min = Integer.MAX_VALUE;

        for (int k=1; k <= f; k++) {
            //From Kth floor either it can break or not. Also we have to take max for worst case
            int temp = 1 + Math.max(solve(e-1, k-1) , solve (e, f-k));

            if (temp < min) {
                min = temp;
            }
        }

        return t[e][f] = min;
    }
}
