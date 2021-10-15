package com.example.coding.dynamicprogramming;

public class CountSubSetWithGivenDiff {
    public static void main(String[] args) {
        /**
         * IP : arr[] = {2,4,6,7,10}
         * diff = 5;
         *
         * OP : 1
         *
         * S1 + S2 = sum(arr)
         * s1 - s2 = diff
         * ------------------
         * s1 = sum(arr) + diff / 2
         *
         * s1 = 29 + 5 /2 = 17
         */

        int arr[] = {2,4,6,7,10};
        int diff = 5;

        int sum = 0;

        for (int i: arr) {
            sum = sum + i;
        }

        int s1 = (sum + diff) / 2;

        System.out.println(countNumberOfSubSet(arr, s1, 5));
    }

    public static int countNumberOfSubSet(int[] arr, int sum, int n) {
        int[][] t = new int[n+1][sum+1];

        for (int i=0; i < n+1; i++) {
            for (int j=0; j < sum+1; j++) {
                if (i==0) {
                    t[i][j] = 0;
                }

                if (j==0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i=1; i < n+1; i++) {
            for (int j=1; j < sum+1; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = t[i-1][j] + t[i-1][j - arr[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}
