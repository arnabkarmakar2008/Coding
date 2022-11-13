package com.example.coding.twopointers.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
public class HappyNumber {

  /**
   * https://leetcode.com/problems/happy-number/discuss/56913/Beat-90-Fast-Easy-Understand-Java-Solution-with-Brief-Explanation
   * If we keep on adding sq of digits, it will produce same number after some point if number is not happy
   * So using hashset to detect that.
   * @param n
   * @return
   */
  public static boolean isHappy(int n) {
    Set<Integer> hashSet = new HashSet<>();

    while (hashSet.add(n)) {
      int sqsum = 0;

      while ( n > 0) {
        int rem = n % 10;
        sqsum += rem*rem;
        n = n / 10;
      }

      if (sqsum == 1) {
        return true;
      } else {
        n = sqsum;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int n = 2;
    System.out.println(isHappy(n));
  }
}
