package com.example.coding.recursion;

import java.util.Locale;

public class PermutationWithCaseChange {
    public static void main(String[] args) {
        /**
         * IP = "ab"
         * OP = "aB", "Ab" "AB", "ab"
         */
        String input = "ab";
        String output = "";

        solve(input, output);
    }

    public static void solve (String input, String output) {
        if (input.length() == 0) {
            System.out.println("\n" + output);
            return;
        }

        String output1 = output + String.valueOf(input.charAt(0));
        String output2 = output + String.valueOf(input.charAt(0)).toUpperCase(Locale.ROOT);
        input = input.substring(1);

        solve(input, output1);
        solve(input, output2);

    }
}
