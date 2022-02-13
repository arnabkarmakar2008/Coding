package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

import java.util.Stack;

public class RootToNodePath {

  public static boolean rootToNode(Node root, int target, Stack<Integer> stack) {
    if (root == null) {
      return false;
    }

    stack.push(root.key);

    if (root.key == target) {
      return true;
    }

    boolean leftTraversal = rootToNode(root.left, target, stack);

    if (leftTraversal == true) {
      return true;
    } else if (rootToNode(root.right, target, stack)) {
      return true;
    } else {
      stack.pop();
      return false;
    }
  }

  public static void main(String[] args) {
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(5);
    root1.right.left = new Node(6);
    root1.right.right = new Node(7);

    Stack<Integer> stack = new Stack<>();

    rootToNode(root1, 7, stack);

    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }
}
