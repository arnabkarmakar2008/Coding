package com.example.coding.math.leetcode.easy;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 */
public class UglyNumberII {

    /**
     * https://leetcode.com/problems/ugly-number-ii/discuss/69364/My-16ms-C%2B%2B-DP-solution-with-short-explanation
     *
     * We have an array k of first n ugly number. We only know, at the beginning, the first one, which is 1. Then
     *
     * k[1] = min( k[0]x2, k[0]x3, k[0]x5). The answer is k[0]x2. So we move 2's pointer to 1. Then we test:
     *
     * k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on. Be careful about the cases such as 6,
     * in which we need to forward both pointers of 2 and 3.
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }

        int[] uglyArray = new int[n];

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        uglyArray[0] = 1;

        for (int i=1; i<n; i++) {
            uglyArray[i] = Math.min(Math.min(uglyArray[i2] * 2 , uglyArray[i3] * 3), uglyArray[i5] *5);

            if (uglyArray[i] == uglyArray[i2] * 2) i2++;
            if (uglyArray[i] == uglyArray[i3] * 3) i3++;
            if (uglyArray[i] == uglyArray[i5] * 5) i5++;
        }

        return uglyArray[n-1];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }
}
