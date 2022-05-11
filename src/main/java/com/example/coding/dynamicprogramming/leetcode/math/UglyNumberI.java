package com.example.coding.dynamicprogramming.leetcode.math;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return true if n is an ugly number.
 */
public class UglyNumberI {

  /**
   * This is not a DP problem. But other Ugly Numbers are....
   * @param num
   * @return
   */
  public static boolean isUgly(int num) {
    while (num % 2 == 0) num = num/2;
    while (num % 3 == 0) num = num/3;
    while (num % 5 == 0) num = num/5;

    return num == 1;

  }

  public static void main(String[] args) {
    System.out.println(isUgly(7));
  }
}
