package com.example.coding.twopointers.leetcode.medium;

import com.example.coding.tree.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class TwoSumIV {

  public static boolean findTarget(Node root, int k) {
    return dfs(root, k, new HashSet<>());
  }

  public static boolean dfs(Node root, int target, Set<Integer> hashSet) {
    if (root == null) {
      return false;
    }

    int reminder = target - root.key;
    if (hashSet.contains(reminder)) {
      return true;
    } else {
      hashSet.add(root.key);
    }
    return dfs(root.left, target, hashSet) || dfs(root.right, target, hashSet);
  }

  public static void main(String[] args) {
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(7);
    root1.right.left = new Node(6);
    root1.right.right = new Node(7);

    System.out.println(findTarget(root1, 10));
  }
}
