package com.example.coding.dynamicprogramming.LCS;

import java.util.Arrays;

public class LongestCommonSubsequenceMemo {

    public static int[][] t;

    public static void main(String[] args) {
        /**
         * String input1 = "abdefgh"
         * String input2 = "abcdfkrt"
         * Common subsequence : "abdf"
         * o/p : 4
         */
        String input1 = "abdefgh";
        String input2 = "krta";
        t = new int[input1.length()+1][input2.length()+1];

        for (int i=0; i< t.length; i++) {
            Arrays.fill(t[i], -1);
        }

        int maxSize = solve(input1, input2, input1.length(), input2.length());
        System.out.println("Max Subsequence :: " + maxSize);
    }

    public static int solve(String input1, String input2, int n, int m) {
        if (n == 0 || m ==0) {
            return 0;
        }

        if (t[n][m] != -1) {
            return t[n][m];
        }

        if (input1.charAt(n-1) == input2.charAt(m-1)) {
            return t[n][m] =  1 + solve(input1, input2, n-1, m-1);
        } else {
            return t[n][m] = Math.max(solve(input1, input2, n-1, m), solve(input1, input2, n, m-1));
        }
    }
}
