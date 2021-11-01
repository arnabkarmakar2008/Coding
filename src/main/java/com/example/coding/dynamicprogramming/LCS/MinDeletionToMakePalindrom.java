package com.example.coding.dynamicprogramming.LCS;

public class MinDeletionToMakePalindrom {
    public static void main(String[] args) {
        /**
         * IP : input = "agbcba" o/p : 1 :: Need to delete g only.
         *
         * input1 = "agbcba"
         * input2 = "abcbga"
         * LCs = "abcba" Then deletion required = Length - LCS length
         */

        String input1 = "agbcba";
        String input2 = new StringBuffer(input1).reverse().toString();

        int lcsLength = longestCommonSubsequenceLength(input1, input2, input1.length(), input1.length());

        System.out.println("Deletion required :: " + (input1.length() - lcsLength));
    }

    public static int longestCommonSubsequenceLength(String input1, String input2, int n, int m) {
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
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return t[n][m];
    }
}
