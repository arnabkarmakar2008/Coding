package com.example.coding.math.leetcode.medium;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */
public class PowerN {

    public static double myPow(double x, int n) {
        double result = helperFunc(x, Math.abs(n));

        //2^-10 = 1/2^10;

        return n >= 0 ? result : 1/result;
    }

    private static double helperFunc(double x, int n) {
        if (x == 0) {
            //0^5 = 0
            return 0;
        }

        if (n == 0) {
            //x^0 = 1
            return 1;
        }

        /*
        2 ^ 10 = 2 ^ 5 * 2 ^ 5. So if we calculate 2^5, we just need to multiply.
        Now for 2^11 = 2^5 * 2^5 * 2
         */

        double res = helperFunc(x, n/2);
        res = res * res;
        return n % 2 == 0 ? res : x * res;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }
}
