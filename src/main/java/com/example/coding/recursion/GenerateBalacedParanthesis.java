package com.example.coding.recursion;

public class GenerateBalacedParanthesis {
    public static void main(String[] args) {
        /**
         * IP = 3
         * OP = "((()))", "(()())", "(())()", "()(())", "()()()"
         */

        int input = 3;
        int open = 3;
        int close = 3;
        String output = "";
        solve(output, open, close);
    }

    public static void solve (String output, int open, int close) {

        if (open == 0 && close == 0) {
            System.out.println("\n" + output);
            return;
        }

        if (open == close) {
            output = output + "(";
            open = open - 1;
            solve(output, open, close);
        } else if (open == 0) {
            output = output + ")";
            close = close - 1;
            solve(output, open, close);
        } else {
            String output1 = output;
            String output2 = output;

            output1 = output1 + "(";
            output2 = output2 + ")";

            solve(output1, open-1, close);
            solve(output2, open, close-1);
        }
    }
}
