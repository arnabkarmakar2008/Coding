package com.example.coding.dynamicprogramming.leetcode.string;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 */
public class LongestValidParentheses {

  /**        0 1 2 3 4 5 6 7 8 9 10 11
   * Input = ( ) ( ( ) ) ) ( ) ) (  )
   * We have to use stack and put -1 as first element. We have to put -1 as we have to consider 0th element
   * as well here.
   *
   * If open bracket put in stack.
   * If close bracket, then pop. Now if stack if empty then push the current index. Else calculate max length.
   *
   *
   * Now max = Math.max(max, i - topOfStack)
   *
   * @param s
   * @return
   */
  public static int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int max = Integer.MIN_VALUE;

    for (int i=0; i<s.length(); i++) {

      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();

        if (stack.empty()) {
          stack.push(i);
        } else {
          max = Math.max(max, i - stack.peek());
        }
      }
    }

    return max;
  }

  /**
   * This can be solved without using extra space.
   * To form valid parantheses we have to have the same number of open and close parantheses.
   * But there is a catch. We have to traverse string from left to right. And at anypoint if the number of
   * open paran is greater than close then at that point string in not valid. But at anypoint if
   * open == close then length of valid paran is equal to open + close count.
   *
   * @param args
   */

  public static int longestValidParenthesesWithoutSpace(String s) {
    int max = Integer.MIN_VALUE;
    int open = 0;
    int close = 0;

    //traverse string from left to right
    for (int i=0; i<s.length(); i++) {

      if (s.charAt(i) == '(') {
        open++;
      } else {
        close++;
      }

      if (open == close) {
        max = Math.max(max, open+close);
      } else if (close > open) {
        //This means till this point string is invalid. Start fresh.
        open = 0;
        close = 0;

      }
    }

    open = close = 0;
    //traverse string from right to left
    for (int i=s.length()-1; i>=0; i--) {

      if (s.charAt(i) == '(') {
        open++;
      } else {
        close++;
      }

      if (open == close) {
        max = Math.max(max, open+close);
      } else if (open > close) {
        //This means till this point string is invalid. Start fresh.
        open = 0;
        close = 0;

      }
    }

    return max;
  }


  public static void main(String[] args) {
    String input = ")()())";
    System.out.println(longestValidParentheses(input));
  }
}
