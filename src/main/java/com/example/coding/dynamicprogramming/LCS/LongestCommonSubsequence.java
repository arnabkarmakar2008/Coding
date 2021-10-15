package com.example.coding.dynamicprogramming.LCS;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        /**
         * String input1 = "abdefgh"
         * String input2 = "abcdfkrt"
         * Common subsequence : "abdf"
         * o/p : 4
         */
        String input1 = "abdefgh";
        String input2 = "krt";
        int maxSize = solve(input1, input2, input1.length(), input2.length());
        System.out.println("Max Subsequence :: " + maxSize);
    }

    public static int solve(String input1, String input2, int n, int m) {
        if (n == 0 || m ==0) {
            return 0;
        }

        if (input1.charAt(n-1) == input2.charAt(m-1)) {
            return 1 + solve(input1, input2, n-1, m-1);
        } else {
            return Math.max(solve(input1, input2, n-1, m), solve(input1, input2, n, m-1));
        }
    }
}
