package com.example.coding.dynamicprogramming.mcm;

public class EvaluateExpressionToTrue {
    public static void main(String[] args) {
        /**
         * IP : T|F&T
         *
         * There can be 3 operators (and, or, xor) in the string. Need to find out ways to make it
         * True.
         * Count the number of ways we can parenthesize the expression
         * so that the value of expression evaluates to true.
         */
    }

    public static int solve(String str, int i, int j, boolean flag) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (flag == true) {
                if (str.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (str.charAt(i) == 'F' ) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        int answer = 0;

        for (int k = i+1; k <= j-1; k=k+2) {
            int leftTrue = solve(str, i, k-1, true);
            int leftFalse = solve(str, i, k-1, false);

            int rightFalse = solve(str, k+1, j, false);
            int rightTrue = solve(str, k+1, j, true);

            if (str.charAt(k) == '&') {

                if (flag == true) {
                    answer = answer + leftTrue*rightTrue;
                } else {
                    answer = answer + leftTrue*rightFalse + leftFalse*rightTrue + leftFalse*rightFalse;
                }

            } else if (str.charAt(k) == '|') {
                if (flag == true) {
                    answer = answer + leftTrue*rightTrue + leftTrue*rightFalse + leftFalse*rightTrue;
                } else {
                    answer = answer + leftFalse*rightFalse;
                }
            } else if (str.charAt(k) == '^') {
                if (flag == true) {
                    answer = answer + leftTrue*rightFalse + leftFalse*rightTrue;
                } else {
                    answer = answer + leftFalse*rightFalse + leftTrue*rightTrue;
                }
            }
        }
        return answer;
    }
}
