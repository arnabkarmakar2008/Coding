package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BalancedParentheses {

  public static List<String> generateParenthesis(int n) {
    List<String> stringList = new ArrayList<>();
    recursion(n, n, "", stringList);
    return stringList;
  }

  public static void recursion(int openCount, int closeCount, String currentString, List<String> stringList) {
    //base
    if (closeCount == 0 && openCount == 0) {
      stringList.add(currentString);
      return;
    }

    if (openCount == closeCount) {
      currentString = currentString + "(";
      recursion(openCount-1, closeCount, currentString, stringList);
    } else if (openCount == 0) {
      currentString = currentString + ")";
      recursion(openCount, closeCount-1, currentString, stringList);
    } else {
      recursion(openCount-1, closeCount, currentString + "(", stringList);
      recursion(openCount, closeCount-1, currentString + ")", stringList);
    }
  }

  public static void main(String[] args) {
    List<String> list = generateParenthesis(5);
    System.out.println(list);
  }
}
