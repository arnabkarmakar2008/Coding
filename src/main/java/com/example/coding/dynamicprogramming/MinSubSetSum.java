package com.example.coding.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class MinSubSetSum {

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

        boolean[][] t = subset(arr, sum, 3);

        //Now 3rd row of t will say if subset with range is possible or not. Also as s1 is smaller
        //we have to take sum/2+1;
        int tempIndex = sum/2;
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<=tempIndex; i++) {
            if (t[3][i] == true)
            list.add(i);
        }
        // Now have to find min of sum - 2*element of list
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            min = Math.min(min, sum - 2*i);
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
