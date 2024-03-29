package com.example.coding.backtracking.leetcode.medium;

import com.example.coding.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf
 * paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node.
 * A leaf is a node with no children.
 */
public class PathSumII {

  public static List<List<Integer>> pathSum(Node root, int targetSum) {
    List<List<Integer>> results = new ArrayList<>();

    findPaths(root, targetSum, new ArrayList<Integer>(), results);

    return results;
  }

  private static void findPaths(Node root, int targetSum, ArrayList<Integer> currentList, List<List<Integer>> paths) {
    if (root == null) {
      return;
    }

    if (targetSum == root.key && root.left == null && root.right == null) {
      currentList.add(root.key);
      paths.add(new ArrayList<>(currentList));
      return;
    }

    currentList.add(root.key);
    //Note how we have to backtrack before calling right subtree
    if (root.left != null) {
      findPaths(root.left, targetSum - root.key, currentList, paths);
      currentList.remove(currentList.size()-1);
    }

    if (root.right != null) {
      findPaths(root.right, targetSum - root.key, currentList, paths);
      currentList.remove(currentList.size()-1);
    }

  }


  public static void main(String[] args) {
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(7);
    root1.right.left = new Node(6);
    root1.right.right = new Node(7);

    List<List<Integer>> paths = pathSum(root1, 10);
    System.out.println(paths);
  }
}
