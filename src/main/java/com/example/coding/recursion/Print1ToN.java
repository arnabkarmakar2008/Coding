package com.example.coding.recursion;

public class Print1ToN {

    public static void main(String[] args) {
        numberPrint(4);
    }

    public static void numberPrint(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        numberPrint(n-1);
        System.out.println(n);

    }
}
