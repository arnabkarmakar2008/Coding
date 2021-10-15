package com.example.coding.recursion;

public class PermutationWithSpaces {
    public static void main(String[] args) {

        /**
         * IP = "abc"
         * OP = "a-bc", "a-b-c", "ab-c", "abc"
         * No - allowed before or after. So need to change IP/OP in the
         * main method itself.
         *
         */
        String input = "abc";
        String output = "";


        output = String.valueOf(input.charAt(0));
        input = input.substring(1);
        solve(input, output);
    }

    public static void solve (String input, String output) {
        //Base condition. Print OP when IP is blank

        if (input.length() == 0) {
            System.out.println("\n" + output);
            return;
        }

        String output1 = output;
        String output2 = output;

        output1 = output1 +  "-" + input.charAt(0);
        output2 = output2 + input.charAt(0);

        input = input.substring(1);

        solve(input, output1);
        solve(input, output2);



    }

}
