package com.example.coding.dynamicprogramming.LCS;

public class MinimumNumberOfInsertAndDelete {
    public static void main(String[] args) {
        /**
         * a : heap
         * b : pea
         *
         * a -> b ea is LCS here. Delete h and p. Insert p.
         *
         * So # of delete = a.length - LCS
         * # of insert = b.length - LCS
         */

        String input1 = "heap";
        String input2 = "pea";

        int lcs = longestCommonSubsequenceLength(input1,input2, input1.length(), input2.length());

        System.out.println("Minimum Delete :: " + (input1.length() - lcs));
        System.out.println("Minimum Insert :: " + (input2.length() - lcs));
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
