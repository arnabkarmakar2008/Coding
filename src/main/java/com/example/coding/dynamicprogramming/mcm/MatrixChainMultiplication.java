package com.example.coding.dynamicprogramming.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int[][] t;
    public static void main(String[] args) {
        /**
         * IP arr[] : {40,20,30,10,30}
         * Find min cost to multiply matrix.
         *
         */
        int[] arr = {40,20,30,10,30};
        t = new int[arr.length+1][arr.length+1];

        for(int i=0; i< t.length; i++) {
            Arrays.fill(t[i], -1);
        }

        System.out.println("Min Cost to Multiply :: "+ solve(arr, 1, (arr.length-1)));
    }

    public static int solve (int arr[], int i, int j) {
        //Base cond
        if (i >= j) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k=i; k<j; k++) {
            int temp = solve(arr, i, k) + solve(arr, k+1, j) + (arr[i-1] + arr[k] + arr[j]);
            min = Math.min(min, temp);
        }

        return t[i][j] = min;
    }

}
