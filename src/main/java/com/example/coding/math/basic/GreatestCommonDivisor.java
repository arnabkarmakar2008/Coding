package com.example.coding.math.basic;

public class GreatestCommonDivisor {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(15,27));
    }
}
