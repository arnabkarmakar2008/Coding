package com.example.coding.math.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * A super ugly number is a positive integer whose prime factors are
 * in the array primes.
 *
 * Given an integer n and an array of integers primes, return the nth super ugly number.
 *
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class SuperUglyNumber {

    /**
     * https://www.youtube.com/watch?v=0FMKNDEopR0
     *
     *
     * Similar to Ugly Number II. We will not keep pointers for all primes like Ugly number II.
     * Instead we will keep array of pointers.
     *
     * primes[] = {3,5,7,11}
     *
     * pointers[] =  {1,1,1,1}
     * dp[] = {1, }
     *
     * 3 * 1 = 3
     * 5 * 1 = 5
     * 7 *1 = 7
     * 11 *1 = 11
     *
     * Min of above will next super ugly. Which is 3. Increase pointer of 3
     *
     * pointers[] {2, 1, 1, 1}
     * dp[] = {1,3,}
     *
     * 3 * 3 = 9
     * 5 * 1 = 5
     * 7 *1 = 7
     * 11 *1 = 11
     * Next number is 5.
     * pointers[] {2, 2, 1, 1}
     * dp[] = {1,3,5}
     *
     * 3*3 = 9
     * 5 * 3 = 15
     * 7*1 = 7
     * 11*1 = 11
     *
     * Next number is 7
     *
     * pointers[] {2, 2, 2, 1}
     * dp[] = {1,3,5,7....}
     *
     * primes[j] * dp [pointer[j]]
     *
     * O(NK). So can be optimized
     *
     * @param n
     * @param primes
     * @return
     */
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i <=n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j=0; j<primes.length; j++) {
                min = Math.min(min, primes[j] * dp[pointers[j]]);
            }

            dp[i] = min;
            for (int j=0; j<primes.length; j++) {
                if (dp[i] == primes[j] * dp[pointers[j]]) {
                    pointers[j]++;
                }
            }

        }

        return dp[n];
    }

    public static class Pair implements Comparable<Pair> {
        int prime;
        int pointer;
        int value;

        public Pair(int prime, int pointer, int value) {
            this.prime = prime;
            this.pointer = pointer;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }

    /**
     *
     * ONLogK
     * With PQ
     * @param n
     * @param primes
     * @return
     */
    public static int nthSuperUglyNumberUsingPQ(int n, int[] primes) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 0; i < primes.length; i++) {
            pq.add(new Pair(primes[i],1, primes[i]));
        }

        for (int i = 2; i <=n; i++) {
            Pair lowestPair = pq.remove();

            if (dp[i-1] != lowestPair.value) { // check duplicate. If duplicate do nt add to dp array
                dp[i] = lowestPair.value;
            }

            Pair newPair = new Pair(lowestPair.prime, lowestPair.pointer+1,
                    dp[lowestPair.pointer+1] * lowestPair.prime);
            pq.add(newPair);

        }

        return dp[n];
    }


    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2,7,13,19};
        System.out.println(nthSuperUglyNumber(n, primes));
    }
}
