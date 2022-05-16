package com.example.coding.search.leetcode.medium;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the
 * integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
public class SqrtX {

  public static int mySqrt(int x) {

    int low = 1;
    int high = x;
    int answer = -1;

    while (low <= high) {
      int mid = low + (high-low)/2; // low+high/2 can cause overflow. So always do like this.

      if (mid <= x/mid) { // mid*mid can cause overflow. So to reduce it do like x/mid.
        answer = mid;
        low = mid+1;
      } else {
        high = mid-1;
      }
    }

    return answer;

  }

  public static void main(String[] args) {
    int x = 8;
    System.out.println(mySqrt(x));
  }
}
