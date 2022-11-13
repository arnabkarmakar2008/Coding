package com.example.coding.dynamicprogramming.leetcode.knapsack;

public class IIKeysKeyBoard {

  /**
   * There is only one character 'A' on the screen of a notepad.
   * You can perform one of two operations on this notepad for each step:
   *
   * Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
   * Paste: You can paste the characters which are copied last time.
   * Given an integer n, return the minimum number of operations to get the character
   * 'A' exactly n times on the screen.
   *
   *
   * https://www.youtube.com/watch?v=jGol-NUnjaY&t=906s
   * @param n
   * @return
   */
  public static int minSteps(int n) {
    int current = 1;
    int buffer = 0;
    int answer = 0;

    while (current < n) {
      int rest = n-current;

      //This block is for CP
      if (rest % current == 0) {
        buffer = current;
        current = current + buffer;
        answer +=2;
      } else {
        //This is for P only
        current = current + buffer;
        answer +=1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    int n = 7;
    System.out.println(minSteps(n));
  }
}
