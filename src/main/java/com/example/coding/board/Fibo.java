package com.example.coding.board;

public class Fibo {
    public static void main(String[] args) {
        int input = 4;

        /**
         * 0 1 1 2 3 5 8
         */
        System.out.println(fib(7));
    }

    public static int fib (int input) {
        if (input == 0 || input ==1) {
            return input;
        }

        return fib(input-1) + fib(input-2);
    }
}
