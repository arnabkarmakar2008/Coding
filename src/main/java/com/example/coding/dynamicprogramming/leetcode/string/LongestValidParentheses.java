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
   * If open bracket put in stack. If close bracket and top of stack is open then pop stack.
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
        int stackTop = stack.peek(); //Check if top of stack is open bracket

        if (stackTop != -1 && s.charAt(stackTop) == '(') {
          //If open bracket, then pop and calculate max

          stack.pop();

          max = Math.max(max, i - stack.peek());
        } else {

          //else push the index of close bracket
          stack.push(i);
        }
      }
    }

    return max;
  }


  public static void main(String[] args) {
    String input = ")()())";
    System.out.println(longestValidParentheses(input));
  }
}
