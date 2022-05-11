package com.example.coding.dynamicprogramming.leetcode.math;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A super ugly number is a positive integer whose prime factors are in the array primes.
 *
 * Given an integer n and an array of integers primes, return the nth super ugly number.
 *
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class SuperUglyNumbers {

  static class Pair {
    int primeNumber;
    int primePointer;
    int value;

    Pair(int primeNumber, int primePointer, int value) {
      this.primeNumber = primeNumber;
      this.primePointer = primePointer;
      this.value = value;
    }
  }

  /**
   * Brute force o(n*2k)
   * @param n
   * @param primes
   * @return
   */
  public static int nthSuperUglyNumber(int n, int[] primes) {
    int[] dp = new int[n];
    int[] pointerPositionArray = new int[primes.length];

    dp[0] = 1;

    for (int i=1; i<n; i++) {
      int min = 0;
      for (int k=0; k<pointerPositionArray.length; k++) {
        min = Math.min(min, dp[pointerPositionArray[k]] * primes[k]);
      }

      dp[i] = min;

      for (int k=0; k<pointerPositionArray.length; k++) {
       if (dp[pointerPositionArray[k]] * primes[k] == min) {
         pointerPositionArray[k]++;
       }
      }
    }

    return dp[n-1];
  }

  /**
   * https://www.youtube.com/watch?v=0FMKNDEopR0
   * @param n
   * @param primes
   * @return
   */
  public static int nthSuperUglyNumberPQ(int n, int[] primes) {
    int[] dp = new int[n];
    dp[0] = 1;
    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.value));

    for (int prime : primes) {
      pq.add(new Pair(prime, 0, (prime * dp[0])));
    }

    for (int i=1; i<n; ) {
      //Remove the lowest pair.
      Pair pairWithLowestVal = pq.poll();

      if (dp[i-1] != pairWithLowestVal.value) {
        //same number we do not generate ugly number

        dp[i] = pairWithLowestVal.value;
        i++;
      }

      //Increase pointer of the lowest and set the ew value
      pq.add(new Pair(pairWithLowestVal.primeNumber, pairWithLowestVal.primePointer+1, pairWithLowestVal.primeNumber * dp[pairWithLowestVal.primePointer+1]));
    }

    return dp[n-1];
  }

  public static void main(String[] args) {
    int n = 12;
    int[] primes = {2,7,13,19};

    System.out.println(nthSuperUglyNumberPQ(n, primes));
  }
}


