package com.example.coding.math.leetcode.medium;

/**
 * Given an integer n, break it into the sum of k positive integers,
 * where k >= 2, and maximize the product of those integers.
 *
 * Return the maximum product you can get.
 */
public class IntegerBreak {

    /**
     * We can write a function like f(n) which will return the max product.
     *
     * f(n) -> k * f(n-k)
     * k can range from 1..n-1
     *
     * f(5) -> 2 * f(3)
     * Now f(3) will be 2*1 = 2.
     *
     * So f(5) = 2 * 2 = 4. But if we do not take f(3) and take only 3 then f(5) will be 2*3 = 6
     *
     * So f(n) -> k * max (f(n-k), (n-k))
     *
     * This can be solved using dp as we have same states multiple times
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(dp[i-j], i-j));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
