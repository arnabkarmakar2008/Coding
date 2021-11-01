package com.example.coding.dynamicprogramming.LCS;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        /**
         * IP : a = AGGTAB
         *      b = GXTAAYB
         *
         * Super Sequence = AGGTAB + GXTAAYB = AGGTABGXTAAYB
         * But it is not shortest. Exclude common elements from it. In short, minus common
         * subsequence element. So shortest supersequence length =  a+b - LCS length
         */
        String input1 = "AGGTAB";
        String input2 = "GXTAAYB";
        System.out.println("Shortest Common Supersequence = " + ((input1.length() + input2.length())
                - longestCommonSubsequenceLength(input1, input2, input1.length(), input2.length())));
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
