package com.example.coding.dynamicprogramming;

public class EqualSumPartition {
    public static void main(String[] args) {
        /**
         * IP : arr[] = {1,5,11,5}
         *
         * Output : True
         *
         * {1,5,5} = {11}
         */
        int arr[] = {3,5,11,5};

        /**
         * If sum of the array is odd then it is not possible for equal partition
         */
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }

        if (sum%2 != 0) {
            System.out.println("Odd Sum. Not possible");
        } else {
            // Now we have to find a subset with sum/2. So if we find subset with sum=11, then
            // other subset will also be 11.
            boolean flag = solve(arr, sum/2, 4);
            System.out.println(flag);

        }

    }

    private static boolean solve(int[] val, int s, int size) {
        boolean[][] t = new boolean[size+1][s+1];

        for(int i=0; i<size+1; i++) {
            for(int j=0; j<s+1; j++) {
                if (i==0) {
                    t[i][j] = false;
                }

                if (j==0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i=1; i<size+1; i++) {
            for (int j=1; j<s+1; j++) {

                if (val[i-1] <= j) {
                    t[i][j] = Boolean.logicalOr (t[i-1][j - val[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }

            }
        }

        return t[size][s];
    }
}
