package com.example.coding.recursion;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class AddBottomOfStack {

  public static void main(String[] args) {
    Vector<Integer> vec= new Vector<>();
    vec.addAll(Arrays.asList(1,2,3,4,5));

    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(1,2,3,4,5));

    int element = 6;
    addAtBottom(stack, element);
    while (!stack.isEmpty()) {
      System.out.print(" " + stack.pop());
    }
  }

  public static void addAtBottom(Stack<Integer> stack, int element) {
    if (stack.size() == 0) {
      stack.add(element);
      return;
    }

    int temp = stack.pop();
    addAtBottom(stack, element);
    stack.add(temp);
  }
}
