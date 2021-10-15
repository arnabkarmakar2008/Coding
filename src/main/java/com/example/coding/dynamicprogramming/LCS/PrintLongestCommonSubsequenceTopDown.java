package com.example.coding.dynamicprogramming.LCS;

public class PrintLongestCommonSubsequenceTopDown {

    public static void main(String[] args) {
        /**
         * String input1 = "abdefgh"
         * String input2 = "abcdfkrt"
         * Common subsequence : "abdf"
         * o/p :  addf
         */
        String input1 = "abdefgh";
        String input2 = "krtab";
        String str = solve(input1, input2, input1.length(), input2.length());
        System.out.println("Max Subsequence :: " + str); // Need to reverse
    }

    public static String solve(String input1, String input2, int n, int m) {
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

        /**
         * For printing need to start from the end of the matrix.
         * If values are equal, then cell is derived from 1 + t[i-1][j-1]. And if not equal,
         * then max(t[i-1][j], t[i][j-1]). See notes for the logic.
         */

        int i = n;
        int j = m;
        String str = "";
        while (i> 0 && j> 0) {
            if (input1.charAt(i-1) == input2.charAt(j-1)) {
                str = str + input1.charAt(i-1);
                i--;
                j--;
            } else {
                if (t[i-1][j] > t[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        return str;
    }
}
