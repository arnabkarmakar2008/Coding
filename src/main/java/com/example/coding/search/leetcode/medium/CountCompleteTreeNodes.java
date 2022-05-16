package com.example.coding.search.leetcode.medium;

import com.example.coding.tree.Node;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 */
public class CountCompleteTreeNodes {

  /**
   * log(N) for findig height and another log(N) for traversing. So O(logN)^2
   * @param root
   * @return
   */
  public static int countNodes(Node root) {

    if (root == null) {
      return 0;
    }

    int leftHeight = leftHeight(root.left);
    int rightHeight = righhtHeight(root.right);

    //if left and right height are same, then use formula 2^h+1 to get the node.
    if (leftHeight == rightHeight) {
      int result = (int)Math.pow(2, leftHeight) + 1;
      return result;
    }

    //else recursively calculate number of nodes in left and right
    return 1 + countNodes(root.left) + countNodes(root.right);

  }

  private static int leftHeight(Node root) {
    int count = 0;

    while (root.left != null) {
      count++;
      root = root.left;
    }

    return count;
  }

  private static int righhtHeight(Node root) {
    int count = 0;

    while (root.right != null) {
      count++;
      root = root.right;
    }

    return count;
  }


  public static void main(String[] args) {
    Node root= new Node(1);
    root.left = new Node(2);
    root.right = new Node(8);
    root.right.left = new Node(9);
    root.left.left = new Node(3);
    root.left.right = new Node(4);
    System.out.println(countNodes(root));
  }
}
