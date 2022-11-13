package com.example.coding.dynamicprogramming.leetcode.knapsack;

/**
 * Imagine you have a special keyboard with the following keys:
 *
 * Key 1:  Prints 'A' on screen
 * Key 2: (Ctrl-A): Select screen
 * Key 3: (Ctrl-C): Copy selection to buffer
 * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
 *
 * Find maximum numbers of A's that can be produced by pressing keys on the special keyboard N times.
 */
public class FourKeysKeyBoard {


  /**
   * https://www.youtube.com/watch?v=c_y7H7qZJRU
   * N=1   1
   * N=2   2
   * N=3   3
   * N=4   4 (1 1 1 1) 2 (1 A C V)
   * N=5   5 (1 1 1 1 1) 4 (1 1 A C V) 3 (1 A C V V)
   * N=6   6 (1 1 1 1 1 1) 6 (1 1 1 A C V) 6 (1 1 A C V V) 4 (1 A C V V V) = 6
   * N=7   7 (1 1 1 1 1 1 1) 8(1 1 1 1 A C V) 9(1 1 1 A C V V) 8(1 1 A C V V V) 5(1 A C V V V V) = 9
   *
   *
   * N=10  10(1 1 1 1 1 1 1 1 1 1) 7*2(1 1 1 1 1 1 1 A C V) 6*3(1 1 1 1 1 1 A C V V) 5*4(1 1 1 1 1 A C V V V) 4*5(1 1 1 1 A C V V V V) 3*6(1 1 1 A C V V V V V)
   *
   * 7*2(1 1 1 1 1 1 1 A C V) :: We are going to what is the max print for N=7. It is 9. So answer will be 9*2 = 18
   * 6*3(1 1 1 1 1 1 A C V V) :: Max for N=6 = 6 So answer = 6*3 = 18
   *
   * @param n
   * @return
   */
  public static int findMaxA(int n) {
    int[] dp = new int[n+1];

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    dp[4] = 4;
    dp[5] = 5;
    dp[6] = 6;

    for (int i=7; i<=n; i++) {
      for (int j = i-3; j>0; j--) {
        int current = dp[j] * (i-j-1); // N=10 7*2(1 1 1 1 1 1 1 A C V) i=10, j=7 (i-3), Multiply by i-j-1 (10-7-1 = 2)
        if (current > dp[i]) {
          dp[i] = current;
        }
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    int n = 8;
    System.out.println(findMaxA(n));
  }
}
