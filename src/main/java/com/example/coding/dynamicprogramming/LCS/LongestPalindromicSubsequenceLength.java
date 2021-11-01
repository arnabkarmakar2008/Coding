package com.example.coding.dynamicprogramming.LCS;

public class LongestPalindromicSubsequenceLength {
    public static void main(String[] args) {
        /**
         * I/P input : "agbcba"
         * Palindromic Subsequence : ab; abcba O/P : 5
         *
         * input1 = agbcba
         * input2 = abcbga Find LCS between input1 and input2 and that would be the
         * length of LongestPalindromicSubsequenceLength
         */

        //String input = "agbcba";
        String input = "abcxyz";
        String input2 = new StringBuffer(input).reverse().toString();

        int lcs = longestCommonSubsequenceLength(input, input2, input.length(), input.length());
        System.out.println("Longest Palindromic Subsequence :: " + lcs);
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
