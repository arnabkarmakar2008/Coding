package com.example.coding.dynamicprogramming.leetcode.classic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents
 * the width and the height of an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope
 * are greater than the other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 *
 * Note: You cannot rotate an envelope.
 */
public class RussianDoll {

  /*
  This is same as longest increasing sequence. Just need to sort the 2d array.
   */
  public static int maxEnvelopes(int[][] envelopes) {
    int maxResult = Integer.MIN_VALUE;
    Arrays.sort(envelopes, Comparator.comparingInt(envelope -> envelope[0]));

    int[] dp = new int[envelopes.length];
    Arrays.fill(dp, 1);

    for (int i=1; i<envelopes.length; i++) {
      for (int j=0; j < i; j++) {
        if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
          maxResult = Math.max(maxResult, dp[i]);
        }
      }
    }

    return maxResult;
  }

  public static void main(String[] args) {
    int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
    System.out.println(maxEnvelopes(envelopes));
  }
}
