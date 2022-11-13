package com.example.coding.dynamicprogramming.LCS;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        /**
         * String input1 = "abcdefgh"
         * String input2 = "abcdfkrt"
         * Common subsequence : "ab"
         * o/p : 2
         */
        String input1 = "abcdefgh";
        String input2 = "abckrt";
        int maxSize = solve(input1, input2, input1.length(), input2.length());
        System.out.println("Max Substring :: " + maxSize);
    }

    public static int solve(String input1, String input2, int n, int m) {
        int[][] t = new int[n+1][m+1];

        for (int i=0; i< n+1; i++) {
            for (int j=0; j< m+1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }

                if (j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i=1; i< n+1; i++) {
            for (int j=1; j< m+1; j++) {
                if (input1.charAt(i-1) == input2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = 0;
                }
            }
        }

        //Substring can be anywhere is the matrix. So return max number from the matrix
        int max = 0;

        for (int i=0; i< n+1; i++) {
            for (int j=0; j< m+1; j++) {
                max = Math.max(t[i][j], max);
            }
        }

        return max;
    }
}
