package com.example.coding.bst.leetcode;

import com.example.coding.tree.Node;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if ((root.left != null && root.key < root.left.key) || (root.right != null && root.key > root.right.key)) {
            return false;
        }

        boolean leftFlag = isValidBST(root.left);
        boolean rightFlag = isValidBST(root.right);

        return leftFlag && rightFlag;
    }

    public static void main(String[] args) {

    }
}
