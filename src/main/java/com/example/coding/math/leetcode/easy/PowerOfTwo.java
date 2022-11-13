package com.example.coding.math.leetcode.easy;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 */
public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        int i = 1;
        while (i < n) {
            i *= 2;
        }

        return i == n;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(17));
    }
}
