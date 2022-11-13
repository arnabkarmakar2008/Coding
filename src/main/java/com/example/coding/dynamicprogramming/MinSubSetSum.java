package com.example.coding.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class MinSubSetSum {

    /**
     * https://www.youtube.com/watch?v=SFWOSpTJOzw
     * @param args
     */
    public static void main(String[] args) {
        /**
         * IP : arr[] : {2,4,7}
         * OP : 1 (7-6)
         * Have to divide array between 2 partition : p1 and p2. Lets say sum of p1 is s1
         * and p2 is s2. So s1+s2 = sum(2,4,7). We have to get min(s2-s1).
         * If s1 is smaller, then s2 = sum-s1. So we have to get min(sum-2s1).
         *
         *
         */

        int arr[] = {2,3,7};
        int sum = 0;

        for (int i : arr) {
            sum = sum + i;
        }

        int n = 3;

        boolean[][] t = subset(arr, sum, n);

        int min = Integer.MAX_VALUE;

        //Now lets say sum =17. Now if lets say we can have subset sum =8, then other subset will be 17-8=9
        // Abs difference = 9-8 = 1. Now if we get subset sum =9, then other sum will be8.
        //So basically we will repeat if we go beyond sum/2;

        for (int i=0; i<=sum/2; i++) {
            if (t[n][i] == true) {
                //subset possible
                //subset1 sum is i
                //subset2 sum = sum-i
                //diff between both will be (sum-i)-i = sum - 2i
                min = Math.min(min, sum-2*i);
            }
        }

        System.out.println("Minimum :: " + min);
    }

    public static boolean[][] subset(int[] arr, int range, int n) {
        boolean t[][] = new boolean[n+1][range+1];

        for (int i=0; i< n+1; i++) {
            for(int j=0; j< range+1; j++) {
                if (i==0) {
                    t[i][j] = false;
                }

                if (j==0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i=1; i< n+1; i++) {
            for (int j = 1; j < range + 1; j++) {

                if (arr[i-1] <= j) {
                    t[i][j] = Boolean.logicalOr(t[i-1][j - arr[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t;
    }

}
