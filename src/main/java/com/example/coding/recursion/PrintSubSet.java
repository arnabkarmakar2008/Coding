package com.example.coding.recursion;

public class PrintSubSet {
    public static void main(String[] args) {
        String input = "ab";
        String output = "";
        solve(input, output);
    }

    public static void solve(String input, String output) {

        //Base condition - We will get answer when input size==0
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        String output1 = output;
        String output2 = output;
        output2 = output2 + String.valueOf(input.charAt(0));

        input = input.substring(1);

        solve(input, output1);
        solve(input, output2);

    }
}
