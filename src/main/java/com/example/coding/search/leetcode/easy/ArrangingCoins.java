package com.example.coding.search.leetcode.easy;

/**
 * You have n coins and you want to build a staircase with these coins.
 * The staircase consists of k rows where the ith row has exactly i coins.
 * The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you will build.
 *
 */
public class ArrangingCoins {

    public static int arrangeCoins(int n) {
        int i = 1;
        while (n > 0) {
            n = n-i;
            i++;
        }

        return i-1;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(arrangeCoins(n));
    }
}
