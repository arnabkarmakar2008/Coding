package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10^n.
 */
public class CountNumberWithUniqueDigits {

  /*
  Note :: For 0 -> 0
  For single digit all are unique 1,2,3,4,5,6,7,8,9 = 9
  For Double Digit :: At 10th place we can choose from 1..9. Lets say we are choosing 8. So we cannot choose 8
  as second digit. But we can choose from 0,1,2,3,4,5,6,7,9 which is count=9. So total 2 digits unique numbers are
  9*9 = 81.

  So for n=2 i.e from 0 -> 100 we have 1 + 9 + 81 = 91

  For n =3 i.e. from 0 -> 1000 1 + 9 + (9*9) + (9 * 9 * 8)
  For n=4 i.e from 0 ->  10000 1 + 9 + (9*9) + (9 * 9 * 8) + (9 * 9 * 8 * 7)
   */
  public static int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
      return 1;
    }

    int answer = 10; // For n=1 i.e 10^1  = 10, we have 0,1,2,3,4,5,6,7,8,9 = 10

    int current = 9;
    int start = 9;

    while (n > 1) {
      current = current * start;
      answer = answer + current;
      start--;
      n--;
    }

    return answer;
  }

  public static void main(String[] args) {
    int n = 4;
    System.out.println(countNumbersWithUniqueDigits(3));
  }
}
