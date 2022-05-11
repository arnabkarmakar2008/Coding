package com.example.coding.bst.basic;

import com.example.coding.tree.Node;

public class BinarySearchTree {

  public static Node search(Node node, int key) {
    if (node == null || node.key == key) {
      return node;
    }

    if (key > node.key) {
      return search(node.right, key);
    }

    return search(node.left, key);

  }

  /**
   * A new key is always inserted at the leaf. We start searching a key from the root until we hit a
   * leaf node. Once a leaf node is found, the new node is added as a child of the leaf node.
   * @param root
   * @param newKey
   */
  public static Node insert(Node root, int newKey) {
    if (root == null) {
      root = new Node(newKey);
      return root;
    }

    if (newKey < root.key) {
      root.left = insert(root.left, newKey);
    } else {
      root.right = insert(root.right, newKey);
    }

    return root;
  }

  public static Node insertUsingLoop(Node root, int newKey) {
    if (root == null) {
      root = new Node(newKey);
      return root;
    }

    Node previous = null;
    Node temp = root;

    while (temp != null) {
      if (temp.key < newKey) {
        previous = temp;
        temp = temp.right;
      } else {
        previous = temp;
        temp = temp.right;
      }
    }

    //temp is null now. So previous is the leaf node. We have to place new node as leaf of previous
    if (newKey > previous.key) {
      previous.right = new Node(newKey);
    } else {
      previous.left = new Node(newKey);
    }

    return root;
  }

  /**
   *
   * @param root
   * @param key
   * @return
   */
  public static Node deleteNode(Node root, int key) {
    if (root == null) {
      return null;
    }

    if (root.key == key) {
      return deleteHelper(root);
    }

    Node dummy = root;

    while (root != null) {
      if (key < root.key) {
        if (root.left != null && root.left.key == key) {
          root.left = deleteHelper(root.left);
          break;
        } else {
          root = root.left;
        }
      } else {
        if (root.right != null && root.right.key == key) {
          root.right = deleteHelper(root.right);
          break;
        } else {
          root = root.right;
        }
      }
    }

    return dummy;
  }

  /**
   * root is the node to be deleted.
   * So have to find the rightmost node from left subtree.
   * Then set right subtree of root as right subtree of previous.
   *
   * 8 (5 9) ((4 6) (7 10))
   * Lets say we have to delete node 8. So rightmost node of left tree is 6. We have tp set 9 as right tree of 6.
   * @param root
   * @return
   */
  public static Node deleteHelper(Node root)  {
    if (root.left == null) {
      return root.right;
    }

    if (root.right == null) {
      return root.left;
    }

    Node rightNode = root.right;
    Node rightMostLeftNode = findRightMostLeftNode(root.left);
    rightMostLeftNode.right = rightNode;
    return root.left;
  }

  private static Node findRightMostLeftNode(Node root) {
    if (root.right == null) {
      return root;
    }
    return findRightMostLeftNode(root.right);
  }

  public static void main(String[] args) {

  }
}
