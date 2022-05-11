package com.example.coding.backtracking.leetcode.medium;

import com.example.coding.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

  public static List<String> binaryTreePaths(Node root) {
    List<String> resultList = new ArrayList<>();
    paths(root, "", resultList);
    return resultList;
  }

  private static void paths(Node root, String currentString, List<String> resultList) {
    if (root.left == null && root.right == null) {
      resultList.add(currentString +root.key);
      return;
    }

    if (root == null) {
      return;
    }

    String st = currentString + root.key + "->";
    if (root.left != null) paths(root.left, st, resultList);
    if (root.right != null)paths(root.right, st, resultList);
  }

  public static void main(String[] args) {
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(7);
    root1.right.left = new Node(6);
    root1.right.right = new Node(7);

    List<String> paths = binaryTreePaths(root1);
    System.out.println(paths);
  }
}
