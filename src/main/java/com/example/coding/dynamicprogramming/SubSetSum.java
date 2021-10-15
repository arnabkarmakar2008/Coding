package com.example.coding.dynamicprogramming;

public class SubSetSum {
    public static void main(String[] args) {
        /**
         * IP : val[] = {2,3,7,8,10}
         * w = 11
         * Output : True
         */

        int[] val = {2,3,7,8,10};
        int s = 12;

        System.out.println(solve(val, s, 5));
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
