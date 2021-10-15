package com.example.coding.recursion;

import java.util.Locale;

public class LetterCasePermutation {
    public static void main(String[] args) {
        /**
         * IP = "a1b2"
         * OP = "A1b2", "A1B2", "a1B2", "A1b2"
         */

        String input = "a1b2";
        String output = "";
        solve(input, output);

    }

    public static void solve(String input, String output) {

        if (input.length() == 0) {
            System.out.println("\n" + output);
            return;
        }

        if (Character.isAlphabetic(input.charAt(0))) {
            String output1 = output;
            String output2 = output;

            output1 = output1 + String.valueOf(input.charAt(0));
            output2 = output2 + String.valueOf(input.charAt(0)).toUpperCase(Locale.ROOT);

            input = input.substring(1);
            solve(input, output1);
            solve(input, output2);
        } else {
            output = output + input.charAt(0);
            input = input.substring(1);

            solve(input, output);
        }
    }
}
