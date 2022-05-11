package com.example.coding.backtracking.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string s that contains parentheses and letters, remove the minimum number
 * of invalid parentheses to make the input string valid.
 *
 * Return all the possible results. You may return the answer in any order.
 */
public class RemoveInvalidParantheses {

  /**
   * https://www.youtube.com/watch?v=Cbbf5qe5stw
   * @param s
   * @return
   */
  public static List<String> removeInvalidParentheses(String s) {
    int invalidCount = numberOfInvalid(s);
    List<String> resultList = new ArrayList<>();
    generateValidParantheses(s, invalidCount, resultList);
    return resultList;
  }

  public static void generateValidParantheses(String s, int invalidCount, List<String> resultList) {

    if (invalidCount == 0) {
      if (numberOfInvalid(s) == 0)
        resultList.add(s);
      return;
    }

    for (int i=0; i < s.length(); i++) {
      String left = s.substring(0,i);
      String right = s.substring(i+1);
      generateValidParantheses(left+right, invalidCount-1,resultList);
    }

  }

  public static int numberOfInvalid(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i=0; i<s.length(); i++) {
      char c = s.charAt(i);

      if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        if (stack.isEmpty()) {
          stack.push(c);
        } else {
          if (stack.peek() == '(') {
            stack.pop();
          } else {
            stack.push(c);
          }
        }
      }
    }

    return stack.size();
  }


  public static void main(String[] args) {
    String s = "()())()";
    List<String> result = removeInvalidParentheses(s);
    System.out.println(result);
  }
}
