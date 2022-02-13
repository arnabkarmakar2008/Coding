package com.example.coding.dynamicprogramming.leetcode.knapsack;

public class IIKeysKeyBoard {

  public static int minSteps(int n) {
    int answer = 0;

    for (int i=2; i*i <= n;) {
      if (n%i == 0) {
        answer += i;

        n /= i;
      } else {
        i++;
      }
    }

    if (n != 1) {
      answer += n;
    }

    return answer;
  }

  public static void main(String[] args) {
    int n = 8;
    System.out.println(minSteps(n));
  }
}
