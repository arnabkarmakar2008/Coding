package com.example.coding.math.leetcode.easy;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 */
public class PowerOfFour {

    public static boolean isPowerOfFour(int n) {
        if (n > 1) {
            while(n%4 == 0) {
                n = n/4;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(17));
    }
}
