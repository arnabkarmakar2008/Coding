package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees)
 * which has exactly n nodes of unique values from 1 to n.
 */
public class UniqueBinarySearchTrees {

  /**
   * Note :
   * Node      Tree
   * 0      :  1
   * 1      :  1
   * 2      : 2
   * 3      : 5
   * 5      : 14
   *
   * Node(10,20,30,40)
   * Root = 10 :: Left -> X, Right -> [20,30,40] :: 1 * 5
   * Root = 20 :: Left -> [10] Right -> [30,40] :: 1 * 2
   * Root = 30 :: Left -> [10,20] Right -> [40] :: 2 * 1
   * Root = 40 :: Left -> [10,20,30] Right -> [X] :: 5 * 1
   *
   * f(4) = f(0)*f(3) + f(1)*f(2)  + f(2)*f(1) + f(3)*f(0)
   *
   * This is called CATALAN Number
   */

  public static int numberOfTrees(int number) {
    int[] dp = new int[number+1];

    dp[0] = 1;
    dp[1] = 1;

    for (int i=2; i<=number; i++) {
      int left = 0;
      int right = i-1;

      while (left <= i-1) {
        dp[i] += dp[left] * dp[right];
        left++;
        right--;
      }
    }

    return dp[number];
  }

  public static void main(String[] args) {
    System.out.println("Number of BST :: " + numberOfTrees(5));
  }
}
