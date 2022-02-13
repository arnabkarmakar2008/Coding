package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

import java.util.ArrayList;
import java.util.Stack;

public class AllNodeAtKDistance {

  public static void kDown(Node targetNode, int k, Node blockerNode, ArrayList<Integer> answer) {
    if (k < 0 || targetNode == null || targetNode == blockerNode) {
      return;
    }

    if (k == 0) {
      answer.add(targetNode.key);
      return;
    }

    kDown(targetNode.left, k-1, blockerNode, answer);
    kDown(targetNode.right, k-1, blockerNode, answer);

  }

  public static boolean rootToNode(Node root, int target, Stack<Node> stack) {
    if (root == null) {
      return false;
    }

    // Push node in stack
    stack.push(root);

    if (root.key == target) {
      return true;
    }

    boolean leftTraversal = rootToNode(root.left, target, stack);

    if (leftTraversal == true) {
      return true;
    } else if (rootToNode(root.right, target, stack)) {
      return true;
    } else {
      // Target node is not there in left and right subtree. So remove.
      stack.pop();
      return false;
    }
  }

  public static void allKDistanceNodes(Node root, int targetNode ,int k) {
    // First get ode to root path for target node
    Stack<Node> targetToRootPath = new Stack<>();
    rootToNode(root, targetNode, targetToRootPath);

    ArrayList<Integer> answer = new ArrayList<>();

    int distance = 0;
    Node previousNode = null;
    while (!targetToRootPath.isEmpty() && distance <= k) {
      Node currentNode = targetToRootPath.pop();
      kDown(currentNode, k - distance, previousNode, answer); // Have to do k - distance as we are travelling that
      // much distance and then we have to travel further
      distance++;
    }

    System.out.println(answer.size());
  }

  public static void main(String[] args) {
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(5);
    root1.right.left = new Node(6);
    root1.right.right = new Node(7);

    root1.right.right.left = new Node(8);
    root1.right.right.right = new Node(9);

    root1.right.right.left.left = new Node(10);
    root1.right.right.left.left.left = new Node(14);
    root1.right.right.left.left.right = new Node(13);

    allKDistanceNodes(root1, 8, 2);
  }
}
