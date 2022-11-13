package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

/**
 * https://www.youtube.com/watch?v=2r5wLmQfD6g
 *
 *
 * See solution from here. Striver.
 */
public class BurningTree {

  public static int maxTime = 0;

  public static void burnTree(Node root, Node blockNode, int time) {
    if (root == null || root == blockNode) {
      return;
    }

    maxTime = Math.max(maxTime, time);
    burnTree(root.left, blockNode, time+1);
    burnTree(root.right, blockNode, time+1);
  }

  public static int burningTree(Node root, int fireNode) {
    if (root == null) {
      return -1;
    }

    if (root.key == fireNode) {
      burnTree(root, null, 0);
      return 1;
    }

    int leftTime = burningTree(root.left, fireNode);
    if (leftTime != -1) {
      // Found fireNode in left subtree
      burnTree(root, root.left, leftTime);
      return leftTime+1; // Returning +1 to parent as burnig parent will take lefttime+1 secs
    }

    int rightTime = burningTree(root.right, fireNode);
    if (rightTime != -1) {
      // Found fireNode in right subtree
      burnTree(root, root.right, rightTime);
      return rightTime+1; // Returning +1 to parent as burnig parent will take lefttime+1 secs
    }

    return -1;
  }


  public static void main(String[] args) {

  }
}
