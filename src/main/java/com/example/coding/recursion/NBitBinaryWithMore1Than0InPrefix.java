package com.example.coding.recursion;

public class NBitBinaryWithMore1Than0InPrefix {
    public static void main(String[] args) {
        /**
         * IP = 3
         * OP = "111", "110", "101", "011"
         */
        int size = 3;
        String output = "";
        int one = 0;
        int zero = 0;
        solve(output, one, zero, size);
    }

    public static void solve(String output, int one, int zero, int size) {

        if (one + zero == size) {
            System.out.println("\n" + output);
            return;
        }

        if (one <= zero) {
            output = output + "1";
            one = one + 1;

            solve(output, one, zero, size);
        } else {
            solve(output + "1", one + 1, zero, size);
            solve(output + "0", one, zero + 1, size);
        }
    }
}
